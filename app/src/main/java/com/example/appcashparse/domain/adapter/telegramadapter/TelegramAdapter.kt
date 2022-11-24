package com.example.appcashparse.domain.adapter.telegramadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcashparse.R
import com.example.appcashparse.domain.models.FileCash
import kotlinx.android.synthetic.main.item_listcash.view.*

class TelegramAdapter: RecyclerView.Adapter<TelegramAdapter.StartViewHolder>() {
    //устанавливаем список
    var listViber = emptyList<FileCash>()
    class StartViewHolder(view: View): RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelegramAdapter.StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listcash,parent,false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: TelegramAdapter.StartViewHolder, position: Int) {
        holder.itemView.nameitem.text = listViber[position].nameFile
        holder.itemView.format.text = listViber[position].formatFile
        holder.itemView.sizeitem.text = listViber[position].sizeFie
    }

    override fun getItemCount(): Int {
        return listViber.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FileCash>){
        listViber = list
        notifyDataSetChanged()
    }
}