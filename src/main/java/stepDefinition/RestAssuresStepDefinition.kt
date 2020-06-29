package stepDefinition

import core.Rest
import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.Gson
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Então
import io.cucumber.java.pt.Quando
import model.get.GetResponse
import model.post.PostResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue


class RestAssuresStepDefinition {

    private var baseurl = "https://postman-echo.com"
    private lateinit var endpoint: String
    private var response = ""
    private val bodyRaw = "This is expected to be sent back as part of response body."
    private val bodyData = "{\"foo1\": \"bar1\",\"foo2\": \"bar2\"}"

    @Dado("que eu tenha os dados para requisição {string}")
    fun queEuTenhaOsDadosParaRequisicao(requisicao: String) {
        when (requisicao) {
            "GET" -> endpoint = "$baseurl/get?foo1=bar1&foo2=bar2"
            "POST RAW" -> endpoint = "$baseurl/post"
            "POST DATA" -> endpoint = "$baseurl/post"
            "PUT" -> endpoint = "$baseurl/put"
            "PATCH" -> endpoint = "$baseurl/patch"
            "DELETE" -> endpoint = "$baseurl/delete"
        }
        System.setProperty("response", endpoint)
    }

    @Quando("eu realizar a requisição {string}")
    fun euRealizarARequisicao(requisicao: String) {
        when (requisicao) {
            "GET" -> {
                Rest().apply {
                    response = getRequest(endpoint)
                }
            }
            "POST RAW" -> {
                Rest().apply {
                    val header = mapOf(
                        "Content-Type" to "text/plain",
                        "Host" to baseurl.replace("https://", "")
                    )
                    response = postRequest(endpoint, bodyRaw, headers = header)
                }
            }
            "POST DATA" -> {
                Rest().apply {
                    response = postRequest(endpoint, bodyData)
                }
            }
            "PUT" -> {
                Rest().apply {
                    response = putReqest(endpoint, bodyRaw)
                }
            }
            "PATCH" -> {
                Rest().apply {
                    response = patchReqest(endpoint,bodyRaw)
                }
            }
            "DELETE" -> {
                Rest().apply {
                    response = deleteReqest(endpoint, bodyRaw)
                }
            }
        }
        System.setProperty("response", response)
    }

    @Então("deve retornar os campos do {string}")
    fun deveRetornarOsCamposDo(requisicao: String) {
        when (requisicao) {
            "GET" -> {
                val getResponse = Gson().fromJson(response, GetResponse::class.java)

                // Assert do Args response
                assertEquals("bar1", getResponse.args.foo1)
                assertEquals("bar2", getResponse.args.foo2)

                // Assert do Header Response
                assertEquals("https", getResponse.headers.xForwardedProto)
                assertEquals("443", getResponse.headers.xForwardedPort)
                assertEquals("postman-echo.com", getResponse.headers.host)
                assertTrue(getResponse.headers.xAmznTraceId.contains("Root="))
                assertEquals("*/*", getResponse.headers.accept)
                assertEquals("Apache-HttpClient/4.5.3 (Java/1.8.0_252)", getResponse.headers.userAgent)
                assertEquals("gzip,deflate", getResponse.headers.acceptEncoding)

                // Assert URL
                assertEquals(endpoint, getResponse.url)
            }
            "POST RAW" -> {
                Gson().fromJson(response, PostResponse::class.java).apply {
                    assertEquals(bodyRaw, this.data)

                    // Assert do Header Response
                    assertEquals("https", this.headers.xForwardedProto)
                    assertEquals("443", this.headers.xForwardedPort)
                    assertEquals("postman-echo.com", this.headers.host)
                    assertTrue(this.headers.xAmznTraceId.contains("Root="))
                    assertEquals(bodyRaw.length.toString(), this.headers.contentLength)
                    assertEquals("text/plain; charset=ISO-8859-1", this.headers.contentType)

                    // Assert URL
                    assertEquals(endpoint, this.url)
                }
            }
            "POST DATA" -> {
                Gson().fromJson(response, PostResponse::class.java).apply {
                    assertEquals(bodyData, this.data)

                    // Assert do Header Response
                    assertEquals("https", this.headers.xForwardedProto)
                    assertEquals("443", this.headers.xForwardedPort)
                    assertEquals("postman-echo.com", this.headers.host)
                    assertTrue(this.headers.xAmznTraceId.contains("Root="))
                    assertEquals(bodyData.length.toString(), this.headers.contentLength)
                    assertEquals("text/plain; charset=ISO-8859-1", this.headers.contentType)
                }
            }
            "PUT" -> {
                Gson().fromJson(response, PostResponse::class.java).apply {
                    assertEquals(bodyRaw, this.data)

                    // Assert do Header Response
                    assertEquals("https", this.headers.xForwardedProto)
                    assertEquals("443", this.headers.xForwardedPort)
                    assertEquals("postman-echo.com", this.headers.host)
                    assertTrue(this.headers.xAmznTraceId.contains("Root="))
                    assertEquals(bodyRaw.length.toString(), this.headers.contentLength)
                    assertEquals("text/plain; charset=ISO-8859-1", this.headers.contentType)

                    // Assert URL
                    assertEquals(endpoint, this.url)
                }
            }
            "PATCH" -> {
                Gson().fromJson(response, PostResponse::class.java).apply {
                    assertEquals(bodyRaw, this.data)

                    // Assert do Header Response
                    assertEquals("https", this.headers.xForwardedProto)
                    assertEquals("443", this.headers.xForwardedPort)
                    assertEquals("postman-echo.com", this.headers.host)
                    assertTrue(this.headers.xAmznTraceId.contains("Root="))
                    assertEquals(bodyRaw.length.toString(), this.headers.contentLength)
                    assertEquals("text/plain; charset=ISO-8859-1", this.headers.contentType)

                    // Assert URL
                    assertEquals(endpoint, this.url)
                }
            }
            "DELETE" -> {
                Gson().fromJson(response, PostResponse::class.java).apply {
                    assertEquals(bodyRaw, this.data)

                    // Assert do Header Response
                    assertEquals("https", this.headers.xForwardedProto)
                    assertEquals("443", this.headers.xForwardedPort)
                    assertEquals("postman-echo.com", this.headers.host)
                    assertTrue(this.headers.xAmznTraceId.contains("Root="))
                    assertEquals(bodyRaw.length.toString(), this.headers.contentLength)
                    assertEquals("text/plain; charset=ISO-8859-1", this.headers.contentType)

                    // Assert URL
                    assertEquals(endpoint, this.url)
                }
            }
        }
        System.setProperty("response", "TESTE OK!")
    }

}