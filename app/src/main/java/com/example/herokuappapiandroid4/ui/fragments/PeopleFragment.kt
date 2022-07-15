package com.example.herokuappapiandroid4.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.Either
import com.example.herokuappapiandroid4.R
import com.example.herokuappapiandroid4.databinding.FragmentPeopleBinding
import com.example.herokuappapiandroid4.ui.adapters.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment :
    Fragment(R.layout.fragment_people) {

    private val binding by viewBinding(FragmentPeopleBinding::bind)
    private val viewModel: PeopleViewModel by viewModels()
    private val peopleAdapter = PeopleAdapter(this::itemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        setupObserves()
    }

    private fun setupRecyclerview() = with(binding.peopleRecview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = peopleAdapter
    }

    private fun setupObserves() {
        viewModel.fetchPeople().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Arzymat", it.value.toString())
                    peopleAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun itemClick(id: String) {
        findNavController().navigate(
            PeopleFragmentDirections.actionPeopleFragmentToDetailPeopleFragment(
                position = id
            )
        )
    }
}


