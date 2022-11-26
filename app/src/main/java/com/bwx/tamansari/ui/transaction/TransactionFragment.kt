package com.bwx.tamansari.ui.transaction

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentRiwayatBinding
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionFragment : BaseFragment<FragmentRiwayatBinding>(FragmentRiwayatBinding::inflate) {

    private val viewModel: TransactionsViewModel by viewModel()
    private lateinit var adapter: TransactionAdapter

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

        setupTransactions()

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                viewModel.getTransactions(firebaseUser.email ?: "")
                    .observe(viewLifecycleOwner) { res ->
                        when (res) {
                            is Resource.Loading -> {

                            }
                            is Resource.Success -> {
                                val transactions = res.data ?: arrayListOf()
                                if (transactions.isNotEmpty()) {
                                    adapter.updateData(transactions)
                                }
                            }
                            is Resource.Error -> {
                                Toast.makeText(requireActivity(),res.message,Toast.LENGTH_LONG).show()
                            }
                        }
                    }
            }
        }
    }


    private fun setupTransactions() {
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = TransactionAdapter()
        adapter.setOnItemClickCallback(object : TransactionAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TransactionDomain) {
                val bundle = bundleOf("transaction" to data)
                findNavController().navigate(
                    R.id.action_navigation_transaction_to_navigation_choose_payment_method,
                    bundle
                )
            }
        })

        binding.rvTransaksi.layoutManager = linearLayoutManager
        binding.rvTransaksi.adapter = adapter
    }


}