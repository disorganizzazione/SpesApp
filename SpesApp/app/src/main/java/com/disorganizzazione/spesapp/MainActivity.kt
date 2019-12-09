package com.disorganizzazione.spesapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room
import com.disorganizzazione.spesapp.db.IngredientDAO
import com.disorganizzazione.spesapp.db.IngredientEntity
import com.disorganizzazione.spesapp.db.SpesAppDB
import com.disorganizzazione.spesapp.ui.main.SectionsPagerAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // linea di codice magica e misteriosa/mysterious magical line
        var db = Room.databaseBuilder(applicationContext, SpesAppDB::class.java,"SpesAppDB").build()

        // TEST
        // TODO: cancellare/delete
        Thread {
            var testIngr = IngredientEntity()
            testIngr.name = "Carote"
            testIngr.portions = null
            testIngr.useBefore = Date(0)
            testIngr.inStorage = true

            db.ingredientDAO().insertIngredient(testIngr)
        }.start()

    }
}