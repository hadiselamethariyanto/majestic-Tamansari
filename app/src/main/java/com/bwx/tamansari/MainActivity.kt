package com.bwx.tamansari

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bwx.tamansari.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_controller) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_detail_news -> {
                    binding.bottomNav.visibility = View.GONE
                    supportActionBar?.hide()
                }
                R.id.navigation_home -> {
                    supportActionBar?.hide()
                }
                R.id.navigation_detail_homestay -> {
                    binding.bottomNav.visibility = View.GONE
                }
                else -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.VISIBLE
                }
            }
        }

//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home,
//                R.id.navigation_dashboard,
//                R.id.navigation_notifications,
//                R.id.navigation_daftar_wisata,
//            ),
//        )

        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_controller)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}