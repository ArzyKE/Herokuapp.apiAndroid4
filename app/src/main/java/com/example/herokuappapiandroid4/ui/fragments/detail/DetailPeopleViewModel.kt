package com.example.herokuappapiandroid4.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.herokuappapiandroid4.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPeopleViewModel @Inject constructor(private val repository: PeopleRepository) :
    ViewModel() {

    fun fetchPeopleId(position: Int) = repository.fetchPeopleId(position)
}