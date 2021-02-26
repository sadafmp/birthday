package com.example.birthdate.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.birthdate.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {


    private val viewModel: SplashViewModel by  viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.evenFinishTimer.observe(viewLifecycleOwner) {
            if (it) {
                openHomeScreen()
            }
        }
    }
    private fun openHomeScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_firstFragment)
    }
}
