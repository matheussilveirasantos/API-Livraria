# 📚 API Biblioteca

Uma API REST desenvolvida com Java + Spring Boot para gerenciamento de livros, autores, editoras e gêneros literários.

O projeto foi criado com foco em boas práticas de desenvolvimento backend, utilizando arquitetura em camadas, DTOs, validações, autenticação JWT e documentação automática com Swagger/OpenAPI.

---

# 👨‍💻 Equipe

* Caique
* Simone
* Matheus
* Rayla
* Patrick

---

# 🚀 Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| ☕ Java | 17 |
| 🌱 Spring Boot | 3.5.0 |
| 🗄️ Spring Data JPA | — |
| ✅ Bean Validation | — |
| 🐘 PostgreSQL | — |
| 🔐 Spring Security + JWT (jjwt) | 0.12.6 |
| 📧 Spring Mail | — |
| 📖 Swagger / OpenAPI (springdoc-openapi) | 2.8.8 |
| 📦 Maven | — |

---

# 📁 Estrutura do Projeto

```bash
biblioteca
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ java
 ┃ ┃ ┃ ┗ br/com/escola/biblioteca
 ┃ ┃ ┃    ┣ config
 ┃ ┃ ┃    ┃  ┣ PasswordEncoderConfig.java
 ┃ ┃ ┃    ┃  ┣ SecurityConfig.java
 ┃ ┃ ┃    ┃  ┗ SwaggerConfig.java
 ┃ ┃ ┃    ┣ controller
 ┃ ┃ ┃    ┃  ┣ AuthController.java
 ┃ ┃ ┃    ┃  ┣ AutorController.java
 ┃ ┃ ┃    ┃  ┣ EditoraController.java
 ┃ ┃ ┃    ┃  ┣ GeneroController.java
 ┃ ┃ ┃    ┃  ┗ LivroController.java
 ┃ ┃ ┃    ┣ dto
 ┃ ┃ ┃    ┃  ┣ AutorRequestDTO.java
 ┃ ┃ ┃    ┃  ┣ AutorResponseDTO.java
 ┃ ┃ ┃    ┃  ┣ EditoraRequestDTO.java
 ┃ ┃ ┃    ┃  ┣ EditoraResponseDTO.java
 ┃ ┃ ┃    ┃  ┣ GeneroRequestDTO.java
 ┃ ┃ ┃    ┃  ┣ GeneroResponseDTO.java
 ┃ ┃ ┃    ┃  ┣ LoginRequestDTO.java
 ┃ ┃ ┃    ┃  ┣ LoginResponseDTO.java
 ┃ ┃ ┃    ┃  ┣ LivroRequestDTO.java
 ┃ ┃ ┃    ┃  ┗ LivroResponseDTO.java
 ┃ ┃ ┃    ┣ entity
 ┃ ┃ ┃    ┃  ┣ Autor.java
 ┃ ┃ ┃    ┃  ┣ Editora.java
 ┃ ┃ ┃    ┃  ┣ Genero.java
 ┃ ┃ ┃    ┃  ┣ Livro.java
 ┃ ┃ ┃    ┃  ┗ Usuario.java
 ┃ ┃ ┃    ┣ exception
 ┃ ┃ ┃    ┃  ┣ BusinessException.java
 ┃ ┃ ┃    ┃  ┣ GlobalExceptionHandler.java
 ┃ ┃ ┃    ┃  ┗ Validador.java
 ┃ ┃ ┃    ┣ repository
 ┃ ┃ ┃    ┃  ┣ AutorRepository.java
 ┃ ┃ ┃    ┃  ┣ EditoraRepository.java
 ┃ ┃ ┃    ┃  ┣ GeneroRepository.java
 ┃ ┃ ┃    ┃  ┣ LivroRepository.java
 ┃ ┃ ┃    ┃  ┗ UsuarioRepository.java
 ┃ ┃ ┃    ┣ security
 ┃ ┃ ┃    ┃  ┣ JwtFilter.java
 ┃ ┃ ┃    ┃  ┣ JwtUtil.java
 ┃ ┃ ┃    ┃  ┗ UserDetailsServiceImpl.java
 ┃ ┃ ┃    ┣ service
 ┃ ┃ ┃    ┃  ┣ AutorService.java
 ┃ ┃ ┃    ┃  ┣ EditoraService.java
 ┃ ┃ ┃    ┃  ┣ EmailService.java
 ┃ ┃ ┃    ┃  ┣ GeneroService.java
 ┃ ┃ ┃    ┃  ┗ LivroService.java
 ┃ ┃ ┃    ┗ BibliotecaApplication.java
 ┃ ┃ ┗ resources
 ┃ ┃    ┣ Biblioteca.sql
 ┃ ┃    ┣ application.properties
 ┃ ┃    ┗static
 ┃ ┃       ┗login.html
 ┃ ┗ test
 ┃    ┗ java/br/com/escola/biblioteca
 ┃       ┗ BibliotecaApplicationTests.java
 ┣ logs
 ┃ ┗ biblioteca.log
 ┗ pom.xml
```

