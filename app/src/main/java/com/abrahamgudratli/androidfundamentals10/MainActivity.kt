package com.abrahamgudratli.androidfundamentals10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle) // we connected our toggle with drawer layout
        toggle.syncState() // we notify toggle that it is ready to use


        /*that means is that we just that we're just able to open our trouble
        and when it's opened that toggle button we moves to a back arrow and we can
        click on that back arrow and the navigation drawer will close again*/
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        slidable_navigation_menu.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_new_group -> Toast.makeText(this, "New Group", Toast.LENGTH_LONG).show()
                R.id.menu_item_calls -> Toast.makeText(this, "Calls", Toast.LENGTH_LONG).show()
                R.id.menu_item_contacts -> Toast.makeText(this, "Contacts", Toast.LENGTH_LONG).show()
                R.id.menu_item_nearby -> Toast.makeText(this, "People Nearby", Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}