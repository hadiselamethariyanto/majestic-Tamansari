package com.bwx.tamansari.ui.ticket.travel_package

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionTravelPackageDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentMyFailedTicketTravelPackageBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyFailedTicketTravelPackageFragment :
    BaseFragment<FragmentMyFailedTicketTravelPackageBinding>(
        FragmentMyFailedTicketTravelPackageBinding::inflate
    ) {

    private val viewModel: MyTicketTravelPackageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvCustomerName.text = transaction?.customerName
        binding.tvCustomerPhone.text = transaction?.customerPhoneNumber
        binding.tvCustomerEmail.text = transaction?.customerEmail

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
                                setTravelPackage(data)
                            }

                            binding.btnBuyAgain.setOnClickListener {
                                val bundle = bundleOf("id" to data?.travelPackage?.id)
                                findNavController().navigate(
                                    R.id.action_navigation_failed_travel_package_to_navigation_travel_package,
                                    bundle
                                )
                            }
                        }
                        is Resource.Error -> {

                        }
                    }
                }
        }


    }

    private fun setTravelPackage(data: TransactionTravelPackageDomain) {
        val travelPackage = data.travelPackage
        val travelPackagePhotos = travelPackage.photos

        if (travelPackagePhotos.isNotEmpty()) {
            Glide.with(requireActivity()).load(travelPackagePhotos[0])
                .placeholder(R.drawable.placeholder)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(binding.imgWisata)
        }
        binding.tvWisataName.text = travelPackage.name
    }

    private fun setDetailTransaction(data: TransactionTravelPackageDomain) {
        val travelPackageType = data.travelPackageType
        val selectedDate = data.selectedDate

        binding.tvPackageType.text = travelPackageType.name
        binding.tvDate.text = selectedDate
    }

}