---

# ⚙️ Funcionalidades

## 🔐 Autenticação

* ✅ Registrar usuário
* ✅ Login com retorno de token JWT
* ✅ Todas as rotas protegidas por token (exceto `/auth/**` e Swagger)

## 👨‍💼 Autores

* ✅ Cadastrar autor
* ✅ Cadastrar vários autores de uma vez (lote)
* ✅ Listar autores
* ✅ Buscar autor por ID
* ✅ Atualizar autor
* ✅ Remover autor

## 🏢 Editoras

* ✅ Cadastrar editora
* ✅ Listar editoras
* ✅ Buscar editora por ID
* ✅ Atualizar editora
* ✅ Remover editora

## 🎭 Gêneros

* ✅ Cadastrar gênero
* ✅ Listar gêneros
* ✅ Buscar gênero por ID
* ✅ Atualizar gênero
* ✅ Remover gênero

## 📚 Livros

* ✅ Cadastrar livro (obrigatório: autor, editora e gênero)
* ✅ Cadastrar vários livros de uma vez (lote)
* ✅ Listar livros
* ✅ Buscar livro por ID
* ✅ Atualizar livro
* ✅ Excluir livro
* ✅ Envio de e-mail ao cadastrar, alterar e excluir

---

# 🌐 Endpoints

> ⚠️ Todas as rotas abaixo (exceto `/auth/**`) exigem o header: `Authorization: Bearer <token>`

## 👨‍💼 Autores — `/autores`

| Método | Rota            | Descrição                          |
|--------|-----------------|------------------------------------|
| GET    | `/autores`      | Lista todos os autores             |
| GET    | `/autores/{id}` | Busca autor por ID                 |
| POST   | `/autores`      | Cadastra um novo autor             |
| POST   | `/autores/lote` | Cadastra vários autores de uma vez |
| PUT    | `/autores/{id}` | Atualiza os dados de um autor      |
| DELETE | `/autores/{id}` | Remove um autor                    |

## 🏢 Editoras — `/editoras`

| Método | Rota             | Descrição                        |
|--------|------------------|----------------------------------|
| GET    | `/editoras`      | Lista todas as editoras          |
| GET    | `/editoras/{id}` | Busca editora por ID             |
| POST   | `/editoras`      | Cadastra uma nova editora        |
| PUT    | `/editoras/{id}` | Atualiza os dados de uma editora |
| DELETE | `/editoras/{id}` | Remove uma editora               |

## 🎭 Gêneros — `/generos`

| Método | Rota            | Descrição                      |
|--------|-----------------|--------------------------------|
| GET    | `/generos`      | Lista todos os gêneros         |
| GET    | `/generos/{id}` | Busca gênero por ID            |
| POST   | `/generos`      | Cadastra um novo gênero        |
| PUT    | `/generos/{id}` | Atualiza os dados de um gênero |
| DELETE | `/generos/{id}` | Remove um gênero               |

## 📚 Livros — `/livros`

| Método | Rota           | Descrição                         |
|--------|----------------|-----------------------------------|
| GET    | `/livros`      | Lista todos os livros             |
| GET    | `/livros/{id}` | Busca livro por ID                |
| POST   | `/livros`      | Cadastra um novo livro            |
| POST   | `/livros/lote` | Cadastra vários livros de uma vez |
| PUT    | `/livros/{id}` | Atualiza os dados de um livro     |
| DELETE | `/livros/{id}` | Remove um livro                   |

---

# 📖 Exemplos de Requisição

## Login

```http
POST /auth/login
Content-Type: application/json
```

```json
{
 "senha": "admin123"
  "login": "admin",
}
```

