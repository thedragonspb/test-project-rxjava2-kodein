package com.thedragonspb.test_project_rxjava2_kodein.breeds.ui

import androidx.lifecycle.ViewModel
import com.thedragonspb.test_project_rxjava2_kodein.app.api.BreedImagesResponse
import com.thedragonspb.test_project_rxjava2_kodein.breeds.gateway.BreedsGateway
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.adapter.Breed
import io.reactivex.Single

class BreedsViewModel(
    private val breedsGateway: BreedsGateway
) : ViewModel() {

    fun getBreeds(): Single<List<Breed>> {
        return breedsGateway.getBreeds()
    }

}