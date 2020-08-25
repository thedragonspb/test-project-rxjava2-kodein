package com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flexsentlabs.extensions.viewModel
import com.thedragonspb.test_project_rxjava2_kodein.R
import com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui.adapter.ImagesPagerAdapter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.autoDispose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_breed_images.*
import kotlinx.android.synthetic.main.toolbar.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import timber.log.Timber

class BreedImagesFragment: Fragment(), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: BreedImagesViewModel by viewModel()

    private lateinit var adapter: ImagesPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_breed_images, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupViewPager()
        listenToBreedImages()
    }

    private fun listenToBreedImages() {
        arguments?.getString("breed")?.let { breed ->
            viewModel
                .getImages(breed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .autoDispose(AndroidLifecycleScopeProvider.from(lifecycle))
                .subscribe(
                    { images ->
                        adapter.submitList(images)
                    },
                    Timber::e
                )
        }

    }

    private fun setupViewPager() {
        adapter = ImagesPagerAdapter(requireActivity())

        viewPager.adapter = adapter
    }


    private fun setupToolbar() {
        prevPageTitle.text = resources.getString(R.string.breeds)
        prevPageTitle.setOnClickListener { activity?.onBackPressed() }

        toolbarBackButton.setOnClickListener { activity?.onBackPressed() }

        toolbarShareButton.setOnClickListener {

        }

        toolbarTitle.text = arguments?.getString("breed")
    }

}