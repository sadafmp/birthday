package com.example.birthdate.ui.showinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.birthdate.bases.BaseFragment
import com.example.birthdate.databinding.ShowInfoFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowInfoFragment : BaseFragment() {
    lateinit var binding: ShowInfoFragmentBinding
    private val viewModel: ShowInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShowInfoFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //get argument
        getArgs()
        //back to main Fragment
        backPress()
        //handle back thread

        onBackPress()
    }

    private fun getArgs() {
        val args = ShowInfoFragmentArgs.fromBundle(requireArguments()).dateArgs
        viewModel.name.value = args.name
        viewModel.day.value = args.day
        viewModel.month.value = args.month
        viewModel.year.value = args.year
        viewModel.yearGhamari.value = args.birthghamari
        viewModel.selfDay.value = args.selfDay
        viewModel.selfMonth.value = args.selfMonth
        viewModel.selfYear.value = args.selfYear
        viewModel.season.value = args.birthSeason
        viewModel.yearName.value = args.yearName
        viewModel.MonthName.value = args.monthNemad
        viewModel.yearMiladi.value = args.birthmiladi
        viewModel.age.value = args.toBirth
    }

    private fun backPress() {
        binding.imgBack.setOnClickListener { findNavController().navigateUp() }
    }
}