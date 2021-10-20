package com.ttmx.clipplusplus

import android.animation.LayoutTransition
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.transition.ArcMotion
import androidx.transition.Transition
import androidx.transition.TransitionManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.transition.MaterialContainerTransform
import com.ttmx.clipplusplus.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var iconParams: ConstraintLayout.LayoutParams

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var settingsCard: CardView
    private lateinit var settingsButton: CardView
    private lateinit var userIcon: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        val navView: BottomNavigationView = binding.navView



        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = ViewPagerAdapter(this)
        bottomNavigation = findViewById(R.id.nav_view)
        settingsCard = findViewById(R.id.full_settings_card)
        settingsButton = findViewById(R.id.icon_background_card)
        iconParams = settingsButton.layoutParams as ConstraintLayout.LayoutParams
        settingsButton.setOnClickListener { toggleFabMenu() }
        settingsCard.setOnClickListener { toggleFabMenu() }
        userIcon = findViewById(R.id.pfp_card)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigation.selectedItemId = R.id.navigation_home
                    1 -> bottomNavigation.selectedItemId = R.id.navigation_dashboard
                    2 -> bottomNavigation.selectedItemId = R.id.navigation_notifications
                }
                super.onPageSelected(position)
            }
        })


//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
        supportActionBar?.hide()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> viewPager.currentItem = 0
            R.id.navigation_dashboard -> viewPager.currentItem = 1
            R.id.navigation_notifications -> viewPager.currentItem = 2
        }
        return true
    }

    private fun toggleFabMenu() {
//        val views = listOf<View>(settingsCard, settingsButton).sortedBy { !it.isVisible }
//
//        val shareMenuTransform: Transition = MaterialContainerTransform().apply {
//            startView = views.first()
//            endView = views.last()
//            scrimColor = Color.TRANSPARENT
//            duration = 500
//            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
////            setPathMotion(ArcMotion())
//        }
//        TransitionManager.beginDelayedTransition(binding.root, shareMenuTransform)
//        views.first().isVisible = false
//        views.last().isVisible = true

        if (settingsButton.layoutParams == iconParams){
            val lp: ConstraintLayout.LayoutParams = settingsButton.layoutParams as ConstraintLayout.LayoutParams
            lp.startToStart = R.id.container
            lp.width = 0
            lp.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
            lp.matchConstraintMinHeight = 300
            settingsButton.layoutParams = lp
        }else{
            settingsButton.layoutParams = iconParams
        }


    }

}