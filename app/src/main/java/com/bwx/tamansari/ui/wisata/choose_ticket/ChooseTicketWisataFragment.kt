package com.bwx.tamansari.ui.wisata.choose_ticket

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseTicketWisataBinding
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChooseTicketWisataFragment :
    BaseFragment<FragmentChooseTicketWisataBinding>(FragmentChooseTicketWisataBinding::inflate) {

    private val viewModel: ChooseTicketWisataViewModel by viewModel()
    private lateinit var chooseTicketWisataAdapter: ChooseTicketWisataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tickets =
            arguments?.getParcelableArrayList<TicketWisataDomain>("tickets") ?: arrayListOf()
        val wisata = arguments?.getParcelable<WisataDomain>("wisata")

        viewModel.chart.observe(viewLifecycleOwner) {
            chooseTicketWisataAdapter.updateData(it)
            if (it.isNotEmpty()) {
                binding.llBook.visibility = View.VISIBLE
            } else {
                binding.llBook.visibility = View.GONE
            }
        }

        chooseTicketWisataAdapter = ChooseTicketWisataAdapter(tickets)
        chooseTicketWisataAdapter.setOnItemClickCallback(object :
            ChooseTicketWisataAdapter.OnItemClickCallback {
            override fun onChooseTicket(data: TicketWisataDomain) {
                val chart = ChartDomain(
                    idProduct = data.id,
                    productName = data.name,
                    productPrice = data.price,
                    total = 1
                )
                viewModel.addChart(chart)
            }

            override fun onPlusTicket(data: TicketWisataDomain) {
                viewModel.plusChart(data)
            }

            override fun onMinusTicket(data: TicketWisataDomain) {
                viewModel.deleteChart(data)
            }

        })
        binding.rvTicketWisata.adapter = chooseTicketWisataAdapter

        binding.btnBook.setOnClickListener {
            val chartTicket = viewModel.chart.value
            val bundle = bundleOf("wisata" to wisata, "charts" to chartTicket)
            findNavController().navigate(
                R.id.action_navigation_choose_ticket_wisata_to_navigation_review_transaction_wisata,
                bundle
            )
        }
    }

}