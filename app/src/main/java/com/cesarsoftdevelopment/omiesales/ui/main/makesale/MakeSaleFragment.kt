package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.databinding.FragmentHomeBinding
import com.cesarsoftdevelopment.omiesales.databinding.FragmentMakeSaleBinding

class MakeSaleFragment : Fragment() {

    private val viewModel: MakeSaleViewModel by viewModels()

    private var _binding: FragmentMakeSaleBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakeSaleBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}