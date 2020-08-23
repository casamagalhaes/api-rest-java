# API RESTFUL em Java + SpringBoot + Docker

>O projeto se propõe a desenvolvover uma API RESTFul em JAVA versão 8, que seja capaz de realizar as funcionalidades de CRUD(create, read, update, delete) para as entidades Loja e Produto, com persistência de dados em um banco de dados MySQL .

###### Requistos executar o projeto: 

  - Java SE Development Kit 8
  - [Docker](https://docs.docker.com/get-docker/)

###### Repositório da interface consumindo a API
- [Front-end em Vue.js](https://github.com/sidnobre/frontend-vue)
***
## Como executar o projeto

- Certifique-se que a porta 8080 está livre
- Abra o terminal na pasta do projeto
    ```sh
    $ cd /api-java
    ```
- Execute o comando do Docker-Compose:
     ```sh
    $ docker-compose up --build --force-recreate
    ```

***    
## Consumindo a API

* ### Loja
    * ##### Listar todas lojas
        * URL: http://localhost:8080/loja
        * Método `GET`
        * Resposta Sucesso:
            * Code 200 OK
            * Conteúdo:
                ```
                [
                    {
                        "id": 1,
                        "nome": "Locadora Vermelha",
                        "endereco": "Rua Host Ricco",
                        "cidade": "Quixada",
                        "estado": "Ceara"
                    }
                ]
                ```
    * ##### Cadastrar nova loja
        * URL: http://localhost:8080/loja
            * Método `POST`
            * Paramentros de corpo Dados:
                * JSON
                    ```
                    {
                        "nome": "",
                        "endereco": "",
                        "cidade": "",
                        "estado": ""
                    }
                    ```
            * Resposta Sucesso:
                * Code 201 CREATE
    
    * ##### Atualizar loja por id
        * URL: http://localhost:8080/loja/{id}
            * Método `PUT`
            * Dados Requiridos:
                * id = [integer]
            * Paramentros de corpo Dados:
                * JSON
                    ```
                    {
                        "nome": "",
                        "endereco": "",
                        "cidade": "",
                        "estado": ""
                    }
                    ```
            * Resposta Sucesso:
                * Code 200 OK
                
    * #### Excluir loja por id
        * URL: http://localhost:8080/loja/{id}
            * Método `DELETE`
            * Dados Requiridos:
                * id = [integer]
            * Resposta Sucesso:
                * Code 204 NO CONTENT
* ### Produto
    * ##### Listar todos produtos
        * URL: http://localhost:8080/produto
        * Método `GET`
        * Resposta Sucesso:
            * Code 200 OK
            * Conteúdo:
                ```
                [
                    {
                        "id": 1,
                        "nome": "Monitor Dell 19pol",
                        "descricao": "exemplo",
                        "preco": 700.0
                    }
                ]
                ```
    * ##### Cadastrar novo produto
        * URL: http://localhost:8080/produto
            * Método `POST`
            * Paramentros de corpo Dados:
                * JSON
                    ```
                   {
                        "nome": "",
                        "descricao": "",
                        "preco": 0.0
                    }
                    ```
            * Resposta Sucesso:
                * Code 201 CREATE
    
    * ##### Atualizar produto por id
        * URL: http://localhost:8080/produto/{id}
            * Método `PUT`
            * Dados Requiridos:
                * id = [integer]
            * Paramentros de corpo Dados:
                * JSON
                    ```
                    {
                        "nome": "",
                        "descricao": "",
                        "preco": 0.0
                    }
                    ```
            * Resposta Sucesso:
                * Code 200 OK
                
    * #### Excluir produto por id
        * URL: http://localhost:8080/produto/{id}
            * Método `DELETE`
            * Dados Requiridos:
                * id = [integer]
            * Resposta Sucesso:
                * Code 204 NO CONTENT
