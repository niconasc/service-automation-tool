package core

import io.restassured.RestAssured.get
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.http.Headers

class Rest {

    fun getRequest(endpoint: String, status: Int = 200): String {
            return get(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
    }

    fun postRequest(endpoint: String, body: String, status: Int = 200, headers: Map<String, String>? = null): String {
        if (headers != null) {
            return given()
                .headers(headers)
                .body(body)
                .`when`()
                .post(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        } else {
            return given()
                .body(body)
                .`when`()
                .post(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        }
    }

    fun putReqest(endpoint: String, body: String, status: Int = 200, headers: Map<String, String>? = null) : String{
        if (headers != null){
            return given()
                .headers(headers)
                .body(body)
                .`when`()
                .put(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        } else {
            return given()
                .body(body)
                .`when`()
                .put(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        }
    }

    fun patchReqest(endpoint: String, body: String, status: Int = 200, headers: Map<String, String>? = null) : String{
        if (headers != null){
            return given()
                .headers(headers)
                .body(body)
                .`when`()
                .patch(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        } else {
            return given()
                .body(body)
                .`when`()
                .patch(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        }
    }

    fun deleteReqest(endpoint: String, body: String, status: Int = 200, headers: Map<String, String>? = null) : String{
        if (headers != null){
            return given()
                .headers(headers)
                .body(body)
                .`when`()
                .delete(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        } else {
            return given()
                .body(body)
                .`when`()
                .delete(endpoint)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .asString()
        }
    }
}
