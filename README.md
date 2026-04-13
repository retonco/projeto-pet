# 🐾 Sistema de Cadastro de Pets

Aplicação fullstack desenvolvida com Java + Spring Boot para gerenciamento de pets, incluindo cadastro, listagem, edição e remoção.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- HTML, CSS e JavaScript
- Maven

---

## 🧱 Arquitetura

O projeto segue o padrão de arquitetura em camadas (Layered Architecture):

Controller → Service → Repository → Banco de Dados

- Controller: recebe requisições HTTP  
- Service: contém regras de negócio  
- Repository: acesso ao banco via JPA  
- DTO: transporte de dados entre camadas  

---

## ⚙️ Funcionalidades

- Cadastro de pets (POST)
- Listagem de pets (GET)
- Atualização de pets (PUT)
- Remoção de pets (DELETE)
- Cadastro de adotantes (POST)
- Listagem de adotantes (GET)
- Exibição de imagens via URL
- Interface web integrada com a API

### 🔗 Adoção
- Associação entre pet e adotante  
- Um pet pode estar vinculado a um adotante  

### ✔️ Validações
- Idade não pode ser negativa  
- Sexo permitido: `MACHO` ou `FEMEA`  
- E-mail único para adotantes  

---

## 🐳 Como rodar o projeto

### 1. Subir o banco com Docker

```
docker run -d \
  --name postgres-pets \
  -e POSTGRES_DB=pets \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres
```

---

### 2. Rodar a aplicação

*./mvnw spring-boot:run*

ou execute a classe principal no IntelliJ.

---

### 3. Acessar a aplicação

API:
http://localhost:8080/bobconnect

Frontend:
http://localhost:8080/index2.html

---

## 🗄️ Configuração do banco

- Arquivo “application.properties”

```spring.datasource.url=jdbc:postgresql://localhost:5432/pets  
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🗄️ Banco de dados

O projeto utiliza PostgreSQL como banco de dados e pode ser configurado de duas formas:

🔹 Opção 1 — Criação automática (Hibernate)

Com a configuração abaixo no application.properties, o Spring Boot cria automaticamente as tabelas com base nas entidades:

*spring.jpa.hibernate.ddl-auto=update*

Essa abordagem é prática para desenvolvimento, pois evita a necessidade de criar tabelas manualmente.


🔹 Opção 2 — Criação manual (SQL):

Também é possível criar a estrutura do banco manualmente utilizando comandos SQL:

```sql
CREATE TABLE adotantes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE pets (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    sexo VARCHAR(20) NOT NULL CHECK (sexo IN ('MACHO', 'FEMEA')),
    raca VARCHAR(100),
    idade INTEGER CHECK (idade >= 0),
    imagem VARCHAR(255),
    adotante_id INTEGER,
    CONSTRAINT fk_adotante
        FOREIGN KEY (adotante_id)
        REFERENCES adotantes(id)
);
```

## Relacionamento
- Um pet pode estar associado a um adotante
- Implementado através de chave estrangeira (adotante_id)
- Garante integridade referencial no banco


# ⚠️ Observações importantes
- O banco de dados precisa ser criado previamente:

*CREATE DATABASE pets;*

- O Spring Boot não cria o banco, apenas as tabelas

---

## 📦 Estrutura do projeto

```
src/
 ├── controller/   → endpoints da API
 ├── service/      → regras de negócio
 ├── repository/   → acesso ao banco
 ├── model/        → entidades
 ├── dto/          → objetos de transferência
 └── resources/
      └── static/  → frontend (HTML)
           └── index2.html
```

---

## 💡 Observações

- O frontend se comunica com a API por meio de requisições HTTP utilizando a função fetch do JavaScript.

---

## 📈 Melhorias futuras

- Autenticação e login
- Validação de dados
- Interface com CSS/Framework
- Cadastro de adotantes
- Relação adotante/ pet

---

## 👩‍💻 Autoria

- Renata Toncovitch
- Thiago Goldin
- Arthur Bueno

---

## 📌 Status

Projeto funcional com CRUD completo  
Integração frontend + backend  
