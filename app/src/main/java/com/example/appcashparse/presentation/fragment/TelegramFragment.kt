package com.example.appcashparse.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appcashparse.R
import com.example.appcashparse.domain.adapter.viberadapter.ViberAdapter
import com.example.appcashparse.presentation.viewmodel.ViberViewModel
import kotlinx.android.synthetic.main.fragment_telegram.view.*
import kotlinx.android.synthetic.main.fragment_viber.view.*

class TelegramFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ViberAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[ViberViewModel::class.java]
        val v = inflater.inflate(R.layout.fragment_telegram, container, false)
        recyclerView = v.rv_telegram
        adapter = ViberAdapter()
        recyclerView.adapter = adapter
        viewModel.getListTelegram()
        viewModel.telegramList.observe(viewLifecycleOwner){list ->
            list.let { adapter.setList((it)) }
        }
        return v
    }

}