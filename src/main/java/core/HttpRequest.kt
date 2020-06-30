package core

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpRequest {

    fun requestService(method: String, endpoint: String, header: Map<String, String>? = null, body: String? = null): String {
        var con = URL(endpoint).openConnection() as HttpURLConnection
        when(method){
            "GET" -> con.apply {
                requestMethod = "GET"

                if (header != null) {
                    for (hdr in header) {
                        setRequestProperty(hdr.key, hdr.value)
                    }
                }
            }
            else ->         con.apply {
                requestMethod = method.toUpperCase()
                doOutput = true

                if (header != null) {
                    for (hdr in header) {
                        setRequestProperty(hdr.key, hdr.value)
                    }
                }

                val input = body!!.toByteArray()
                outputStream.write(input, 0, input.size)
                outputStream.flush()
                outputStream.close()
            }
        }

        if (con.responseCode > 299) {
            throw Error("Não foi possível realizar a requisição\nRetorno apresenta erro: ${con.errorStream}")
        } else {
            return processRequestReturn(con.inputStream)
        }
    }

    fun processRequestReturn(inputStream: InputStream): String {
        var response = ""
        BufferedReader(InputStreamReader(inputStream)).also {
            var linha = it.readLine()
            while (linha != null) {
                response += linha
                linha = it.readLine()
            }
            return response
        }
    }
}