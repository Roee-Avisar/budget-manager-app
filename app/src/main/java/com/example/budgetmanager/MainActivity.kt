package com.example.budgetmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
class MainActivity : AppCompatActivity() {

    private lateinit var userProfileViewModel: UserProfileModelView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        userProfileViewModel = ViewModelProvider(this)[UserProfileModelView::class.java]

        val userProfile = userProfileViewModel.getUserProfile()
        if (userProfile != null) {
            navController.navigate(R.id.profileFragment)
        } else {
            navController.navigate(R.id.createAccountFragment)
        }

    }
}

