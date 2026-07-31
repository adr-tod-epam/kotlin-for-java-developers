package com.epam.mentoring.client

import com.epam.mentoring.model.Comment
import com.epam.mentoring.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

class ApiException(
    val statusCode: Int,
    override val message: String,
) : RuntimeException(message)

class JsonPlaceholderClient(
    private val httpClient: HttpClient,
) {
    suspend fun getAllPosts(): List<Post> =
        httpClient.get("$BASE_URL/posts").body()

    suspend fun getCommentsByUserId(userId: Int): List<Comment> =
        httpClient.get("$BASE_URL/comments?userId=$userId").body()

    suspend fun createPost(post: Post): Post =
        httpClient.post("$BASE_URL/posts") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }.body()

    suspend fun updatePost(id: Int, post: Post): Post =
        httpClient.put("$BASE_URL/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }.body()

    suspend fun deletePost(id: Int) {
        httpClient.delete("$BASE_URL/posts/$id")
    }

    companion object {
        fun create(httpClient: HttpClient? = null): JsonPlaceholderClient {
            val client = httpClient ?: HttpClient(CIO) {
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                    })
                }
                HttpResponseValidator {
                    validateResponse { response ->
                        if (!response.status.isSuccess()) {
                            throw ApiException(
                                statusCode = response.status.value,
                                message = response.bodyAsText().ifBlank {
                                    "Json Placeholder Public API returned ${response.status.value}"
                                },
                            )
                        }
                    }
                }
            }
            return JsonPlaceholderClient(client)
        }
    }
}
