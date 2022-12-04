package com.bwx.tamansari.ui.transaction

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
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
                                setLoading(true)
                            }
                            is Resource.Success -> {
                                setLoading(false)
                                val transactions = res.data ?: arrayListOf()
                                if (transactions.isNotEmpty()) {
                                    adapter.updateData(transactions)
                                } else {
                                    binding.rvTransaksi.visibility = View.GONE
                                    binding.llEmpty.visibility = View.VISIBLE
                                }
                            }
                            is Resource.Error -> {
                                setLoading(false)
                                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.llLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.rvTransaksi.visibility = if (isLoading) View.GONE else View.VISIBLE
        binding.llEmpty.visibility = View.GONE
    }


    private fun setupTransactions() {
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = TransactionAdapter()
        adapter.setOnItemClickCallback(object : TransactionAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TransactionDomain) {
                val bundle = bundleOf("transaction" to data)
                if (data.status == 3) {
                    if (data.type == 1) {
                        findNavController().navigate(
                            R.id.action_navigation_transaction_to_navigation_my_ticket_wisata,
                            bundle
                        )
                    } else if (data.type == 2) {
                        findNavController().navigate(R.id.navigation_my_ticket_restaurant, bundle)
                    } else if (data.type == 3) {
                        findNavController().navigate(
                            R.id.navigation_my_ticket_travel_package,
                            bundle
                        )
                    } else if (data.type == 5) {
                        findNavController().navigate(R.id.navigation_my_ticket_homestay, bundle)
                    }
                } else if (data.status == 4 || data.status == 2) {
                    when (data.type) {
                        1 -> {
                            findNavController().navigate(
                                R.id.action_navigation_transaction_to_navigation_my_failed_ticket_wisata,
                                bundle
                            )
                        }
                        2 -> {
                            findNavController().navigate(
                                R.id.navigation_my_failed_ticket_restaurant,
                                bundle
                            )
                        }
                        3 -> {
                            findNavController().navigate(
                                R.id.navigation_my_failed_ticket_travel_package,
                                bundle
                            )
                        }
                        5 -> {
                            findNavController().navigate(
                                R.id.navigation_my_failed_ticket_homestay,
                                bundle
                            )
                        }
                    }
                } else {
                    findNavController().navigate(
                        R.id.action_navigation_transaction_to_navigation_payment_method,
                        bundle
                    )
                }
            }

            override fun onUpdateExpired(data: TransactionDomain) {
                viewModel.updateExpiredTransaction(data.id)
                    .observe(viewLifecycleOwner, updateExpiredTransactionObserver)
            }
        })

        binding.rvTransaksi.layoutManager = linearLayoutManager
        binding.rvTransaksi.adapter = adapter
    }

    private val updateExpiredTransactionObserver = Observer<Resource<TransactionDomain>> { res ->
        when (res) {
            is Resource.Loading -> {

            }
            is Resource.Success -> {

            }
            is Resource.Error -> {

            }
        }
    }


}