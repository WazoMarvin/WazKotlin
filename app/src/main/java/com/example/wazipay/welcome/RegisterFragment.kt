package com.example.wazipay.welcome

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.wazipay.R
import com.example.wazipay.data.User
import com.example.wazipay.databinding.FragmentInitialPageBinding
import com.example.wazipay.databinding.FragmentRegisterBinding
import com.example.wazipay.home.HomeActivity
import com.example.wazipay.welcome.viewmodels.RegisterFragmentViewModel
import com.example.wazipay.welcome.viewmodels.RegisterFragmentViewModelFactory


/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterFragmentViewModel
    private lateinit var viewModelFactory: RegisterFragmentViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)

        val application = requireNotNull(activity).application
        viewModelFactory = RegisterFragmentViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(RegisterFragmentViewModel::class.java)
        binding.registerBtn.setOnClickListener{registerNewUser()}
        viewModel.registerSuccess.observe(viewLifecycleOwner, Observer {
            openHomeActivity();
        })
        viewModel.isRegistering.observe(viewLifecycleOwner, Observer {
            if (it){
                binding.registerText.setText("Saving...")
            }else{
                binding.registerText.setText("Register")
            }
        })
        return binding.root
    }

    fun registerNewUser(){
        viewModel.registerNewUser(
            binding.userName.text.toString(),
            binding.userEmail.text.toString(),
            binding.userPassword.text.toString()
        )
    }

    fun openHomeActivity(){
        val intent = Intent (getActivity(), HomeActivity::class.java)
        this.startActivity(intent)
    }

}