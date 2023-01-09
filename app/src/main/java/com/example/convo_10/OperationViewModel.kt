package com.example.convo_10

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.internal.LockFreeLinkedListNode
import java.util.*

class OperationViewModel : ViewModel() {

    private var numOne: Double = 0.0
    private var unknownNum: Double = 0.0
    //private var result: Double = 0.0

    companion object {
        const val ONE_NGN_TO_USD = 0.00222204
        const val ONE_USD_TO_NGN = 450.03638
    }

    fun saveResult(resultOne: String, resultTwo: String){
        resultOneList.add(resultOne)
        resultTwoList.add(resultTwo)
    }

    fun performOperation(firstCurrency: String, numOne: Double): Double {
        if (firstCurrency == "NGN") {
            unknownNum = convertNairaToDollar(numOne)
        } else if (firstCurrency == "USD") {
            unknownNum = convertDollarToNaira(numOne)
        }
        return unknownNum
    }

    private fun convertNairaToDollar(numOne: Double): Double {
        unknownNum = (numOne * ONE_NGN_TO_USD) / 1
        return unknownNum
    }

    private fun convertDollarToNaira(numOne: Double): Double {
        unknownNum = (numOne * ONE_USD_TO_NGN) / 1
        return unknownNum
    }


}