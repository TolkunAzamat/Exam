package com.example.examen.models

import java.io.Serializable

data class News(
    var categoryId:Int,
    var image: String,
    val titleNews: String,
    val description: String ?= null
): Serializable

