# 📚 API Biblioteca

Uma API REST desenvolvida com Java + Spring Boot para gerenciamento de livros e autores.

O projeto foi criado com foco em boas práticas de desenvolvimento backend, utilizando arquitetura em camadas, DTOs, validações e documentação automática com Swagger/OpenAPI.

---

# 👨‍💻 Equipe

## Desenvolvedores

* Caique
* Simone
* Matheus
* Rayla
* Patrick

---

# 🚀 Tecnologias Utilizadas

* ☕ Java 17
* 🌱 Spring Boot 3.5.0
* 🗄️ Spring Data JPA
* ✅ Bean Validation
* 🐘 PostgreSQL
* 📖 Swagger / OpenAPI (springdoc-openapi 2.8.8)
* 🧪 JUnit
* 📦 Maven

---

# 📁 Estrutura do Projeto

```bash
biblioteca
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ java
 ┃ ┃ ┃ ┗ br/com/escola/biblioteca
 ┃ ┃ ┃    ┣ config
 ┃ ┃ ┃    ┃  ┣ DatabaseInitializer.java   ← cria o banco automaticamente na inicialização
 ┃ ┃ ┃    ┃  ┗ SwaggerConfig.java         ← configuração do OpenAPI/Swagger
 ┃ ┃ ┃    ┣ controller
 ┃ ┃ ┃    ┃  ┣ AutorController.java
 ┃ ┃ ┃    ┃  ┗ LivroController.java
 ┃ ┃ ┃    ┣ dto
 ┃ ┃ ┃    ┃  ┣ AutorRequestDTO.java
 ┃ ┃ ┃    ┃  ┣ AutorResponseDTO.java
 ┃ ┃ ┃    ┃  ┣ LivroRequestDTO.java
 ┃ ┃ ┃    ┃  ┗ LivroResponseDTO.java
 ┃ ┃ ┃    ┣ entity
 ┃ ┃ ┃    ┃  ┣ Autor.java
 ┃ ┃ ┃    ┃  ┗ Livro.java
 ┃ ┃ ┃    ┣ exception
 ┃ ┃ ┃    ┃  ┗ GlobalExceptionHandler.java
 ┃ ┃ ┃    ┣ repository
 ┃ ┃ ┃    ┃  ┣ AutorRepository.java
 ┃ ┃ ┃    ┃  ┗ LivroRepository.java
 ┃ ┃ ┃    ┣ service
 ┃ ┃ ┃    ┃  ┣ AutorService.java
 ┃ ┃ ┃    ┃  ┗ LivroService.java
 ┃ ┃ ┃    ┗ BibliotecaApplication.java    ← classe principal
 ┃ ┃ ┗ resources
 ┃ ┃    ┣ Biblioteca.sql                  ← script de criação das tabelas
 ┃ ┃    ┗ application.properties
 ┃ ┗ test
 ┃    ┗ java/br/com/escola/biblioteca
 ┃       ┗ BibliotecaApplicationTests.java
 ┣ logs
 ┃ ┗ biblioteca.log
 ┗ pom.xml
```

---

# ⚙️ Funcionalidades

## 👨‍💼 Autores

* ✅ Cadastrar autor
* ✅ Cadastrar vários autores de uma vez (lote)
* ✅ Listar autores
* ✅ Buscar autor por ID
* ✅ Atualizar autor
* ✅ Remover autor

## 📚 Livros

* ✅ Cadastrar livro
* ✅ Cadastrar vários livros de uma vez (lote)
* ✅ Listar livros
* ✅ Buscar livro por ID
* ✅ Atualizar livro
* ✅ Excluir livro

---

# 🌐 Endpoints

## 👨‍💼 Autores — `/autores`

| Método | Rota           | Descrição                        |
|--------|----------------|----------------------------------|
| GET    | `/autores`     | Lista todos os autores           |
| GET    | `/autores/{id}`| Busca autor por ID               |
| POST   | `/autores`     | Cadastra um novo autor           |
| POST   | `/autores/lote`| Cadastra vários autores de uma vez|
| PUT    | `/autores/{id}`| Atualiza os dados de um autor    |
| DELETE | `/autores/{id}`| Remove um autor                  |

## 📚 Livros — `/livros`

| Método | Rota           | Descrição                        |
|--------|----------------|----------------------------------|
| GET    | `/livros`      | Lista todos os livros            |
| GET    | `/livros/{id}` | Busca livro por ID               |
| POST   | `/livros`      | Cadastra um novo livro           |
| POST   | `/livros/lote` | Cadastra vários livros de uma vez|
| PUT    | `/livros/{id}` | Atualiza os dados de um livro    |
| DELETE | `/livros/{id}` | Remove um livro                  |

---

# 📖 Exemplos de Requisição

## Criar Autor

```http
POST /autores
Content-Type: application/json
```

```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileiro",
  "dataNascimento": "1839-06-21"
}
```

## Criar Livro

```http
POST /livros
Content-Type: application/json
```

```json
{
  "titulo": "Dom Casmurro",
  "isbn": "9788535910657",
  "anoPublicacao": 1899,
  "genero": "Romance",
  "autorId": 1
}
```

