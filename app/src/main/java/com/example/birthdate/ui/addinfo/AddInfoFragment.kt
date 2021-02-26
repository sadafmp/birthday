package com.example.birthdate.ui.addinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.birthdate.databinding.AddInfoFragmentBinding
import com.example.birthdate.datamodel.MainTableModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddInfoFragment : Fragment() {


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
        savebutton()

        viewModel.responseCurrencyData.observe(viewLifecycleOwner,{
            findNavController().navigateUp()
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
        })

    }

    private fun savebutton() {
        binding.btnSave.setOnClickListener {
            viewModel.getCurrencyData()
        }
    }


}