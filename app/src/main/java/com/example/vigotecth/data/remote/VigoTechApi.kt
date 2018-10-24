package com.example.vigotecth.data.remote

import com.example.vigotecth.data.model.Group
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface VigoTechApi {

    @GET("groups.json")
    fun groups(): Single<List<Group>>
}