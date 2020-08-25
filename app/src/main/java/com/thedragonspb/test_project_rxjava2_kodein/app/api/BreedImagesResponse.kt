package com.thedragonspb.test_project_rxjava2_kodein.app.api

import com.google.gson.annotations.SerializedName

class BreedImagesResponse {

    @SerializedName("message")
    var images: List<String>? = null

    @SerializedName("status")
    var status: String? = null
}