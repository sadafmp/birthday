package com.example.birthdate.ui.firstpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.birthdate.R
import com.example.birthdate.databinding.MainFragmentBinding
import com.example.birthdate.datamodel.MainTableModel
import com.example.birthdate.localdb.DateRepository
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModel()

    override
    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //go add info fragment
        goInfoPage()

        DateRepository.getAll(requireContext())?.observe(viewLifecycleOwner, {
            binding.rvShowInfo.adapter = MainAdapter(requireContext(),
                object : showProductListener {
                    override fun itemClick(item: MainTableModel) {
                        findNavController().navigate(R.id.action_firstFragment_to_showInfoFragment)
                    }
                }).apply { submitList(it) }
        })
    }

    private fun goInfoPage() {
        binding.floatingActionButton2.setOnClickListener { findNavController().navigate(R.id.action_firstFragment_to_addInfoFragment) }
    }
}
