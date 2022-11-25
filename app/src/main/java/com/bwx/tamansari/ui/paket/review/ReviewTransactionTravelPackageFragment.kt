package com.bwx.tamansari.ui.paket.review

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import banyuwangi.digital.core.domain.model.TravelPackageTypeDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionTravelPackageBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel


class ReviewTransactionTravelPackageFragment :
    BaseFragment<FragmentReviewTransactionTravelPackageBinding>(
        FragmentReviewTransactionTravelPackageBinding::inflate
    ) {

    private val viewModel: ReviewTransactionTravelPackageViewModel by viewModel()

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

        val travelPackageDomain = arguments?.getParcelable<TravelPackageTypeDomain>("package_type")
        val travelPackage = arguments?.getParcelable<TravelPackageDomain>("package")
        val date = arguments?.getString("date")

        binding.tvTravelPackageName.text = travelPackage?.name
        val photos = travelPackage?.photos ?: arrayListOf()
        if (photos.isNotEmpty()) {
            Glide.with(requireActivity()).load(photos[0])
                .transform(CenterCrop(), RoundedCorners(24)).placeholder(R.drawable.placeholder)
                .into(binding.imgTravelPackage)
        }
        binding.tvPackageType.text = travelPackageDomain?.name
        binding.tvDate.text = date

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                setupProfile(firebaseUser)
            }
        }

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(travelPackageDomain?.price ?: 0)}"

    }

    private fun setupProfile(user: FirebaseUser) {
        binding.tvCustomerName.text = user.displayName
        binding.tvCustomerPhone.text = user.phoneNumber
        binding.tvCustomerEmail.text = user.email
    }

}