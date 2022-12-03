package com.bwx.tamansari.ui.restaurant.review

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionRestaurantBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import com.bwx.tamansari.utils.Utils.afterTextChanged
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.navigation.koinNavGraphViewModel


class ReviewTransactionRestaurantFragment :
    BaseFragment<FragmentReviewTransactionRestaurantBinding>(
        FragmentReviewTransactionRestaurantBinding::inflate
    ) {

    private val viewModel: ReviewTransactionRestaurantViewModel by koinNavGraphViewModel(R.id.navigation_review_transaction_restaurant)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cart = arguments?.getParcelableArrayList<CartRestaurantDomain>("cart") ?: arrayListOf()

        val adapter = ReviewTransactionRestaurantAdapter()
        adapter.updateData(cart)

        binding.rvCart.adapter = adapter

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                setupProfile(firebaseUser)
            }
        }

        viewModel.userFormState.observe(viewLifecycleOwner) {
            val formState = it ?: return@observe

            if (formState.username != null) {
                binding.etCustomerName.error = getString(formState.username)
            } else if (formState.phoneNumber != null) {
                binding.etCustomerPhone.error = getString(formState.phoneNumber)
            }

            binding.btnPayment.isEnabled = formState.isDataValid
        }

        binding.etCustomerName.afterTextChanged {
            triggerDataChanged()
        }

        binding.etCustomerPhone.afterTextChanged {
            triggerDataChanged()
        }

        viewModel.selectedHomestay.observe(viewLifecycleOwner) { homestay ->
            binding.tvLocation.text = homestay.name
        }

        viewModel.getHomestays().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoadingDeliveryLocation(true)
                }
                is Resource.Success -> {
                    setLoadingDeliveryLocation(false)
                    val homestays = res.data ?: arrayListOf()
                    viewModel.setDataHomestays(homestays)
                    if (homestays.isNotEmpty()){
                        viewModel.setSelectedHomestay(homestays[0])
                    }
                }
                is Resource.Error -> {
                    setLoadingDeliveryLocation(false)
                }
            }
        }

        val fee = cart.sumOf { it.total * it.productPrice }
        val ongkir = 10000

        binding.tvPrice.text = Utils.thousandSeparator(fee)
        binding.tvOngkir.text = Utils.thousandSeparator(ongkir)

        binding.tvTotalPayment.text = Utils.thousandSeparator(fee + ongkir)

        binding.btnChangeLocation.setOnClickListener {
            findNavController().navigate(R.id.navigation_choose_location_bottom_sheet_dialog)
        }


    }

    private fun setLoadingDeliveryLocation(isLoading: Boolean) {
        if (isLoading) binding.shimmerDeliveryLocation.startShimmer() else binding.shimmerDeliveryLocation.stopShimmer()
        binding.shimmerDeliveryLocation.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.tvLocation.visibility = if (isLoading) View.GONE else View.VISIBLE
        binding.btnChangeLocation.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

    private fun setupProfile(user: FirebaseUser) {
        binding.etCustomerName.setText(user.displayName)
        binding.etCustomerPhone.setText(user.phoneNumber)
        binding.etCustomerEmail.setText(user.email)
    }

    private fun triggerDataChanged() {
        val username = binding.etCustomerName.text.toString()
        val phoneNumber = binding.etCustomerPhone.text.toString()
        viewModel.userDataChanged(username, phoneNumber)
    }


    override fun onResume() {
        super.onResume()
        binding.shimmerDeliveryLocation.startShimmer()
    }

    override fun onPause() {
        binding.shimmerDeliveryLocation.stopShimmer()
        super.onPause()
    }

}