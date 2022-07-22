package com.example.herokuappapiandroid4.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.herokuappapiandroid4.utils.Either
import com.example.herokuappapiandroid4.R
import com.example.herokuappapiandroid4.base.BaseFragment
import com.example.herokuappapiandroid4.databinding.FragmentDetailPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPeopleFragment :
    BaseFragment<DetailPeopleViewModel, FragmentDetailPeopleBinding>(R.layout.fragment_detail_people) {

    override val binding by viewBinding(FragmentDetailPeopleBinding::bind)
    override val viewModel: DetailPeopleViewModel by viewModels()
    private val args by navArgs<DetailPeopleFragmentArgs>()

    override fun setupSubscribes() {
        viewModel.fetchPeopleId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Arzymat", it.toString())
                    binding.itemDetailPeopleName.text = it.value.name
                    binding.itemDetailPeopleGender.text = it.value.gender
                    binding.itemDetailPeopleAge.text = it.value.id
                }
            }
        }
    }
}