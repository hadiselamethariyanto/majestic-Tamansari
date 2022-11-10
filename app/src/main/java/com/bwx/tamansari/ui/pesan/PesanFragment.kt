package com.bwx.tamansari.ui.pesan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentPesanBinding
import com.bwx.tamansari.model.PesanModel

class PesanFragment : Fragment() {

    private var _binding: FragmentPesanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPesanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pesan = ArrayList<PesanModel>()
        pesan.add(
            PesanModel(
                "1",
                "Lapor",
                "09 Sep, 16:14",
                "Laporan anda sudah kami teruskan ke RT/RW setempat, mohon tunggu"
            )
        )
        pesan.add(
            PesanModel(
                "1",
                "Lapor",
                "09 Sep, 16:14",
                "Laporan anda sudah kami teruskan ke RT/RW setempat, mohon tunggu"
            )
        )
        pesan.add(
            PesanModel(
                "1",
                "Lapor",
                "09 Sep, 16:14",
                "Laporan anda sudah kami teruskan ke RT/RW setempat, mohon tunggu"
            )
        )

        val adapter = PesanAdapter()
        adapter.updateData(pesan)

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvPesan.adapter = adapter
        binding.rvPesan.layoutManager = linearLayoutManager
        binding.rvPesan.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                LinearLayoutManager.VERTICAL
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}