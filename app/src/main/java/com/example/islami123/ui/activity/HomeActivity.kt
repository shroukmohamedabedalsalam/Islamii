package com.example.islami123.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami123.R
import com.example.islami123.fragment.HadethFragment
import com.example.islami123.fragment.QuraanFragment
import com.example.islami123.fragment.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener { item->

            if (item.itemId == R.id.quraan_navigation){
                    pushFragment(QuraanFragment())
            }else if (item.itemId == R.id.hadeth_navigation){
                    pushFragment(HadethFragment())
            }else if (item.itemId == R.id.tasbeh_navigation){
                    pushFragment(TasbehFragment())
            }

            true }
    }
    fun pushFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.navigation_container,fragment)
            .addToBackStack(null).commit()
    }
}