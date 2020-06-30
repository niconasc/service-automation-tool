package stepDefinition

import core.HttpRequest
import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Então
import io.cucumber.java.pt.Quando
import io.restassured.path.json.JsonPath
import model.get.GetResponse
import model.post.PostResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue


class HttpUrlConnectionStepDefinicion {
    private lateinit var endpoint: String
    private var response = ""

    @Dado("que eu tenha o cep {string}")
    fun queEuTenhaOCep(cep: String) {
        endpoint = "https://viacep.com.br/ws/$cep/json/"
    }

    @Quando("eu realizar a requisição http")
    fun euRealizarARequisicaoHttp() {
        HttpRequest().apply {
            response = requestService("GET", endpoint)
        }
    }

    @Então("deve retornar o campo {string} igual a {string}")
    fun deveRetornarOCampo(campo: String, resultado: String) {
        val jsonResponse = JsonPath.from(response)
        when (campo) {
            "cep" -> assertEquals(resultado, jsonResponse.get(campo))
            "logradouro" -> assertEquals(resultado, jsonResponse.get(campo))
            "complemento" -> assertEquals(resultado, jsonResponse.get(campo))
            "bairro" -> assertEquals(resultado, jsonResponse.get(campo))
            "localidade" -> assertEquals(resultado, jsonResponse.get(campo))
            "uf" -> assertEquals(resultado, jsonResponse.get(campo))
            "unidade" -> assertEquals(resultado, jsonResponse.get(campo))
            "ibge" -> assertEquals(resultado, jsonResponse.get(campo))
            "gia" -> assertEquals(resultado, jsonResponse.get(campo))
        }

    }
}