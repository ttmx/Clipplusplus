package com.ttmx.clipplusplus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ttmx.clipplusplus.ui.dashboard.DashboardFragment
import com.ttmx.clipplusplus.ui.home.HomeFragment
import com.ttmx.clipplusplus.ui.notifications.NotificationsFragment


class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationsFragment()
            else -> HomeFragment()
        }
    }
}