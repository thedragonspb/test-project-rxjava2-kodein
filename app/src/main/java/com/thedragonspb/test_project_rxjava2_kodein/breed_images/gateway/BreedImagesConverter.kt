package com.thedragonspb.test_project_rxjava2_kodein.breed_images.gateway

import com.thedragonspb.test_project_rxjava2_kodein.app.api.BreedImagesResponse

class BreedImagesConverter {

    fun fromNetwork(breedImagesResponse: BreedImagesResponse): List<String> {
        val breedImagesList = arrayListOf<String>()
        breedImagesResponse.images?.map { image -> breedImagesList.add(image) }
        return breedImagesList
    }
}