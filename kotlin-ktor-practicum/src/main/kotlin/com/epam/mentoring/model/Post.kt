package com.epam.mentoring.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int? = null,
    val userId: Int,
    val title: String,
    val body: String,
)
