package com.epam.mentoring

import com.epam.mentoring.client.ApiException
import com.epam.mentoring.client.JsonPlaceholderClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun getAllPosts_returnsOk() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient { request ->
                when {
                    request.url.encodedPath == "/posts" && request.method == HttpMethod.Get ->
                        respond(
                            """[{"id":1,"userId":1,"title":"title","body":"body"}]""",
                            HttpStatusCode.OK,
                            jsonHeaders()
                        )

                    else -> respond("Not found", HttpStatusCode.NotFound)
                }
            }))
        }

        val response = client.get("/posts")
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().contains("\"id\":1"))
    }

    @Test
    fun getComments_withUserId_returnsOk() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient { request ->
                when {
                    request.url.encodedPath == "/comments" &&
                            request.url.parameters["userId"] == "1" &&
                            request.method == HttpMethod.Get ->
                        respond(
                            """[{"id":1,"postId":1,"name":"name","email":"email@test.com","body":"comment body"}]""",
                            HttpStatusCode.OK,
                            jsonHeaders(),
                        )

                    else -> respond("Not found", HttpStatusCode.NotFound)
                }
            }))
        }

        val response = client.get("/comments?userId=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().contains("\"postId\":1"))
    }

    @Test
    fun getComments_withoutUserId_returnsBadRequest() = testApplication {
        application { configureApp(JsonPlaceholderClient(createMockClient { respond("unused", HttpStatusCode.OK) })) }

        val response = client.get("/comments")
        assertEquals(HttpStatusCode.BadRequest, response.status)
        assertTrue(response.bodyAsText().contains("userId"))
    }

    @Test
    fun createPost_returnsCreated() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient { request ->
                when {
                    request.url.encodedPath == "/posts" && request.method == HttpMethod.Post ->
                        respond(
                            """{"id":101,"userId":1,"title":"foo","body":"bar"}""",
                            HttpStatusCode.Created,
                            jsonHeaders()
                        )

                    else -> respond("Not found", HttpStatusCode.NotFound)
                }
            }))
        }

        val response = client.post("/posts") {
            headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()
            setBody("""{"userId":1,"title":"foo","body":"bar"}""")
        }
        assertEquals(HttpStatusCode.Created, response.status)
        assertTrue(response.bodyAsText().contains("\"id\":101"))
    }

    @Test
    fun updatePost_returnsOk() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient { request ->
                when {
                    request.url.encodedPath == "/posts/1" && request.method == HttpMethod.Put ->
                        respond(
                            """{"id":1,"userId":1,"title":"updated","body":"updated body"}""",
                            HttpStatusCode.OK,
                            jsonHeaders()
                        )

                    else -> respond("Not found", HttpStatusCode.NotFound)
                }
            }))
        }

        val response = client.put("/posts/1") {
            headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()
            setBody("""{"userId":1,"title":"updated","body":"updated body"}""")
        }
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().contains("\"title\":\"updated\""))
    }

    @Test
    fun deletePost_returnsNoContent() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient { request ->
                when {
                    request.url.encodedPath == "/posts/1" && request.method == HttpMethod.Delete ->
                        respond("", HttpStatusCode.OK, jsonHeaders())

                    else -> respond("Not found", HttpStatusCode.NotFound)
                }
            }))
        }

        val response = client.delete("/posts/1")
        assertEquals(HttpStatusCode.NoContent, response.status)
    }

    @Test
    fun whenJsonPlaceholderFails_returnsError() = testApplication {
        application {
            configureApp(JsonPlaceholderClient(createMockClient {
                respond("Post not found", HttpStatusCode.NotFound, jsonHeaders())
            }))
        }

        val response = client.get("/posts")
        assertEquals(HttpStatusCode.NotFound, response.status)
        assertTrue(response.bodyAsText().contains("Post not found"))
    }

    // Fake HttpClient that pretends to be JSONPlaceholder (used in tests only)
    private fun createMockClient(
        handler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData,
    ): HttpClient {
        val mockEngine = MockEngine { request -> handler(request) }
        return HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true; isLenient = true })
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
    }

    private fun jsonHeaders() = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
}
