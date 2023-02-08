# ManangementPerson

## API REST para Gerenciar Pessoas
Projeto utilizando Spring Boot para cadastrar Pessoas e Endereços vinculados a elas.

## Esta API permite:
* Criar uma pessoa  
* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar endereços para pessoa
* Listar endereços da pessoa
* Poder informar qual endereço é o principal da pessoa

## Pré Requisitos 
* Java 17
* IDE (Intellij ou Eclipse)
* Banco h2

## Executando o projeto
* Rode a aplicação e acesse o banco H2 com as seguintes configurações 
* URL - localhost:8080/h2
* JDBC URL - jdbc:h2:mem:testdb
* Username - sa
* Password - 123

## Iniciando a aplicação
* Executar a classe PersonApplication

## Inclusão de pessoa

POST - http://localhost:8080/person

```
{
    "personName": "Eduardo",
    "bornDate": "1990-01-01"
}
```
## Inclusão de endereço 

POST - http://localhost:8080/address
```
{
    "street": "Rua Teste",
    "zipCode": "89200200",
    "numberAddress": 123,
    "city": "Joinville",
    "stateAddress": "SC",
    "principal": false,
    "personId": 1
}
```
## Atualização de pessoa 

PUT - http://localhost:8080/person/1
```
{
    "personName": "Eduardo2"
}
```
## Atualização de endereço (necessário sempre informar se é principal ou não)

PUT - http://localhost:8080/address/1
```
{
    "street": "nova rua",
    "principal" : false
}
```
## Busca de pessoa por id 

http://localhost:8080/person/1

## Lista de todas as pessoas 
http://localhost:8080/person

## Busca de endereço por id 

http://localhost:8080/address/1

## Lista de todas os endereços 

http://localhost:8080/address

## Listar endereço a partir da pessoa 

http://localhost:8080/address/person/1

## Exclusão de pessoa (não deixa deletar se estiver vinculado a um address)

DELETE - http://localhost:8080/person/1

## Exclusão de endereço 

DELETE - http://localhost:8080/address/1

## Próximas implementações:

* Implementar autenticação;

* Novos testes unitários e de integração;

* Subir a aplicação num docker;

* Disponibilizar na nuvem;

* Criar processo de build e deploy para versionamento da aplicação;

* Implementar novas regras de negócio, como: 
regra para não permitir dois endereços principais para a mesma pessoa. Colocar regras em alguns campos para não permitir inserção de informação nula. Nome da pessoa por exemplo.
