package edu.unikom.restoranku.feature.order.presentation

import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.AllCaps
import android.view.LayoutInflater
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import edu.unikom.restoranku.databinding.FragmentOrderFormBinding
import edu.unikom.restoranku.module.DateUtility
import edu.unikom.restoranku.module.ViewBindingFragment


class OrderFormViewBindingFragment : ViewBindingFragment<FragmentOrderFormBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding =
        FragmentOrderFormBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigationEvent()
        initTextFieldEvent()
    }

    private fun initNavigationEvent() {
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun initTextFieldEvent() {
        val datePickerDialog = DateUtility.generateDatePickerDialog(requireContext()) {
            binding.txtFieldDate.setText(DateUtility.convertDateToString(it))
        }

        val timePickerDialog = DateUtility.generateTimePickerDialog(requireContext()) {
            binding.txtFieldHour.setText(DateUtility.convertTimePickerToString(it))
        }

        binding.txtFieldDate.setOnClickListener {
            datePickerDialog.show()
        }

        binding.txtFieldHour.setOnClickListener {
            timePickerDialog.show()
        }

        binding.txtFieldCodeMenu.filters = arrayOf<InputFilter>(AllCaps())
    }
}