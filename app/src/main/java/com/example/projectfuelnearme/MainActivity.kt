package com.example.projectfuelnearme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.inflate
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectfuelnearme.databinding.ActivityMainBinding
import com.example.projectfuelnearme.databinding.ActivityMainBinding.inflate
import com.example.projectfuelnearme.views.dashboardfragment
import com.example.projectfuelnearme.views.othersfragment
import com.example.projectfuelnearme.views.routefragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dashboardfrag = dashboardfragment()
    private val routetravelfrag = routefragment()
    private val othersectionfrag = othersfragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(dashboardfrag)

        bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.find_bottom_nav -> {
                    replaceFragment(dashboardfrag)
                    true
                }
                R.id.travel_bottom_nav -> {
                    replaceFragment(routetravelfrag)
                    Toast.makeText(applicationContext,"button clicked",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.others_bottom_nav -> {
                    replaceFragment(othersectionfrag)
                    true
                }
                else -> false
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.dashboard_framelayout,fragment)
            commit()
        }
}

