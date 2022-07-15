package com.example.herokuappapiandroid4.ui.fragments.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.herokuappapiandroid4.R
import com.example.herokuappapiandroid4.databinding.FragmentDetailPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPeopleFragment : Fragment(R.layout.fragment_detail_people) {

    private val viewBinding by viewBinding(FragmentDetailPeopleBinding::bind)
    private val viewModel: DetailPeopleViewModel by viewModels()
    private val args by navArgs<DetailPeopleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchPeopleId(args.position).observe(viewLifecycleOwner) { peopleDetail ->
            viewBinding.itemDetailPeopleAge.text = peopleDetail.toString()
            viewBinding.itemDetailPeopleGender.text = peopleDetail.toString()
            viewBinding.itemDetailPeopleName.text = peopleDetail.toString()

        }

    }
}