## Cadastro em Lote — Autores

```http
POST /autores/lote
Content-Type: application/json
```

```json
[
  {
    "nome": "Clarice Lispector",
    "nacionalidade": "Brasileira",
    "dataNascimento": "1920-12-10"
  },
  {
    "nome": "Guimarães Rosa",
    "nacionalidade": "Brasileiro",
    "dataNascimento": "1908-06-27"
  }
]
```

---

# 🧱 Arquitetura Utilizada

O projeto segue uma arquitetura em camadas (Layered Architecture):

```
[ Cliente / Swagger ]
        ↓
  [ Controller ]      ← recebe as requisições HTTP, delega ao Service
        ↓
   [ Service ]        ← regras de negócio, conversão DTO ↔ Entity
        ↓
  [ Repository ]      ← acesso ao banco via Spring Data JPA
        ↓
  [ PostgreSQL ]
```

### Detalhamento de cada camada

| Camada | Classes | Responsabilidade |
|---|---|---|
| **Controller** | `AutorController`, `LivroController` | Expõe os endpoints REST, valida entrada com `@Valid`, devolve `ResponseEntity` |
| **Service** | `AutorService`, `LivroService` | Regras de negócio, busca de autor ao criar livro, conversão entre DTO e Entity |
| **Repository** | `AutorRepository`, `LivroRepository` | Interfaces `JpaRepository` — CRUD gerado automaticamente pelo Spring Data |
| **Entity** | `Autor`, `Livro` | Mapeamento JPA das tabelas; relacionamento `@OneToMany` / `@ManyToOne` entre Autor e Livro |
| **DTO** | `AutorRequestDTO`, `AutorResponseDTO`, `LivroRequestDTO`, `LivroResponseDTO` | Records Java para entrada e saída de dados; `ResponseDTO` contém método estático `fromEntity()` |
| **Exception** | `GlobalExceptionHandler` | Captura exceções globalmente via `@RestControllerAdvice`; retorna respostas padronizadas com `timestamp`, `status`, `erro` e `mensagem` |
| **Config** | `SwaggerConfig`, `DatabaseInitializer` | `SwaggerConfig` configura o OpenAPI com servidores e metadados; `DatabaseInitializer` verifica e cria o banco `biblioteca` automaticamente ao subir a aplicação |

---

# ▶️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/matheussilveirasantos/API-Livraria.git
```

---

## 2️⃣ Entrar na pasta do projeto

```bash
cd API-Livraria/biblioteca
```

---

## 3️⃣ Configurar o PostgreSQL

Crie um banco chamado:

```sql
CREATE DATABASE biblioteca;
```

---

## 4️⃣ Configurar o application.properties

Ajuste as credenciais do banco no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=SUA-SENHA
```
---

## 5️⃣ Executar a aplicação

Pelo terminal:

```bash
./mvnw spring-boot:run
```

Ou diretamente pela classe principal:

```
BibliotecaApplication.java
```

---

# 🌐 Acesso da API

## Servidores disponíveis

| Ambiente | URL |
|---|---|
| 🛠️ Desenvolvimento | `http://localhost:8080` |
| 🚀 Produção | `https://api.biblioteca.com.br` |

## Documentação interativa

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

API Docs (OpenAPI 3.1.0 — JSON):

```
http://localhost:8080/api-docs
```

---

# 🧪 Testando com Postman

O arquivo `data-202652314436.json` na raiz do repositório contém a especificação completa da API no formato **OpenAPI 3.1.0**. Basta importá-lo no Postman para ter todas as rotas, schemas e exemplos prontos para teste.

## Como importar

**1.** Abra o Postman e clique em **Import**

**2.** Selecione o arquivo `data-202652314436.json` da raiz do projeto

**3.** O Postman vai gerar automaticamente todas as requisições:

| Recurso | Rotas importadas |
|---|---|
| 📚 Livros | `GET /livros`, `GET /livros/{id}`, `POST /livros`, `POST /livros/lote`, `PUT /livros/{id}`, `DELETE /livros/{id}` |
| 👨‍💼 Autores | `GET /autores`, `GET /autores/{id}`, `POST /autores`, `POST /autores/lote`, `PUT /autores/{id}`, `DELETE /autores/{id}` |

**4.** Certifique-se de que a aplicação está rodando em `http://localhost:8080` antes de disparar as requisições

---

# 🔬 Testes Unitários

Para executar os testes automatizados:

```bash
./mvnw test
```

---

# 📌 Padrões Utilizados

* REST API
* DTO Pattern (Records Java)
* Bean Validation
* Layered Architecture
* Tratamento global de exceções (`GlobalExceptionHandler`)
* Documentação automática com Swagger/OpenAPI

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com fins educacionais para prática de:

* Desenvolvimento de APIs REST
* Spring Boot
* Banco de dados relacional
* Boas práticas backend
* Trabalho em equipe utilizando Git e GitHub

---

# 📄 Licença

Projeto desenvolvido para estudos e aprendizado. Distribuído sob a [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).