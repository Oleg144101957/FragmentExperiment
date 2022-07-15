package com.vishnevskiypro.fragmentexperiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vishnevskiypro.fragmentexperiment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}

        val firstFragment = FragmentFirst()
        val secondFragment = FragmentSecond()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContainer, firstFragment)
            addToBackStack(null)
            commit()
        }

        binding.btnfragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, secondFragment)
                commit()
            }
        }

        binding.btnfragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}