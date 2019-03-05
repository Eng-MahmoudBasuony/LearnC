package mymobileapp.code.mbasuony.learnc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //if you want is NavigationDrawer open RTL
       //  window.decorView.layoutDirection =View.LAYOUT_DIRECTION_RTL

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed()
    {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else
        {
            super.onBackPressed()
        }
    }





    override fun onNavigationItemSelected(item: MenuItem): Boolean
    {
        // Handle navigation view item clicks here.
        when (item.itemId)
        {
            R.id.nav_main ->
            {
                // Handle the camera action
            }
            R.id.nav_aboutme ->
            {

            }
            R.id.nav_send_message ->
            {  //Send Message to Email
               startActivity(Intent(Intent.ACTION_VIEW,
                                    Uri.parse("mailto:"+"mbasuony83@gmail.com"+"?subject="+"Message From App Learn C++")))
            }
            R.id.nav_share ->
            {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
