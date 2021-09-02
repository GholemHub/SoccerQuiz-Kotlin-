package com.example.soccerquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.soccerquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLauout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLauout = binding.drawerLayout

        val navController = this.findNavController(R.id.appNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLauout)



        NavigationUI.setupWithNavController (binding.navigationView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.appNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLauout)
    }
}