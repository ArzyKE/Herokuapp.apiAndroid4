package com.example.herokuappapiandroid4.data.apiservices

import com.example.herokuappapiandroid4.models.PeopleDetailModel
import com.example.herokuappapiandroid4.models.PeopleModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApiServices {

    @GET("people")
    suspend fun fetchPeople(): List<PeopleModel>

    @GET("people/{id}")
    suspend fun fetchPeopleId(
        @Path("people_id") id: Int
    ): List<PeopleDetailModel>
}
