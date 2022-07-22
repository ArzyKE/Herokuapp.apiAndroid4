package com.example.herokuappapiandroid4.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.herokuappapiandroid4.R
import com.example.herokuappapiandroid4.base.BaseFragment
import com.example.herokuappapiandroid4.databinding.FragmentPeopleBinding
import com.example.herokuappapiandroid4.ui.adapters.PeopleAdapter
import com.example.herokuappapiandroid4.utils.Either
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment :
    BaseFragment<PeopleViewModel, FragmentPeopleBinding>(R.layout.fragment_people) {

    override val binding by viewBinding(FragmentPeopleBinding::bind)
    override val viewModel: PeopleViewModel by viewModels()
    private val peopleAdapter = PeopleAdapter(
        this::onItemClick
    )

    override fun initialize() {
        setupRecyclerview()
    }

    private fun setupRecyclerview() = with(binding.peopleRecview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = peopleAdapter
    }

    override fun setupSubscribes() {
        setupObserves()
    }

    private fun setupObserves() {
        viewModel.fetchPeople().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Arzymat", it.toString())
                    peopleAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            PeopleFragmentDirections.actionPeopleFragmentToDetailPeopleFragment(
                position = id
            )
        )
    }
}



