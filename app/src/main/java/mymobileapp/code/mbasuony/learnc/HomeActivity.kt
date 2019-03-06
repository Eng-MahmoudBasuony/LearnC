package mymobileapp.code.mbasuony.learnc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import mymobileapp.code.mbasuony.learnc.fragment.AboutFragment
import mymobileapp.code.mbasuony.learnc.fragment.HomeFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         setSupportActionBar(toolbar)

        if (savedInstanceState==null)
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_home, HomeFragment())
                .commit()
        }

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
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout_home, HomeFragment())
                    .commitNow()
            }
            R.id.nav_aboutme ->
            {
               supportFragmentManager.beginTransaction()
                   .replace(R.id.frameLayout_home, AboutFragment())
                   .commitNow()
            }
            R.id.nav_send_message ->
            {  //Send Message to Email mbasuony83@gmail.com
               startActivity(Intent(Intent.ACTION_VIEW,
                                    Uri.parse("mailto:"+"mbasuony83@gmail.com"+"?subject="+"Message From App Learn C++")))
            }
            R.id.nav_share ->
            {
                //share App
                val send=Intent()
                send.action=Intent.ACTION_SEND
                send.putExtra(Intent.EXTRA_TEXT,"https://github.com/Eng-MahmoudBasuony/Learn-C-Plus-Plus Show me your github ")
                send.type="text/plain"
                startActivity(Intent.createChooser(send,"Choose app"))
            }

            R.id.nav_close ->
            {
                 finish()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
