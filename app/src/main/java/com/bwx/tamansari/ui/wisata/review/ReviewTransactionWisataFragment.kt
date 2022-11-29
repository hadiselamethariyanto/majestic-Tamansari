package com.bwx.tamansari.ui.wisata.review

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionWisataBinding
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewTransactionWisataFragment :
    BaseFragment<FragmentReviewTransactionWisataBinding>(FragmentReviewTransactionWisataBinding::inflate) {

    private val viewModel: ReviewWisataViewModel by viewModel()

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

        val charts = arguments?.getParcelableArrayList<ChartDomain>("charts") ?: arrayListOf()
        val wisata = arguments?.getParcelable<WisataDomain>("wisata")

        val totalPayment = charts.sumOf { it.total * it.productPrice }
        val photos = wisata?.photos ?: arrayListOf()
        if (photos.isNotEmpty()) {
            Glide.with(requireActivity()).load(photos[0]).placeholder(R.drawable.placeholder)
                .into(binding.imgWisata)
        }
        binding.tvWisataName.text = wisata?.name

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                setupProfile(firebaseUser)
            }
        }

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(totalPayment)}"
        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(totalPayment)}"

        val adapter = ReviewTransactionWisataAdapter()
        adapter.updateData(charts)
        binding.rvChart.adapter = adapter

        val user = viewModel.user.value

        binding.btnPayment.setOnClickListener {
            viewModel.insertTransactionWisata(
                customerName = user?.displayName ?: "",
                customerEmail = user?.email ?: "",
                customerPhoneNumber = "123",
                fee = totalPayment,
                convenienceFee = 5000,
                totalFee = totalPayment + 5000,
                idWisata = wisata?.id ?: "",
                charts = charts
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
                                R.id.action_navigation_review_transaction_wisata_to_navigation_choose_payment_method,
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

    private fun setLoading(isLoading: Boolean) {
        binding.btnPayment.isEnabled = !isLoading
    }

    private fun setupProfile(user: FirebaseUser) {
        binding.tvCustomerName.text = user.displayName
        binding.tvCustomerPhone.text = user.phoneNumber
        binding.tvCustomerEmail.text = user.email
    }
}