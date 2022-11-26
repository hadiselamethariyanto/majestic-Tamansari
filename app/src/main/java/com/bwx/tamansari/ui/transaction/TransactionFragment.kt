package com.bwx.tamansari.ui.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentRiwayatBinding
import com.bwx.tamansari.model.TransaksiModel
import com.bwx.tamansari.ui.base.BaseFragment

class TransactionFragment : BaseFragment<FragmentRiwayatBinding>(FragmentRiwayatBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTransaksi()
    }


    private fun setupTransaksi() {

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = TransactionAdapter()

        val transaksi = ArrayList<TransaksiModel>()
        transaksi.add(
            TransaksiModel(
                "Transaksi 1",
                "24 Agustus 21, 20:48",
                "Pembelian untuk pulsa 082132133213",
                "Rp 10.000"
            )
        )
        transaksi.add(
            TransaksiModel(
                "Transaksi 2",
                "24 Agustus 21, 20:48",
                "Pembelian untuk pulsa 082132133213",
                "Rp 10.000"
            )
        )
        transaksi.add(
            TransaksiModel(
                "Transaksi 3",
                "24 Agustus 21, 20:48",
                "Pembelian untuk pulsa 082132133213",
                "Rp 10.000"
            )
        )

        adapter.updateData(transaksi)
        adapter.setOnItemClickCallback(object : TransactionAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TransaksiModel) {
                findNavController().navigate(R.id.action_navigation_transaction_to_navigation_choose_payment_method)
            }
        })

        binding.rvTransaksi.layoutManager = linearLayoutManager
        binding.rvTransaksi.adapter = adapter
    }


}