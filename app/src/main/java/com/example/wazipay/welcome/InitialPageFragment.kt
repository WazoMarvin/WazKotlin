package com.example.wazipay.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.wazipay.R
import com.example.wazipay.databinding.FragmentInitialPageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InitialPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InitialPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInitialPageBinding>(inflater,
            R.layout.fragment_initial_page,container,false)
        binding.registerCard.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_initialPageFragment_to_registerFragment)
        }
        return binding.root
    }


}