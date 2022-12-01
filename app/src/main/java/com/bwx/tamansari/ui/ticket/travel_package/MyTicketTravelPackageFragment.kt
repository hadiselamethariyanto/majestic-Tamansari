package com.bwx.tamansari.ui.ticket.travel_package

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionTravelPackageDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.FragmentMyTicketTravelPackageBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyTicketTravelPackageFragment :
    BaseFragment<FragmentMyTicketTravelPackageBinding>(FragmentMyTicketTravelPackageBinding::inflate) {

    private val viewModel: MyTicketTravelPackageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = transaction?.id

        Glide.with(requireActivity()).load(Utils.getQrCodeBitmap(transaction?.id ?: ""))
            .centerCrop()
            .into(binding.imgQr)

        binding.tvCustomerName.text = "Nama lengkap: ${transaction?.customerName}"
        binding.tvCustomerPhone.text = "Nomor ponsel: ${transaction?.customerPhoneNumber}"
        binding.tvCustomerEmail.text = "Alamat email: ${transaction?.customerEmail}"

        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"

        if (transaction != null) {
            viewModel.getTransactionTravelPackage(transaction.id)
                .observe(viewLifecycleOwner) { res ->
                    when (res) {
                        is Resource.Loading -> {

                        }
                        is Resource.Success -> {
                            val data = res.data
                            if (data != null) {
                                setDetailTransaction(data)
                            }
                        }
                        is Resource.Error -> {

                        }
                    }
                }
        }
    }

    private fun setDetailTransaction(data: TransactionTravelPackageDomain) {
        val travelPackage = data.travelPackage
        val travelPackageType = data.travelPackageType
        val selectedDate = data.selectedDate

        binding.tvTravelPackageName.text = travelPackage.name
        binding.tvPackageType.text = travelPackageType.name
        binding.tvDate.text = selectedDate
    }

}