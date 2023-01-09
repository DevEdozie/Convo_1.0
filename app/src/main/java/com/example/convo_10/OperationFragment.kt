package com.example.convo_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.convo_10.databinding.FragmentOperationBinding
import java.util.*

class OperationFragment : Fragment() {


    private val viewModel: OperationViewModel by viewModels()
    private var _binding: FragmentOperationBinding? = null
    val binding get() = _binding!!

    private lateinit var firstNumber: String
    private lateinit var unknownNumber: String

    private lateinit var firstCurrency: String
    private lateinit var unknownCurrency: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment and return an object instance
        _binding = FragmentOperationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set onClickListener for Button
        binding.convertButton.setOnClickListener {
            convertCurrency()
        }
        //set onClickListener for fab
        binding.fabHistory.setOnClickListener {
            displayHstory()
        }
    }

    private fun convertCurrency() {
        val proceed = isUserInputValid()
        if (proceed) {
            var firstCurrency = getFirstCurrency()
            //var firstNumber = getFirstNumber()
           unknownNumber =  viewModel.performOperation(firstCurrency,getFirstNumber()).toString()
            displayResult()
        } else {
            //DO NOTHING
        }
    }

    private fun saveResult(){

    }

    private fun displayResult(){
        var firstCurrency = getFirstCurrency()
        var unknownCurrency = getUnknownCurrency()
        var resultOne = ""
        var resultTwo = ""
        if(firstCurrency == unknownCurrency){
            Toast.makeText(requireContext(),"Can't convert similar currencies",Toast.LENGTH_LONG).show()
        }else if(firstCurrency != unknownCurrency){
            if(firstCurrency == "NGN"){
                binding.result1.text = "${firstNumber} Nigerian Naira equals"
                binding.result2.text = "${unknownNumber} United States Dollar"
            }else if(firstCurrency == "USD"){
                binding.result1.text = "${firstNumber} United States Dollar equals"
                binding.result2.text = "${unknownNumber} Nigerian Naira "
            }
            // Save Result
            resultOne = binding.result1.text.toString()
            resultTwo = binding.result2.text.toString()
            viewModel.saveResult(resultOne,resultTwo)
            Toast.makeText(requireContext(),"Result Saved",Toast.LENGTH_LONG).show()
        }

    }

    private fun displayHstory(){
        val action = OperationFragmentDirections.actionOperationFragmentToHistoryFragment()
        findNavController().navigate(action)
    }


    private fun getFirstCurrency(): String{
        firstCurrency = binding.numOneSpinner.selectedItem.toString()
        return firstCurrency
    }

    private fun getUnknownCurrency(): String{
        unknownCurrency = binding.unknownNumSpinner.selectedItem.toString()
        return unknownCurrency
    }

    private fun getFirstNumber(): Double{
        firstNumber = binding.numOne.text.toString()
        return firstNumber.toDouble()
    }

    private fun isUserInputValid(): Boolean {
        //Check if any of the edittext is empty
        firstNumber = binding.numOne.text.toString()
        //unknownNumber = binding.unknownNum.text.toString()

        if ((firstNumber.isNotEmpty())) {
            return true
        } else {
            binding.numOne.error = getString(R.string.error_message)
        }
        return false
    }


}