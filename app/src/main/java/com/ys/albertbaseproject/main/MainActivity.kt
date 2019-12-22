package com.ys.albertbaseproject.main

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.ys.albertbaseproject.R
import com.ys.albertbaseproject.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        Timber.d("call onCreate")

        setSupportActionBar(toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        mainViewModel.loading.observe(this, Observer { isLoading ->
            if(isLoading) {
                pbLoading.visibility = View.VISIBLE
                return@Observer
            }

            pbLoading.visibility = View.GONE
        })

        Glide.with(this)
            .load(R.drawable.profile_thumbnail)
            .into(ivProfile)

        CoroutineScope(Dispatchers.Main).launch {
            Glide.with(applicationContext)
                .load("https://cdn.pixabay.com/photo/2015/06/24/13/32/dog-820014_960_720.jpg")
                .into(ivProfile)
        }

        mainViewModel.getTestPrint()
        mainViewModel.testSavePreference()
        mainViewModel.testGetPreference()

        getRepositoryData()
    }

    private fun getRepositoryData() {
        CoroutineScope(Dispatchers.IO).launch {
            mainViewModel.getPosts()
            mainViewModel.getComments()
        }
    }

    override fun onBackPressed() {
        Timber.d("call onBackPressed")
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                Timber.i("select camera menu")
            }
            R.id.nav_gallery -> {
                Timber.i("select gallery menu")
            }
            R.id.nav_slideshow -> {
                Timber.i("select slideshow menu")
            }
            R.id.nav_manage -> {
                Timber.i("select manage menu")
            }
            R.id.nav_share -> {
                Timber.i("select share menu")
            }
            R.id.nav_send -> {
                Timber.i("select send menu")
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
