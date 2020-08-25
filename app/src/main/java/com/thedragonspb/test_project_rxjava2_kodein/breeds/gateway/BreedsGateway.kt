package com.thedragonspb.test_project_rxjava2_kodein.breeds.gateway

import com.thedragonspb.test_project_rxjava2_kodein.app.api.DogsApi
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.adapter.Breed
import io.reactivex.Single

class BreedsGateway(
    private val dogsApi: DogsApi,
    private val breedsConverter: BreedsConverter
) {

    fun getBreeds(): Single<List<Breed>> =
        dogsApi
            .getBreeds()
            .map {
                breedsConverter.fromNetwork(it)
            }

}