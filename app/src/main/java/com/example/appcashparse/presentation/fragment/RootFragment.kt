package com.example.appcashparse.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.appcashparse.R
import com.example.appcashparse.domain.adapter.viewpageradapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_root.view.*

class RootFragment : Fragment() {

    private var ctx: Context?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        view.tab_layout.tabIconTint = null//кастомизируем цвет tl
        view.view_pager.adapter = ViewPagerAdapter(ctx as FragmentActivity)
        TabLayoutMediator(view.tab_layout, view.view_pager){
                tab, pos ->
            when(pos){//установили иконки
                0 -> {
                    tab.setIcon(R.drawable.ic_viber)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_telegram)
                }
            }
        }.attach()
        return view
    }

}