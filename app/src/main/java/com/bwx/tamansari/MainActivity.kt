package com.bwx.tamansari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bwx.tamansari.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_controller) as NavHostFragment
        navController = navHostFragment.navController

//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home,
//                R.id.navigation_dashboard,
//                R.id.navigation_notifications,
//                R.id.navigation_daftar_wisata,
//            ), binding.drawerLayout
//        )

        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)


    }
}