Resposta:

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "tipo": "Bearer",
    "username": "admin"
}
```

## Usar o token nas requisições

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

## Criar Gênero

```http
POST /generos
Content-Type: application/json
Authorization: Bearer <token>
```

```json
{
  "nome": "Romance",
  "sigla": "ROM"
}
```

## Criar Editora

```http
POST /editoras
Content-Type: application/json
Authorization: Bearer <token>
```

```json
{
  "nome": "Companhia das Letras",
  "cnpj": "11.222.333/0001-44",
  "estado": "SP"
}
```

## Criar Autor

```http
POST /autores
Content-Type: application/json
Authorization: Bearer <token>
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
Authorization: Bearer <token>
```

```json
{
  "titulo": "Dom Casmurro",
  "isbn": "9788535910657",
  "anoPublicacao": 1899,
  "autorId": 1,
  "editoraId": 1,
  "generoId": 1
}
```

---

# 🧱 Arquitetura Utilizada

O projeto segue uma arquitetura em camadas (Layered Architecture):

```
[ Cliente / Swagger ]
        ↓
  [ Controller ]      ← recebe as requisições HTTP, valida token JWT
        ↓
   [ Service ]        ← regras de negócio, envio de e-mail, conversão DTO ↔ Entity
        ↓
 [ Repository ]       ← acesso ao banco via Spring Data JPA
        ↓
  [ PostgreSQL ]
```

### Detalhamento de cada camada

| Camada | Classes | Responsabilidade |
|---|---|---|
| **Controller** | `AuthController`, `AutorController`, `EditoraController`, `GeneroController`, `LivroController` | Expõe os endpoints REST, valida entrada com `@Valid`, exige token JWT |
| **Service** | `AutorService`, `EditoraService`, `GeneroService`, `LivroService`, `EmailService` | Regras de negócio, busca de entidades relacionadas, envio de e-mail, conversão DTO ↔ Entity |
| **Repository** | `AutorRepository`, `EditoraRepository`, `GeneroRepository`, `LivroRepository` | Interfaces `JpaRepository` — CRUD gerado automaticamente pelo Spring Data |
| **Entity** | `Autor`, `Editora`, `Genero`, `Livro` | Mapeamento JPA das tabelas; relacionamentos `@ManyToOne` entre Livro, Autor, Editora e Genero |
| **DTO** | `*RequestDTO`, `*ResponseDTO` | Records Java para entrada e saída de dados; `ResponseDTO` contém método estático `fromEntity()` |
| **Security** | `JwtUtil`, `JwtFilter`, `UserDetailsServiceImpl` | Geração e validação de tokens JWT; filtro que intercepta todas as requisições |
| **Exception** | `GlobalExceptionHandler`, `BusinessException`, `Validador` | Captura exceções globalmente via `@RestControllerAdvice`; retorna respostas padronizadas com `timestamp`, `status`, `erro` e `mensagem` |
| **Config** | `SecurityConfig`, `PasswordEncoderConfig`, `SwaggerConfig` | Configura Spring Security, encoder de senhas e OpenAPI com suporte a autenticação Bearer no Swagger |
| ** Validation** | `CnpjValidador`, `CnpjValido` | Valida o cnpj|
---

# ▶️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/matheussilveirasantos/API-Livraria.git
```

## 2️⃣ Entrar na pasta do projeto

```bash
cd API-Livraria/biblioteca
```

## 3️⃣ Configurar o PostgreSQL

```sql
CREATE DATABASE biblioteca;
```

## 4️⃣ Configurar o `application.properties`

Ajuste o arquivo `src/main/resources/application.properties`:

```properties
# Banco de dados
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

# JWT
jwt.secret=SUA_CHAVE_SECRETA_FORTE_AQUI
jwt.expiration=86400000

# E-mail (use uma Senha de App do Gmail)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seuemail@gmail.com
spring.mail.password=SUA_SENHA_DE_APP
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Destinatários das notificações
biblioteca.email.destinatario=seuemail@gmail.com
```


## 5️⃣ Executar a aplicação

```bash
./mvnw spring-boot:run
```

Ou diretamente pela classe principal `BibliotecaApplication.java` na sua IDE.

---

# 🌐 Acesso da API

| Recurso    | URL                                              |
|------------|--------------------------------------------------|
| API        | [login ](http://localhost:8080/login.html)       |
| Swagger UI | [swagger](http://localhost:8080/swagger-ui.html) |
| API Docs   | [api docs](http://localhost:8080/api-docs)       |

> No Swagger, clique em **Authorize** e cole o token no formato: `Bearer <token>`

---

# 🧪 Testes

```bash
./mvnw test
```

---

# 📌 Padrões Utilizados

* REST API
* DTO Pattern (Records Java)
* Bean Validation
* Layered Architecture
* JWT Authentication (Stateless)
* Tratamento global de exceções (`@RestControllerAdvice`)
* Documentação automática com Swagger/OpenAPI
* Notificações por e-mail (cadastro, atualização e exclusão de livros)
* HikariCP para pool de conexões

---

# 🎯 Objetivo do Projeto

Projeto desenvolvido com fins educacionais para prática de desenvolvimento de APIs REST com Spring Boot, banco de dados relacional, autenticação JWT, envio de e-mails e trabalho em equipe com Git e GitHub.

---

