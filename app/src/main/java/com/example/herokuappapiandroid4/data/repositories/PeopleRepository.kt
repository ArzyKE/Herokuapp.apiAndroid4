package com.example.herokuappapiandroid4.data.repositories

import androidx.lifecycle.liveData
import com.example.Either
import com.example.herokuappapiandroid4.data.apiservices.PeopleApiServices
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val apiServices: PeopleApiServices) {

    fun fetchPeople() = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiServices.fetchPeople()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }

    fun fetchPeopleId(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiServices.fetchPeopleId(id = id)))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}
