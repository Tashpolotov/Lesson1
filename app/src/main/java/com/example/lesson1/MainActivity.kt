package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        supportFragmentManager.beginTransaction().replace(R.id.fr_container, HomeFragment()).commit()


        binding.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.favourite -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, FavouriteFragment()).commit()
                    true
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, SettingFragment()).commit()
                    true
                } else -> false
            }

        }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, HomeFragment()).commit()
                    true
                }
                R.id.car -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, CarFragment()).commit()
                    true
                }
                R.id.account -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, AccountFragment()).commit()
                    true
                }
                R.id.delete -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fr_container, DeleteFragment()).commit()
                    true
                } else -> false

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.app_bar, menu)

        return true
    }
}