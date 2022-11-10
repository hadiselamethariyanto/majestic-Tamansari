package com.bwx.tamansari.ui.riwayat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentRiwayatBinding
import com.bwx.tamansari.model.TransaksiModel

class RiwayatFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTransaksi()
    }



    private fun setupTransaksi() {

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = RiwayatAdapter()

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

        binding.rvTransaksi.layoutManager = linearLayoutManager
        binding.rvTransaksi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}