package com.example.herokuappapiandroid4.ui.fragments

import com.example.herokuappapiandroid4.base.BaseViewModel
import com.example.herokuappapiandroid4.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repository: PeopleRepository) : BaseViewModel() {

    fun fetchPeople() = repository.fetchPeople()
}