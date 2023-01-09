package com.example.convo_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.convo_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment //get a reference to the nav_host_fragment
        navController = navHostFragment.navController //assign it to the navController property
        //setupActionBarWithNavController(navController) //ensures that action bar(app bar) buttons are visible

    }



    /*
    This method allows you to handle the UP button, alongside setting defaultNavHost in XMl
     */

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
        /*
         Because the navigateUp() function might fail, it returns a Boolean for whether or not it succeeds. However, you only need to call super.onSupportNavigateUp() if navigateUp() returns false. This works because of the || operator only requires one of the conditions to be true, so if navigateUp() returns true, the right side of the || expression is never executed. If, however, navigateUp() is false, then the implementation in the parent class is called. This is called short-circuit evaluation and is a nice little programming trick to know about.
         */
    }

}