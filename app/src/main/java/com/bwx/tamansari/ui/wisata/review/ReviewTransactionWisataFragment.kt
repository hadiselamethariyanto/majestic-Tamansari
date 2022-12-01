package com.bwx.tamansari.ui.wisata.review

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionWisataBinding
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import com.bwx.tamansari.utils.Utils.afterTextChanged
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

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(totalPayment)}"
        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(totalPayment)}"

        val adapter = ReviewTransactionWisataAdapter()
        adapter.updateData(charts)
        binding.rvChart.adapter = adapter

        val user = viewModel.user.value

        binding.btnPayment.setOnClickListener {
            val username = binding.etCustomerName.text.toString()
            val phoneNumber = binding.etCustomerPhone.text.toString()

            viewModel.insertTransactionWisata(
                customerName = username,
                customerEmail = user?.email ?: "",
                customerPhoneNumber = phoneNumber,
                fee = totalPayment,
                convenienceFee = 0,
                totalFee = totalPayment,
                idWisata = wisata?.id ?: "",
                charts = charts
            ).observe(viewLifecycleOwner, insertTransactionObserver)
        }
    }

    private val insertTransactionObserver = Observer<Resource<TransactionDomain>> { res ->
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

    private fun setLoading(isLoading: Boolean) {
        binding.btnPayment.isEnabled = !isLoading
    }

    private fun triggerDataChanged() {
        val username = binding.etCustomerName.text.toString()
        val phoneNumber = binding.etCustomerPhone.text.toString()
        viewModel.userDataChanged(username, phoneNumber)
    }

    private fun setupProfile(user: FirebaseUser) {
        binding.etCustomerName.setText(user.displayName)
        binding.etCustomerPhone.setText(user.phoneNumber)
        binding.etCustomerEmail.setText(user.email)
    }
}