package com.epam.mentoring

import com.epam.mentoring.client.ApiException
import com.epam.mentoring.client.JsonPlaceholderClient
import com.epam.mentoring.model.Post
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureApp()
    }.start(wait = true)
}

fun Application.configureApp(client: JsonPlaceholderClient = JsonPlaceholderClient.create()) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }

    routing {
        route("/posts") {
            get {
                try {
                    call.respond(client.getAllPosts())
                } catch (e: ApiException) {
                    call.respondApiError(e)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
                }
            }
            post {
                try {
                    val post = call.receive<Post>()
                    call.respond(HttpStatusCode.Created, client.createPost(post))
                } catch (e: ApiException) {
                    call.respondApiError(e)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
                }
            }
            put("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        mapOf("error" to "Path parameter 'id' must be a valid integer")
                    )
                    return@put
                }
                try {
                    val post = call.receive<Post>()
                    call.respond(client.updatePost(id, post))
                } catch (e: ApiException) {
                    call.respondApiError(e)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
                }
            }
            delete("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        mapOf("error" to "Path parameter 'id' must be a valid integer")
                    )
                    return@delete
                }
                try {
                    client.deletePost(id)
                    call.respond(HttpStatusCode.NoContent)
                } catch (e: ApiException) {
                    call.respondApiError(e)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
                }
            }
        }
        get("/comments") {
            val userId = call.request.queryParameters["userId"]?.toIntOrNull()
            if (userId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    mapOf("error" to "Query parameter 'userId' is required and must be a valid integer")
                )
                return@get
            }
            try {
                call.respond(client.getCommentsByUserId(userId))
            } catch (e: ApiException) {
                call.respondApiError(e)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
            }
        }
    }
}

private suspend fun io.ktor.server.application.ApplicationCall.respondApiError(e: ApiException) {
    val status = when {
        e.statusCode in 400..499 -> HttpStatusCode.fromValue(e.statusCode)
        else -> HttpStatusCode.BadGateway
    }
    respond(status, mapOf("error" to e.message))
}
