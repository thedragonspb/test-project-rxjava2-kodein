package com.thedragonspb.test_project_rxjava2_kodein.breed_images.gateway

import com.thedragonspb.test_project_rxjava2_kodein.app.api.DogsApi
import io.reactivex.Single

class BreedImagesGateway(
    private val dogsApi: DogsApi,
    private val breedImagesConverter: BreedImagesConverter
) {

    fun getImages(breed: String): Single<List<String>> =
        dogsApi
            .getImages(breed)
            .map {
                breedImagesConverter.fromNetwork(it)
            }

}