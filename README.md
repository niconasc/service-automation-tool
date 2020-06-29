# Automação de teste de serviço
Este projeto tem como objetivo automatizar e validar requisições **Rest**


## Tecnologias utilizadas

* [Java 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) - Java Development Kit
* [Cucumber](https://cucumber.io/) - BDD
* [JUnit](https://junit.org/junit5) - Framework Test para Java

## Configurando o ambiente
* Faça o download do JDK/JRE  1.8 [clicando aqui](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* Configure a variável de ambiente  [JAVA_HOME](https://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188)


## Entendendo a arquitetura do framework

**Onde executo os testes ?! :**
 
 * Na classe Runner.

Path da classe:

> ..src/test/java/runner/Runner.kt

## Como executo os testes ? 

Inserir na classe `Runner` na opção `tags = [` do Cucumber options a tag com a "@" do CT ou da suíte desejada antes de executá-lo.
 Exemplo:


|           **@restAssured**              |
|:---:                                    |
|  Testes automatizados da feature        | 

Também é possível executar os testes via linha de comando conforme abaixo:

| Exemplo: |
| :---:   |
| ./gradlew test -Dcucumber.options="--tags @tag_desejada" |


Package com as `.feature` para consulta das tags:
> ..src/main/resources/features/*.feature

Package com os `Steps` :
> ../src/main/java/stepDefinition/*.kt

## REPORT

O framework possui um `report` gerado em HTML exibindo todo resumo e detalhe da execução:

Package com o `report` :
>../src/main/report/*.html>

Neste report é possível ver o resumo da execução na aba `OVERVIEW` onde há gráficos informando o resultado dos testes a nível de feature e de cenário.

Para visualização mais detalhada acessar a aba `FEATURES` onde haverá tabelado as funcionalidades e seu resultado. Clicando em uma funcionalida e em um cenário é possível ver a execução de cada step com o print de seu resultado.

Também é possíver ver a execução de uma forma geral na aba `SUMMARY` onde listará todas as execuções e seus status. Clicando em uma linha da coluna `Scenario` é possível ver os steps da execução e seus prints.

Veja um exemplo do report gerado [clicando aqui.](https://reportbuilderjava.rajatthareja.com/sample/report.html)

Para mais detalhes veja a documentação oficial [clicando aqui.](https://reportbuilderjava.rajatthareja.com/)

## Autor

* **Nicolai Peixoto**
