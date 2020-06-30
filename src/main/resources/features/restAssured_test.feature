# language: pt
# encoding: utf-8
  @restAssured @all
  Funcionalidade: Realizar requisições e testes com o Rest Assured

    @suite
    Esquema do Cenário: Cenário: Realizar requisição <request>
      Dado que eu tenha os dados para requisição "<request>"
      Quando eu realizar a requisição "<request>"
      Então deve retornar os campos do "<request>"

      Exemplos:
      | request   |
      | GET       |
      | POST RAW  |
      | POST DATA |
      | PATCH     |
      | PUT       |
      | DELETE    |

      ## Caso queira rodar apenas um teste utilizar as tags abaixo

    @get
    Cenário: Cenário: Realizar requisição GET
      Dado que eu tenha os dados para requisição "GET"
      Quando eu realizar a requisição "GET"
      Então deve retornar os campos do "GET"

    @post_raw
    Cenário: Cenário: Realizar requisição POST RAW
      Dado que eu tenha os dados para requisição "POST RAW"
      Quando eu realizar a requisição "POST RAW"
      Então deve retornar os campos do "POST RAW"

    @post_data
    Cenário: Cenário: Realizar requisição POST DATA
      Dado que eu tenha os dados para requisição "POST DATA"
      Quando eu realizar a requisição "POST DATA"
      Então deve retornar os campos do "POST DATA"

    @patch
    Cenário: Cenário: Realizar requisição PATCH
      Dado que eu tenha os dados para requisição "PATCH"
      Quando eu realizar a requisição "PATCH"
      Então deve retornar os campos do "PATCH"

    @put
    Cenário: Cenário: Realizar requisição PUT
      Dado que eu tenha os dados para requisição "PUT"
      Quando eu realizar a requisição "PUT"
      Então deve retornar os campos do "PUT"

    @delete
    Cenário: Cenário: Realizar requisição DELETE
      Dado que eu tenha os dados para requisição "DELETE"
      Quando eu realizar a requisição "DELETE"
      Então deve retornar os campos do "DELETE"