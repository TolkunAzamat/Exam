package com.example.examen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen.R
import com.example.examen.adapters.NewsAdapter
import com.example.examen.models.Constants
import com.example.examen.models.News

class NewsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newswire, container, false)

        val currentCategory = requireArguments().getInt("CATEGORY")

        val filteredArray = Constants.news.filter{ it.categoryId == currentCategory} as ArrayList

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewfragment)
        recyclerView.adapter = NewsAdapter(filteredArray, requireActivity())

        return view
    }

}