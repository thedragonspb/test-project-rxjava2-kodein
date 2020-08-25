package com.thedragonspb.test_project_rxjava2_kodein.app.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {

    @GET("/api/breeds/list/all")
    fun getBreeds(): Single<BreedsResponse>

    @GET("/api/breed/{breed}/images")
    fun getImages(@Path("breed") breed: String): Single<BreedImagesResponse>
}