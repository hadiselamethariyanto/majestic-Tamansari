package com.bwx.tamansari.ui.tpsr

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentTpsrBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class TpsrFragment : BaseFragment<FragmentTpsrBinding>(FragmentTpsrBinding::inflate) {

    private val viewModel: TpsrViewModel by viewModel()
    private lateinit var adapter: HistoryTpsrAdapter

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
        setupAdapter()

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                firebaseUser.email?.let {
                    viewModel.getTpsrBalance(it).observe(viewLifecycleOwner, tpsrBalanceObserver)
                }
            }
        }
    }

    private fun setupAdapter() {
        adapter = HistoryTpsrAdapter()
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvRiwayat.layoutManager = layoutManager
        binding.rvRiwayat.adapter = adapter
    }

    private val tpsrBalanceObserver = Observer<Resource<TpsrBalanceDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoading(true)
            }
            is Resource.Success -> {
                setLoading(false)
                val data = res.data
                val saldo = data?.saldo
                val history = data?.history ?: arrayListOf()
                binding.tvSaldo.text = "IDR ${Utils.thousandSeparator(saldo ?: 0)}"
                adapter.updateData(history)
            }
            is Resource.Error -> {
                setLoading(false)
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.tvSaldo.visibility = View.GONE
            binding.shimmerBalance.visibility = View.VISIBLE
            binding.shimmerHistory.visibility = View.VISIBLE
            binding.shimmerBalance.startShimmer()
            binding.shimmerHistory.startShimmer()
        } else {
            binding.tvSaldo.visibility = View.VISIBLE
            binding.shimmerBalance.stopShimmer()
            binding.shimmerHistory.stopShimmer()
            binding.shimmerHistory.visibility = View.GONE
            binding.shimmerBalance.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerBalance.startShimmer()
        binding.shimmerHistory.startShimmer()
    }

    override fun onPause() {
        binding.shimmerBalance.stopShimmer()
        binding.shimmerHistory.stopShimmer()
        super.onPause()
    }

}