package com.example.examen.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen.R
import com.example.examen.fragments.NewsFragment
import com.example.examen.models.News

class NewsAdapter(private val array: java.util.ArrayList<News>, private val context: FragmentActivity) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.imageViewnews)
        val title = view.findViewById<TextView>(R.id.titlenews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.titleNews
        Glide.with(holder.itemView).load(item.image).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("NEWS", item)

            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsFragment::class.java, bundle)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

}