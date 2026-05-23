# 📚 API Biblioteca

Uma API REST desenvolvida com Java + Spring Boot para gerenciamento de livros e autores.

O projeto foi criado com foco em boas práticas de desenvolvimento backend, utilizando arquitetura em camadas, DTOs, validações e documentação automática com Swagger/OpenAPI.

---

# 🚀 Tecnologias Utilizadas

* ☕ Java 17
* 🌱 Spring Boot 3
* 🗄️ Spring Data JPA
* ✅ Bean Validation
* 🐘 PostgreSQL
* 📖 Swagger / OpenAPI
* 🧪 JUnit
* 📦 Maven
* 🔥 Lombok

---

# 📁 Estrutura do Projeto

```bash
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ br/com/escola/biblioteca
 ┃ ┃    ┣ config
 ┃ ┃    ┣ controller
 ┃ ┃    ┣ dto
 ┃ ┃    ┣ entity
 ┃ ┃    ┣ repository
 ┃ ┃    ┗ service
 ┃ ┗ resources
 ┃    ┗ application.properties
 ┗ test
```

---

# ⚙️ Funcionalidades

## 👨‍💼 Autores

* ✅ Cadastrar autores
* ✅ Listar autores
* ✅ Buscar autor por ID
* ✅ Atualizar autor
* ✅ Remover autor

## 📚 Livros

* ✅ Cadastro de livros
* ✅ Associação com autores
* ✅ Atualização de livros
* ✅ Exclusão de livros
* ✅ Consulta de livros

---

# 🧱 Arquitetura Utilizada

O projeto segue uma arquitetura em camadas:

* **Controller** → Responsável pelos endpoints da API
* **Service** → Regras de negócio
* **Repository** → Comunicação com banco de dados
* **DTO** → Transferência de dados
* **Entity** → Representação das tabelas

---

# ▶️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone <https://github.com/matheussilveirasantos/API-Livraria.git>
```

---

## 2️⃣ Entrar na pasta do projeto

```bash
cd biblioteca
```

---

## 3️⃣ Configurar o PostgreSQL

Crie um banco chamado:

```sql
CREATE DATABASE biblioteca;
```

---

## 4️⃣ Configurar o application.properties

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

Ou diretamente pela classe:

```bash
BibliotecaApplication.java
```

---

# 🌐 Acesso da API

Aplicação:

```bash
http://localhost:8080
```

Swagger:

```bash
http://localhost:8080/swagger-ui.html
```

API Docs:

```bash
http://localhost:8080/api-docs
```

---

# 📖 Exemplo de Endpoint

## Criar Autor

### POST

```http
POST /autores
```

### Body

```json
{
  "nome": "Machado de Assis",
  "nacionalidade": "Brasileiro",
  "dataNascimento": "1839-06-21"
}
```

---

# 🧪 Testes

Para executar os testes:

```bash
./mvnw test
```

---

# 📌 Padrões Utilizados

* REST API
* DTO Pattern
* Validation Pattern
* Layered Architecture
* Tratamento global de exceções
* Documentação automática com Swagger

---

# 👨‍💻 Equipe

## Desenvolvedores

* Caique
* Simone
* Matheus
* Rayla
* Patrick

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

Projeto desenvolvido para estudos e aprendizado.