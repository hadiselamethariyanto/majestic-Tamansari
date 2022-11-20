package com.bwx.tamansari.ui.homestay.choose_room

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseRoomBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class ChooseRoomFragment :
    BaseFragment<FragmentChooseRoomBinding>(FragmentChooseRoomBinding::inflate) {

    private val viewModel: ChooseRoomViewModel by viewModel()
    private val calCheckin = Calendar.getInstance()
    private val calCheckout = Calendar.getInstance()

    private lateinit var adapter: RoomAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homestay = arguments?.getParcelable<HomestayDomain>("homestay")

        adapter = RoomAdapter()
        adapter.setOnItemClickCallback(object : RoomAdapter.OnItemClickCallback {
            override fun onItemClicked(data: AvailableRoomDomain) {
                val checkinDate = binding.etCheckIn.text.toString()
                val checkoutDate = binding.etCheckout.text.toString()
                val bundle =
                    bundleOf(
                        "homestay" to homestay,
                        "room" to data,
                        "checkin" to checkinDate,
                        "checkout" to checkoutDate
                    )
                findNavController().navigate(
                    R.id.action_navigation_choose_room_to_navigation_review_transaction_homestay,
                    bundle
                )
            }
        })
        binding.rvRooms.adapter = adapter

        getToday()

        homestay?.let {
            viewModel.getAvailabilityRooms(it.id).observe(viewLifecycleOwner, roomsObserver)
        }

        val checkInDateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calCheckin.set(Calendar.YEAR, year)
                calCheckin.set(Calendar.MONTH, monthOfYear)
                calCheckin.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                binding.etCheckIn.setText(Utils.formatCalendarToStringDate(calCheckin.timeInMillis))
                binding.etCheckout.setText("")

                viewModel.setFirstDate(Utils.formatCalendarYYYYMMDD(calCheckin.timeInMillis))
                viewModel.setLastDate("")
            }

        val checkOutDateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calCheckout.set(Calendar.YEAR, year)
                calCheckout.set(Calendar.MONTH, monthOfYear)
                calCheckout.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                binding.etCheckout.setText(Utils.formatCalendarToStringDate(calCheckout.timeInMillis))

                viewModel.setLastDate(Utils.formatCalendarYYYYMMDD(calCheckout.timeInMillis))
            }

        binding.etCheckIn.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(
                    requireActivity(),
                    checkInDateSetListener,
                    calCheckin.get(Calendar.YEAR),
                    calCheckin.get(Calendar.MONTH),
                    calCheckin.get(Calendar.DAY_OF_MONTH)
                )
            datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
            datePickerDialog.show()
        }

        binding.etCheckout.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(
                    requireActivity(),
                    checkOutDateSetListener,
                    calCheckout.get(Calendar.YEAR),
                    calCheckout.get(Calendar.MONTH),
                    calCheckout.get(Calendar.DAY_OF_MONTH)
                )
            datePickerDialog.datePicker.minDate = calCheckin.timeInMillis
            datePickerDialog.show()
        }
    }

    private val roomsObserver =
        androidx.lifecycle.Observer<Resource<List<AvailableRoomDomain>>> { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val rooms = res.data ?: arrayListOf()
                    if (rooms.isNotEmpty()) {
                        adapter.updateData(rooms)
                        binding.rvRooms.visibility = View.VISIBLE
                    } else {
                        binding.rvRooms.visibility = View.GONE
                    }
                }
                is Resource.Error -> {

                }
            }
        }

    private fun getToday() {
        val calendar = Calendar.getInstance()
        binding.etCheckIn.setText(Utils.formatCalendarToStringDate(calendar.timeInMillis))
        viewModel.setFirstDate(Utils.formatCalendarYYYYMMDD(calendar.timeInMillis))
        calendar.add(Calendar.DATE, 1)
        binding.etCheckout.setText(Utils.formatCalendarToStringDate(calendar.timeInMillis))
        viewModel.setLastDate(Utils.formatCalendarYYYYMMDD(calendar.timeInMillis))
    }
}