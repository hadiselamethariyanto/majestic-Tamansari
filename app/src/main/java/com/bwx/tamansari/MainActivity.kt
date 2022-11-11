package com.bwx.tamansari

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bwx.tamansari.databinding.ActivityMainBinding
import com.bwx.tamansari.ui.akun.AkunFragment
import com.bwx.tamansari.ui.home.HomeFragment
import com.bwx.tamansari.ui.pesan.PesanFragment
import com.bwx.tamansari.ui.riwayat.RiwayatFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_riwayat -> {
                    val fragment = RiwayatFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_home -> {
                    val fragment = HomeFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_akun -> {
                    val fragment = AkunFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_pesan -> {
                    val fragment = PesanFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }


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


//        val navView: BottomNavigationView = binding.navView
//
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        val fragment = HomeFragment()
//        addFragment(fragment)

        supportActionBar?.hide()

//        navView.background = null
        binding.bottomNav.menu.getItem(2).isEnabled = false

        binding.fab.setOnClickListener {
//            scanQrCode()
        }

    }
}