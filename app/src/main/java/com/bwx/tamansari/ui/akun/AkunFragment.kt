package com.bwx.tamansari.ui.akun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentAkunBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.login.LoginFragment
import com.bwx.tamansari.utils.Utils
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class AkunFragment : BaseFragment<FragmentAkunBinding>(FragmentAkunBinding::inflate) {

    private val viewModel: AccountViewModel by viewModel()

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

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) { firebaseUser ->
            if (firebaseUser == null) {
                findNavController().navigate(R.id.loginFragment)
            } else {
                val user = firebaseUser.providerData
                setupProfile(firebaseUser)
                for (x in user) {
                    if (x.providerId == "password") {
                        val intent = Intent(
                            requireActivity(),
                            Class.forName("banyuwangi.digital.admin.MainActivity")
                        )
                        startActivity(intent)
                    } else if (x.providerId == "google.com") {
                        firebaseUser.email?.let { getTpsrBalance(it) }
                    }
                }
            }
        }

        binding.content.tvAbout.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_bottom_account_to_navigation_about)
        }

        binding.content.tvCallCenter.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_bottom_account_to_navigation_call_center)
        }

        binding.content.tvLogout.setOnClickListener {
            viewModel.logout()
        }

    }

    private fun setupProfile(user: FirebaseUser) {
        binding.tvUsername.text = user.displayName
        binding.tvEmail.text = user.email

        Glide.with(this)
            .load(user.photoUrl)
            .error(R.mipmap.dewitari)
            .transform(CenterCrop(), RoundedCorners(70))
            .into(binding.imgProfile)
    }

    private fun getTpsrBalance(email: String) {
        viewModel.getTpsrBalance(email).observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val data = res.data
                    val balance = data?.saldo
                    binding.tvSaldo.text = "IDR ${Utils.thousandSeparator(balance ?: 0)}"
                }
                is Resource.Error -> {
                    Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}