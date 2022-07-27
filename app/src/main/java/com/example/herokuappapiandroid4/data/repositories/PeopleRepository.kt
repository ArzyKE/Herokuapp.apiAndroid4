package com.example.herokuappapiandroid4.data.repositories

import com.example.herokuappapiandroid4.data.apiservices.PeopleApiServices
import com.example.herokuappapiandroid4.data.repositories.base.BaseRepository
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val apiServices: PeopleApiServices) :
    BaseRepository() {

    fun fetchPeople() = doRequest { apiServices.fetchPeople() }

    fun fetchPeopleId(id: String) = doRequest { apiServices.fetchPeopleId(id) }
}

