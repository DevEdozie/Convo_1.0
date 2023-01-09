package com.example.convo_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convo_10.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {


    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.historyRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = HistoryAdapter(requireContext())


       //add a click listener for button
        binding.operationFab.setOnClickListener{
            val action = HistoryFragmentDirections.actionHistoryFragmentToOperationFragment()
            findNavController().navigate(action)
        }
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}