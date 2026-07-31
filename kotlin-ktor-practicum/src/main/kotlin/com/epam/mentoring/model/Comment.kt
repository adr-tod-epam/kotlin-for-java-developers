package com.epam.mentoring.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int? = null,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String,
)
