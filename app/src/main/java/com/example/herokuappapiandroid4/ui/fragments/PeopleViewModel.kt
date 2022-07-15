package com.example.herokuappapiandroid4.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.herokuappapiandroid4.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repository: PeopleRepository) : ViewModel() {

    fun fetchPeople() = repository.fetchPeople()
}