package com.bwx.tamansari.ui.akun.call_center

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentCallCenterBinding
import com.bwx.tamansari.ui.base.BaseBottomSheetDialog

class CallCenterFragment :
    BaseBottomSheetDialog<FragmentCallCenterBinding>(FragmentCallCenterBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgClose.setOnClickListener {
            dismiss()
        }
    }
}