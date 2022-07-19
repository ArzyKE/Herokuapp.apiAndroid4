package com.example.herokuappapiandroid4.models

import com.google.gson.annotations.SerializedName

data class PeopleModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("age")
    val age: String,
)
