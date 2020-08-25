package com.thedragonspb.test_project_rxjava2_kodein.breed_images.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ImagesPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val images: MutableList<String> = mutableListOf()

    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment =
        ImageFragment.create(images[position])

    fun submitList(imageList: List<String>) {
        images.apply {
            clear()
            addAll(imageList)
        }
        notifyDataSetChanged()
    }
}