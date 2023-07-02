package com.itis.hw2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContainerActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val controller = (supportFragmentManager.findFragmentById(R.id.container) as N)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).apply {
            setOnItemReselectedListener {
                when(it.itemId ){
                    R.id.mainFragment -> navigateUpTo()
                }
            }
        }
    }

}