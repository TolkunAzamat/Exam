package com.example.examen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen.Category2
import com.example.examen.R
import com.example.examen.adapters.NewsAdapter

import com.example.examen.models.Constants
import com.example.examen.models.News


class NewsFragment : Fragment() {
    lateinit var title: TextView
    lateinit var imageView: ImageView
    lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.more_information, container, false)
        title = view.findViewById(R.id.textView1)
        imageView = view.findViewById(R.id.image1)
        description = view.findViewById(R.id.descriptions)

        val news = arguments?.getSerializable("NEWS") as News


        title.text = news.titleNews
        Glide.with(this).load(news.image).into(imageView)
        description.text = news.description

        return view
    }
}