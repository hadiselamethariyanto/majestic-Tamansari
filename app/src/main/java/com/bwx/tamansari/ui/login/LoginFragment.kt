package com.bwx.tamansari.ui.login

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import com.bwx.tamansari.databinding.FragmentLoginBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils.afterTextChanged
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private lateinit var savedStateHandle: SavedStateHandle

    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle[LOGIN_SUCCESSFUL] = false

        oneTapClient = Identity.getSignInClient(requireActivity())
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("575747892421-npft8t6mgvvgfq3qku8iq74iccb0f1ar.apps.googleusercontent.com")
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()


        binding.btSignIn.setOnClickListener {
            oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(requireActivity()) { result ->
                    try {
                        startIntentSenderForResult(
                            result.pendingIntent.intentSender, REQ_ONE_TAP,
                            null, 0, 0, 0, null
                        )
                    } catch (e: IntentSender.SendIntentException) {
                        Log.e("", "Couldn't start One Tap UI: ${e.localizedMessage}")
                    }
                }
                .addOnFailureListener(requireActivity()) { e ->
                    Log.d("", e.message.toString())
                }

        }

        binding.btnLoginWithEmail.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.loginWithEmailPassword(email, password)
//            val intent =
//                Intent(requireActivity(), Class.forName("banyuwangi.digital.admin.MainActivity"))
//            startActivity(intent)
        }

        viewModel.formState.observe(viewLifecycleOwner) {
            val state = it ?: return@observe

            binding.btnLoginWithEmail.isEnabled = state.isDataValid
        }

        binding.etEmail.afterTextChanged {
            triggerDataChange()
        }

        binding.etPassword.afterTextChanged {
            triggerDataChange()
        }

        viewModel.user.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    savedStateHandle[LOGIN_SUCCESSFUL] = true
                    findNavController().popBackStack()
                }
                is Resource.Error -> {
                    Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(requireActivity(), "Null", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun triggerDataChange(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        viewModel.formDataChanged(email, password)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_ONE_TAP -> {
                try {
                    val credential = oneTapClient.getSignInCredentialFromIntent(data)
                    val idToken = credential.googleIdToken
                    when {
                        idToken != null -> {
                            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                            viewModel.login(firebaseCredential)
                        }
                    }
                } catch (e: ApiException) {
                    Toast.makeText(requireActivity(), e.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }


    }

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
        const val REQ_ONE_TAP = 100
    }

}