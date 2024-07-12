<h1 align="center">
  Place Service
</h1>

API para gerenciar lugares (CRUD) que faz parte [desse desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para pessoas desenvolvedoras backend que se candidatam para a ClickBus.

## Tecnologias

- Spring Boot
- Spring Webflux
- Spring Data + R2DBC
- SpringDoc OpenAPI 3
- Slugify

## Práticas adotadas

- SOLID
- Testes automatizados
- API reativa na web e na camada de banco
- Uso de DTOs para a API
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI 3
- Geração de slugs automática com o Slugify

## Como Executar

### Localmente
1 - Clonar repositório git

```
  https://github.com/gVieiraX/place-service
```

2- Instale as dependências com Maven


## API Endpoints

A API poderá ser acessada em [localhost:8080](http://localhost:8080/places). O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Os campos id,createdAt e updatedAt são gerados de forma automática. 

Para fazer as requisições HTTP abaixo, foi utilizado o Postman:

- POST /places - Registar um novo lugar
```
{
    "name": "Place",
    "slug": "place",
    "city": "City",
    "state": "State",
}
```

- GET /places - Mostra todos os lugares

```
{  
    "id":1,
    "name": "Place",
    "slug": "place",
    "city": "City",
    "state": "State",
    "createdAt": "2023-04-20T19:00:07.241632",
    "updatedAt": "2023-04-20T19:00:07.241632"
}
```



- PUT /places - Atualiza algum lugar

```
{
    "id":1,
    "name": "Place UP",
    "slug": "place UP",
    "city": "City UP",
    "state": "State UP",
    "createdAt": "2023-04-20T19:00:07.241632",
    "updatedAt": "2024-07-12T00:10:30.14851"
}
```

- DELETE /places/{id} - Deleta algum lugar
```
{
   Lugar Deletado com sucesso
                OU
   Não foi possível deletar o lugar, o ID não foi encontrado      
}
```

