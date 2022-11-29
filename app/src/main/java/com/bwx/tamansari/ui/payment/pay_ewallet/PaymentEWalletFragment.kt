package com.bwx.tamansari.ui.payment.pay_ewallet

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentPaymentEWalletBinding
import com.bwx.tamansari.ui.base.BaseFragment


class PaymentEWalletFragment :
    BaseFragment<FragmentPaymentEWalletBinding>(FragmentPaymentEWalletBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkoutUrl = arguments?.getString("checkout_url")

        checkoutUrl?.let { binding.webView.loadUrl(it) }
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                if (url == "https://google.com/") {
                    findNavController().navigate(R.id.action_navigation_ewallet_to_home)
                    return false
                }
                view?.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                if (url?.contains("xendit") == true) {
                    setLoading(true)
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                if (url?.contains("xendit") == true) {
                    setLoading(false)
                }
            }
        }

    }

    private fun setLoading(isLoading: Boolean) {
        binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.webView.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}