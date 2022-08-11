package com.example.navdrawer

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.menu.MenuView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         drawerLayout  = findViewById(R.id.drawerLayout)
        val  navView : NavigationView = findViewById(R.id.navView)


        toggle = ActionBarDrawerToggle(this, drawerLayout,  R.string.Open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.setting -> replaceFragment(HomeFragment(),it.title.toString())
                R.id.profile -> replaceFragment(ProfileFragment(), it.title.toString())
                R.id.home -> replaceFragment(HomeFragment(),it.title.toString() )
                R.id.privacy -> replaceFragment(ProfileFragment(), it.title.toString())
                R.id.help -> replaceFragment(HelpFragment(), it.title.toString())
                R.id.category -> replaceFragment(CategoryFragment(), it.title.toString())
                R.id.cart -> replaceFragment(CartFragment(), it.title.toString())
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

        drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}