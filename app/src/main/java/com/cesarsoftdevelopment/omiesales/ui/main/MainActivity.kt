package com.cesarsoftdevelopment.omiesales.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.databinding.ActivityMainBinding
import com.cesarsoftdevelopment.omiesales.ui.main.makesale.MakeSaleViewModel
import com.cesarsoftdevelopment.omiesales.ui.main.makesale.MakeSaleViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var makeSaleViewModelFactory : MakeSaleViewModelFactory

    val makeSaleViewModel : MakeSaleViewModel by viewModels {
        makeSaleViewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_make_sale,
                R.id.navigation_sale_history
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}