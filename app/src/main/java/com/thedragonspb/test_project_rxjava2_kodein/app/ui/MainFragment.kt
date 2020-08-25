package com.thedragonspb.test_project_rxjava2_kodein.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.thedragonspb.test_project_rxjava2_kodein.R
import com.thedragonspb.test_project_rxjava2_kodein.app.ui.adapter.ViewPagerAdapter
import com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.BreedsFragment
import com.thedragonspb.test_project_rxjava2_kodein.favourites.ui.FavouritesFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainFragment : Fragment() {

    private var checkedMenuItem = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupToolbar()
        setupViewPager()
        setupNavigation()
    }

    private fun setupToolbar() {
        toolbarBackButton.visibility = View.GONE
        toolbarShareButton.visibility = View.GONE
        toolbarTitle.text = getString(R.string.breeds)
    }

    private fun setupViewPager() {
        val adapter =
            ViewPagerAdapter(
                childFragmentManager
            )
        adapter.setItems(
            listOf(
                BreedsFragment(),
                FavouritesFragment()
            )
        )

        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(position: Int, posOffset: Float, posOffsetPixels: Int) { }

            override fun onPageSelected(position: Int) {
                if (checkedMenuItem != position) {
                    navigationView.menu.getItem(checkedMenuItem).isChecked = false
                    navigationView.menu.getItem(position).isChecked = true
                    checkedMenuItem = position
                    toolbarTitle.text = when (position) {
                        0 -> getString(R.string.breeds)
                        else -> getString(R.string.favourites)
                    }
                }
            }
        })
    }

    private fun setupNavigation() {
        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_list -> viewPager.currentItem = 0
                R.id.navigation_favourites -> viewPager.currentItem = 1
            }
            return@setOnNavigationItemSelectedListener true
        }

    }
}