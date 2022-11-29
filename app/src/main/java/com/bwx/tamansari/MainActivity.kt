package com.bwx.tamansari

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
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
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_detail_news -> {
                    binding.bottomNav.visibility = View.GONE
                    supportActionBar?.hide()
                }
                R.id.navigation_home -> {
                    binding.bottomNav.visibility = View.VISIBLE
                    supportActionBar?.hide()
                }
                R.id.navigation_detail_homestay -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_detail_restaurant -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_transaction -> {
                    supportActionBar?.hide()
                    binding.bottomNav.visibility = View.VISIBLE
                }
                R.id.navigation_notifications -> {
                    supportActionBar?.hide()
                }
                R.id.navigation_account -> {
                    supportActionBar?.hide()
                }
                R.id.navigation_daftar_wisata -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_detail_wisata -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_homestay -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_travel_package -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_restaurant -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_news -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_choose_ticket_wisata -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_review_transaction_wisata -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_choose_room -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_review_transaction_homestay -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_detail_travel_packaage -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_choose_travel_package -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_review_transaction_travel_package -> {
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_choose_payment_method -> {
                    supportActionBar?.hide()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_payment_ewallet -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_my_ticket_wisata -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                R.id.navigation_my_failed_ticket_wisata -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.GONE
                }
                else -> {
                    supportActionBar?.show()
                    binding.bottomNav.visibility = View.VISIBLE
                }
            }
        }

        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_controller)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}