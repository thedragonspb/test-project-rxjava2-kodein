package com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.thedragonspb.test_project_rxjava2_kodein.R
import kotlinx.android.synthetic.main.fragment_image.*
import java.lang.Exception

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_image, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = arguments?.getString(IMAGE_URL_ARG)
        Picasso.get()
            .load(imageUrl)
            .into(imageView, object : Callback{
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                    imageView.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    TODO("Not yet implemented")
                }

            })
    }

    companion object {
        private const val IMAGE_URL_ARG = "image_url_arg"

        fun create(image: String): ImageFragment {
            return ImageFragment().apply {
                arguments =
                    Bundle().apply {
                        putString(IMAGE_URL_ARG, image)
                    }
            }
        }
    }
}