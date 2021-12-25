package com.example.examen.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.R
import com.example.examen.fragments.NewsFragment
import com.example.examen.fragments.NewsListFragment
import com.example.examen.models.Category

class CategoryAdapter(private val array: ArrayList<Category>, val context: FragmentActivity) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.category_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = holder.itemView.context.getString(item.text)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("CATEGORY", item.id)

            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsListFragment::class.java, bundle)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

}