# language: pt
# encoding: utf-8
  @httpUrlConnect @all
  Funcionalidade: Realizar requisições e testes com o HttpUrlConnection

    @suite
    Esquema do Cenário: Cenário: Realizar requisição de cep
      Dado que eu tenha o cep "<cep>"
      Quando eu realizar a requisição http
      Então deve retornar o campo "<campo>" igual a "<resultado>"

      Exemplos:
        |   cep   | campo       |   resultado   |
        |01001000 | cep         |   01001-000   |
        |01001000 | logradouro  |   Praça da Sé |
        |01001000 | complemento |   lado ímpar  |
        |01001000 | bairro      |   Sé          |
        |01001000 | localidade  |   São Paulo   |
        |01001000 | uf          |   SP          |
        |01001000 | unidade     |               |
        |01001000 | ibge        |   3550308     |
        |01001000 | gia         |   1004        |

      ## Caso queira rodar apenas um teste utilizar as tags abaixo

    @cep
    Cenário: Validar CEP
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "cep" igual a "01001-000"

    @logradouro
    Cenário: Validar Logradouro
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "logradouro" igual a "Praça da Sé"

    @complemento
    Cenário: Validar Complemento
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "logradouro" igual a "Praça da Sé"

    @bairro
    Cenário: Validar Bairro
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "bairro" igual a "Sé"

    @localidade
    Cenário: Validar Localidade
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "localidade" igual a "São Paulo"

    @uf
    Cenário: Validar UF
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "uf" igual a "SP"

    @unidade
    Cenário: Validar UF
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "unidade" igual a ""

    @ibge
    Cenário: Validar UF
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "ibge" igual a "3550308"

    @gia
    Cenário: Validar UF
      Dado que eu tenha o cep "01001000"
      Quando eu realizar a requisição http
      Então deve retornar o campo "gia" igual a "1004"