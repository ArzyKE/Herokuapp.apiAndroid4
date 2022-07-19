package com.example.herokuappapiandroid4.ui.fragments.detail

import com.example.herokuappapiandroid4.base.BaseViewModel
import com.example.herokuappapiandroid4.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPeopleViewModel @Inject constructor(private val repository: PeopleRepository) :
    BaseViewModel() {

    fun fetchPeopleId(id: String) = repository.fetchPeopleId(id)
}