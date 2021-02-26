package com.example.birthdate.ui.showinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.birthdate.databinding.ShowInfoFragmentBinding

class ShowInfoFragment : Fragment() {
    lateinit var binding: ShowInfoFragmentBinding
    private lateinit var viewModel: ShowInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= ShowInfoFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShowInfoViewModel::class.java)

    }

}