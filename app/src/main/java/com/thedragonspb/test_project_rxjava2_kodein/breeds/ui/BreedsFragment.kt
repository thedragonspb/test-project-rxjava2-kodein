package com.thedragonspb.test_project_rxjava2_kodein.breeds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexsentlabs.androidcommons.app.ui.LoadingDialog
import com.flexsentlabs.extensions.viewModel
import com.thedragonspb.test_project_rxjava2_kodein.R
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.adapter.BreedsAdapter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.autoDispose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_breeds.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import timber.log.Timber


class BreedsFragment : Fragment(), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: BreedsViewModel by viewModel()

    private lateinit var breedsAdapter: BreedsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_breeds, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        listenForBreeds()
    }

    private fun listenForBreeds() {
        viewModel
            .getBreeds()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { LoadingDialog.show(parentFragmentManager) }
            .doFinally { LoadingDialog.hide() }
            .observeOn(AndroidSchedulers.mainThread())
            .autoDispose(AndroidLifecycleScopeProvider.from(viewLifecycleOwner))
            .subscribe(
                { breeds ->
                    breedsAdapter.submitList(breeds)
                },
                Timber::e
            )
    }

    private fun setupViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        breedsAdapter = BreedsAdapter { breed ->
            findNavController().navigate(
                R.id.to_breed_images,
                bundleOf("breed" to breed)
            )
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = breedsAdapter
        }
    }
}