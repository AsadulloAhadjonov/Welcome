package com.example.viwpager

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TableLayout
import androidx.annotation.RequiresApi
import com.example.viwpager.Adapter.Adapter
import com.example.viwpager.Utils.MyData
import com.example.viwpager.databinding.ActivityMainBinding
import com.example.viwpager.databinding.ItemBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: Adapter
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MyData.addUser()

        adapter = Adapter(MyData.list)
        binding.viewpager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewpager)

        setMyTabLayout()
    }

    private fun setMyTabLayout() {
        val count = binding.tabLayout.tabCount
        for (i in 0 .. count){
            val item = ItemBinding.inflate(layoutInflater)
            val tab = binding.tabLayout.getTabAt(i)
            tab?.customView = item.root
            tab?.view?.findViewById<LinearLayout>(R.id.tab_indicator)?.alpha = 0.1F
        }

        binding.btn.setOnClickListener {
            val lastPageIndex = adapter.count - 1
            binding.viewpager.setCurrentItem(lastPageIndex, true)
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indicator)?.alpha = 1F
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indicator)?.alpha = 0.1F
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}