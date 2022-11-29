package com.bwx.tamansari.ui.homestay.review_transaction

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel


class ReviewTransactionHomestayFragment : BaseFragment<FragmentReviewTransactionHomestayBinding>(
    FragmentReviewTransactionHomestayBinding::inflate
) {

    private val viewModel: ReviewTransactionHomestayViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController()

        val currentBackStackEntry = navController.currentBackStackEntry!!
        val savedStateHandle = currentBackStackEntry.savedStateHandle
        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry) { success ->
                if (!success) {
                    val startDestination = navController.graph.startDestinationId
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(startDestination, true)
                        .build()
                    navController.navigate(startDestination, null, navOptions)
                }
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homestay = arguments?.getParcelable<HomestayDomain>("homestay")
        val room = arguments?.getParcelable<AvailableRoomDomain>("room")
        val checkinDate = arguments?.getString("checkin")
        val checkoutDate = arguments?.getString("checkout")

        val dateDifference = getDateDifference(checkinDate ?: "", checkoutDate ?: "")
        val totalFee = (room?.price ?: 0) * dateDifference

        binding.tvHomestayName.text = homestay?.name
        binding.tvCheckInHour.text = homestay?.checkIn
        binding.tvCheckOutHour.text = homestay?.checkOut
        binding.tvRoomName.text = "1 x ${room?.name}"
        binding.roomCapacity.text = "${room?.capacity} Tamu"
        binding.bedType.text = room?.bedType
        binding.tvBreakfast.text =
            if (room?.breakfast == true) "Sarapan tersedia" else "Sarapan tidak tersedia"
        binding.tvCheckIn.text = checkinDate
        binding.tvCheckOut.text = checkoutDate

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                setupProfile(firebaseUser)
            }
        }

        val photo = homestay?.photos ?: arrayListOf()
        Glide.with(requireActivity()).load(photo[0]).placeholder(R.drawable.placeholder)
            .transform(
                CenterCrop(), RoundedCorners(20)
            )
            .into(binding.imgHomestay)

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(totalFee)}"

        binding.btnPayment.setOnClickListener {
            val user = viewModel.user.value

            user.let {
                viewModel.insertTransaction(
                    customerName = it?.displayName ?: "",
                    customerEmail = it?.email ?: "",
                    customerPhoneNumber = "08213231",
                    fee = totalFee,
                    convenienceFee = 0,
                    totalFee = totalFee,
                    idHomestay = homestay?.id ?: "",
                    idRoom = room?.id ?: "",
                    checkIn = Utils.formatStringDateToYYYYMMDD(checkinDate ?: ""),
                    checkOut = Utils.formatStringDateToYYYYMMDD(checkoutDate ?: ""),
                    totalPerson = 1
                ).observe(viewLifecycleOwner) { res ->
                    when (res) {
                        is Resource.Loading -> {
                            setLoading(true)
                        }
                        is Resource.Success -> {
                            setLoading(false)
                            if (res.data != null) {
                                val bundle = bundleOf("transaction" to res.data)
                                findNavController().navigate(
                                    R.id.action_navigation_review_transaction_homestay_to_navigation_choose_payment_method,
                                    bundle
                                )
                            }
                        }
                        is Resource.Error -> {
                            setLoading(false)
                            Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

    }

    private fun setLoading(isLoading: Boolean) {
        binding.btnPayment.isEnabled = !isLoading
    }


    private fun setupProfile(user: FirebaseUser) {
        binding.tvCustomerName.text = user.displayName
        binding.tvCustomerPhone.text = user.phoneNumber
        binding.tvCustomerEmail.text = user.email
    }

    private fun getDateDifference(firstDate: String, secondDate: String): Int {
        val date1 = Utils.formatStringDateToLong(firstDate)
        val date2 = Utils.formatStringDateToLong(secondDate)

        val diff = date2 - date1
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        return days.toInt()
    }

}