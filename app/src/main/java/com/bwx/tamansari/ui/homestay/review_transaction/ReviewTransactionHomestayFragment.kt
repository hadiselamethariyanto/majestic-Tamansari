package com.bwx.tamansari.ui.homestay.review_transaction

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
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

    }

    private fun setupProfile(user: FirebaseUser) {
        binding.tvCustomerName.text = user.displayName
        binding.tvCustomerPhone.text = user.phoneNumber
        binding.tvCustomerEmail.text = user.email
    }

}