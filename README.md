# cardapio-fullstack

#### O projeto Cardápio full stack é uma simples aplicação desenvolvida em Angular para o front-end e em Spring Boot para o Back-end na qual se pode gerenciar os produtos de uma lanchonete. 

---
###  Instalando Dependências

Após extrair o .zip do projeto e acessar a pasta do repositório, haverão duas pastas
````
  Back
  Front
````

#### Configurando banco de dados instalando as dependências e inicializando o Back-end.

Esta aplicação foi desenvolvida para funcionar com o banco de dados PostgreSQL, sendo necessária a sua criação préviamente. 
Para ligar a aplicação ao banco de dados basta ir para o arquivo Application.roperties localizado no seguinte diretório
````
Back/api-cardapio/src/main/resources/application-properties 
````
Neste arquivo, deve-se configurar as seguintes variáveis
````
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco_de_dados
spring.datasource.username= usuario_postgres
spring.datasource.password= senha_do_usuario_postgres
````
Após isto, através do terminal vá até o diretório 
````
Back/api-cardapio/ 
````
E em seguida execute o seguinte comando:
````
 mvn spring-boot:run
````
Após isto, a app irá iniciar. Ela está configurada para criar alguns produtos caso o banco de dados esteja vazio para fins de demostração.

Também é possível iniciar o projeto pela sua IDE de preferência.

#### Instalando as dependências e inicializando o Front-end.
Através do terminal, vá para o diretório
````
Front/Cardapio/
````
Após isto, instale as dependências através do npm
````
npm install
````
Com as dependências instaladas, basta rodar o seguinte comando
````
npm run start
````
Uma aba será aberta no seu navegador padrão na página do Front-end do cardápio online.

---

  ## **Características do produto**


| Campo      | Tipo   | Descrição                                       |
| -----------|--------|-------------------------------------------------|
| id         | long/number | Identificador único do produto             |
| nome       | string | O nome do produto.                              |
| categoria  | string | Categoria do produto                            |
| valor      | number | O preço do produto                              |
| descricao  | string | Descrição do produto                            |


---

### Endpoints

| Método   | Rota                   | Descrição                                       |
|----------|------------------------|-------------------------------------------------|
| POST     | /produto               | Criação de um produto.                          |
| GET      | /produto               | Lista todos os produtos.                        |
| PATCH    | /produto/:produto_id   | Atualiza um produto usando seu ID como parâmetro|
| DELETE   | /produto/:produto_id   | Deleta o produto usando seu ID como parâmetro   |

---


### 1 **Criação de Produto**

### `/produto`

### Exemplo de Request:
```
POST /produto
Host: localhost:8080
Authorization: None
Content-type: application/json
```

### Corpo da Requisição:
```json
{
	"nome": "Empada de frango",
	"valor": 1,
	"categoria": "salgados",
	"descricao": "Empada de frango"
}
```

### Validação:
```
	nome: string,
	valor: number,
	categoria: string,
	descricao: string | null
```
OBS.: Chaves não presentes no schema serão removidas.

### Exemplo de Response:
```
201 Created
```

```json
{
	"id": 8,
	"nome": "Empada de frango",
	"valor": 1.0,
	"categoria": "salgados",
	"descricao": "Empada de frango"
}
```

### Possíveis Erros:
| Código do Erro |                 Descrição                   |
|----------------|---------------------------------------------|
| 409 CONFLICT   | "message": "Nome de produto já está em uso" |

---

### 2 **Listando Produtos**

### `/produto`

### Exemplo de Request:
```
GET /produto
Host: localhost:8080
Authorization: None
Content-type: application/json
```

### Corpo da Requisição:
```json
Vazio
```

### Exemplo de Response:
```
200 OK
```
```json
[
	{
		"id": 1,
		"nome": "Risole Misto",
		"valor": 4.5,
		"categoria": "salgados",
		"descricao": null
	},
	{
		"id": 2,
		"nome": "Torta de frango",
		"valor": 8.0,
		"categoria": "tortas",
		"descricao": "Fatia de torta de frango"
	}
]

```

### Possíveis Erros:
Nenhum, o máximo que pode acontecer é a lista estar vazia.

---
### 3 **Atualização de Produto**

### `/user/:id_do_produto`

### Exemplo de Request:
```
PATCH /produto/1
Host: localhost:8080
Authorization: None
Content-type: application/json
```

### Corpo da Requisição:
```json
{
	"nome": "30 und. mini salgados",
	"valor": 10.0,
	"categoria": "salgadinhos",
	"descricao": "Vários salgados"
}
```

### Validação:
```
	nome: string,
	categoria: string,
	valor: number,
	descricao: string | null

```
OBS.: Chaves não presentes no schema serão removidas.


### Exemplo de Response:
```
200 OK
```

```json
{
	"id": 3,
	"nome": "30 und. mini salgados",
	"valor": 10.0,
	"categoria": "salgadinhos",
	"descricao": "Vários salgados"
}
```

### Possíveis Erros:
| Código do Erro |                 Descrição                     |
|----------------|-----------------------------------------------|
| 404 NOT FOUND  | "message": "Produto não foi encontrado"       |
| 400 BAD REQUEST| "message": "Nome de produto já está em uso"   |

---

### 4 **Deletando Um produto**

### `/user/:id_do_produto`

### Exemplo de Request:
```
GET /user/1
Host: localhost:8080
Authorization: None
Content-type: application/json
```

### Corpo da Requisição:
```json
Vazio
```

### Exemplo de Response:
```
204 NO CONTENT
```
```json
NO BODY
```

### Possíveis Erros:
| Código do Erro |              Descrição              |
|----------------|-------------------------------------|
| 404 NOT FOUND  | "message": "Produto não encontrado" |

---
