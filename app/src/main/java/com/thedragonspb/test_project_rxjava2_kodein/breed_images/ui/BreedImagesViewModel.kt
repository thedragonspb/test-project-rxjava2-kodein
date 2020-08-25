package com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui

import androidx.lifecycle.ViewModel
import com.thedragonspb.test_project_rxjava2_kodein.breed_images.gateway.BreedImagesGateway
import io.reactivex.Single

class BreedImagesViewModel(
    private val breedImagesGateway: BreedImagesGateway
) : ViewModel() {

    fun getImages(breed: String) : Single<List<String>> =
        breedImagesGateway.getImages(breed)

}
