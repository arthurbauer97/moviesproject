package com.example.moviesproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.moviesproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        binding.bottomNavigation.setOnItemSelectedListener  { item ->
            when(item.itemId) {
                R.id.home -> {
                    val homeFragment: HomeFragment = HomeFragment()
                    openFragment(homeFragment)
                    true
                }
                R.id.movies -> {
                    val moviesFragment: MoviesFragment = MoviesFragment()
                    openFragment(moviesFragment)
                    true
                }
                R.id.profile -> {
                    val profileFragment: ProfileFragment = ProfileFragment()
                    openFragment(profileFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}