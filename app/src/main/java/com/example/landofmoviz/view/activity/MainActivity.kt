package com.example.landofmoviz.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.landofmoviz.R
import com.example.landofmoviz.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LandofMoviz)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController


//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val inflater = navHostFragment.navController.navInflater
//        val graph = inflater.inflate(R.navigation.nav_graph)
//
//        if (isTrue){
//            graph.setStartDestination(R.id.homeFragment)
//        }else {
//            graph.setStartDestination(R.id.homeFragment)
//        }
//
//        val navController = navHostFragment.navController
//        navController.setGraph(graph, intent.extras)


        binding.bottomNavBar.setupWithNavController(navController)

        if (getIsFirstLaunch()) showAlertDialog()
    }

    private fun getIsFirstLaunch() = runBlocking {
        dataStore.data.first()[PreferencesKey.IS_FIRST_LAUNCH] ?: true
    }

    private fun setIsFirstLaunch() {
        runBlocking {
            dataStore.edit { preferences ->
                preferences[PreferencesKey.IS_FIRST_LAUNCH] = false
            }
        }
    }

    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(this)
            .setIcon(AppCompatResources.getDrawable(this, R.drawable.ic_tmdb_24))
            .setTitle(getString(R.string.tmdb_attribution_title))
            .setMessage(getString(R.string.tmdb_attribution_message))
            .setPositiveButton(getString(R.string.tmdb_attribution_button_text)) { dialog, _ ->
                setIsFirstLaunch()
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()
            .show()
    }

    private object PreferencesKey {
        val IS_FIRST_LAUNCH = booleanPreferencesKey("is_first_launch")
    }
}