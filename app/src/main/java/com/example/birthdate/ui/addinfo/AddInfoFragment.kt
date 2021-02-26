package com.example.birthdate.ui.addinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.birthdate.bases.BaseFragment
import com.example.birthdate.databinding.AddInfoFragmentBinding
import com.example.birthdate.datamodel.MainTableModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AddInfoFragment : BaseFragment() {


    private val viewModel: AddInfoViewModel by viewModel()
    lateinit var binding: AddInfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = AddInfoFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //save button
        saveButton()
        //handle back thread
        onBackPress()
        //back to main fragment
        closeButton()
    }

    private fun closeButton() {
        binding.imgBack.setOnClickListener { findNavController().navigateUp() }
    }

    private fun saveButton() {
        binding.btnSave.setOnClickListener {
            if (checkNull()) {
                viewModel.getCurrencyData()
                saveToRoom()
                invisibleItems()
                visibleProgress()
            }


        }
    }

    private fun backPress() {
        findNavController().navigateUp()

    }

    private fun saveToRoom() {
        viewModel.responseCurrencyData.observe(viewLifecycleOwner, {

            val model = MainTableModel(
                0,
                viewModel.name.value.toString(),
                viewModel.day.value.toString(),
                viewModel.month.value.toString(),
                viewModel.year.value.toString(),
                viewModel.responseCurrencyData.value?.result?.birthSeason,
                viewModel.responseCurrencyData.value?.result?.birthghamari,
                viewModel.responseCurrencyData.value?.result?.birthmiladi,
                viewModel.responseCurrencyData.value?.result?.day,
                viewModel.responseCurrencyData.value?.result?.month,
                viewModel.responseCurrencyData.value?.result?.monthNemad,
                viewModel.responseCurrencyData.value?.result?.toBirth,
                viewModel.responseCurrencyData.value?.result?.year,
                viewModel.responseCurrencyData.value?.result?.yearName
            )
            viewModel.insertData(
                model
            )
            backPress()
        })
    }

    private fun checkNull(): Boolean {
        if (viewModel.name.value.equals("") ||
            viewModel.month.value.equals("") ||
            viewModel.day.value.equals("") ||
            viewModel.year.value.equals("")
        ) {
            showMessage("لطفا تمامی فیلد ها را پرکنید ")
            return false
        } else {
            return true
        }

    }

    private fun visibleProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun invisibleItems() {
        binding.btnSave.visibility = View.INVISIBLE
        binding.etName.visibility = View.INVISIBLE
        binding.etDay.visibility = View.INVISIBLE
        binding.etMonth.visibility = View.INVISIBLE
        binding.etYear.visibility = View.INVISIBLE
    }

}