package com.thedragonspb.test_project_rxjava2_kodein.app.ui.adapter

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import timber.log.Timber

internal class ViewPagerAdapter(manager: FragmentManager) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragmentList: ArrayList<Fragment> = arrayListOf()

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
        try {
            super.restoreState(state, loader)
        } catch (t: Throwable) {
            Timber.e(t)
        }
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun setItems(fragments: List<Fragment>) {
        fragmentList.clear()
        fragmentList.addAll(fragments)
        notifyDataSetChanged()
    }
}
