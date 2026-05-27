[🇧🇷 Português](#português) | [🇺🇸 English](#english)

---

## Português

# ONG Caridade

Sistema para criação e gerenciamento de campanhas de caridade, desenvolvido com o objetivo de praticar e consolidar habilidades com Java, Spring Boot e Firebase.

## Sobre o projeto

O sistema permite que organizações cadastrem e gerenciem campanhas de arrecadação, conectando organizadores e doadores. As doações podem ser realizadas tanto em itens quanto em dinheiro, utilizando o padrão **Decorator** para compor comportamentos dinamicamente.

## Funcionalidades

- Cadastro e autenticação de usuários (Doadores e Organizadores)
- Criação e gerenciamento de campanhas de caridade
- Registro de doações em itens ou dinheiro
- Listagem de campanhas e doações
- Autenticação stateless com JWT

## Tecnologias

- **Java 21**
- **Spring Boot 3.5.14**
- **Firebase Firestore** — banco de dados NoSQL em nuvem
- **Firebase Admin SDK** — autenticação e acesso ao banco
- **Spring Security + JWT** — proteção de rotas
- **Lombok** — redução de código boilerplate
- **Maven** — gerenciamento de dependências
- **JUnit 5 + Mockito** — testes automatizados

## Padrões de Projeto

- **Decorator** — composição de comportamentos nas doações (recibo, notificação)
- **Builder** — construção de campanhas
- **Repository** — abstração de acesso a dados
- **MVC** — padrão arquitetural

## Pré-requisitos

- Java 21+
- Maven 3.8+
- Conta no Firebase com projeto configurado

## Configuração

1. Clone o repositório
   ```bash
   git clone https://github.com/GuSprang/Projeto-ONG.git
   ```

2. Crie um projeto no [Firebase Console](https://console.firebase.google.com) e ative o Firestore

3. Gere uma chave privada em **Configurações do projeto → Contas de serviço → Gerar nova chave privada** e salve o arquivo `.json` fora do repositório

4. Configure as variáveis de ambiente:
   ```bash
   FIREBASE_CREDENTIALS=<conteúdo do seu serviceAccountKey.json>
   JWT_SECRET=sua-chave-secreta-com-minimo-32-caracteres
   JWT_EXPIRATION=86400000
   ```

5. Execute o projeto
   ```bash
   ./mvnw spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`

## Estrutura do projeto

```
src/
└── main/
    └── java/br/umc/ongcaridade/
        ├── config/        # Configuração do Firebase
        ├── entity/        # Modelos de domínio
        │   └── doacao/    # Entidades de doação (padrão Decorator)
        ├── repository/    # Acesso ao Firestore
        ├── service/       # Regras de negócio
        ├── controller/    # Endpoints REST
        └── security/      # Filtro JWT e configuração
```

## Endpoints

| Método | Rota | Descrição | Auth |
|--------|------|-----------|------|
| POST | `/pessoas/cadastro` | Cadastrar usuário | ❌ |
| POST | `/pessoas/login` | Login (retorna JWT) | ❌ |
| GET | `/campanhas` | Listar campanhas | ✅ |
| POST | `/campanhas` | Criar campanha | ✅ |
| GET | `/campanhas/{id}` | Buscar campanha por ID | ✅ |
| PUT | `/campanhas/{id}` | Atualizar campanha | ✅ |
| DELETE | `/campanhas/{id}` | Deletar campanha | ✅ |
| POST | `/doacoes` | Realizar doação | ✅ |
| GET | `/doacoes/doador/{id}` | Listar doações por doador | ✅ |
| GET | `/doacoes/campanha/{id}` | Listar doações por campanha | ✅ |

## Deploy

Disponível no Railway: [projeto-ong-production.up.railway.app](https://projeto-ong-production.up.railway.app)

## Autores

- **Gustavo** — [GuSprang](https://github.com/GuSprang)
- **Rafaella** — [RafaellaNovaes](https://github.com/RafaellaNovaes)
- **Ana Paula** — [An4PDM](https://github.com/An4PDM)

---

Projeto acadêmico desenvolvido na Universidade de Mogi das Cruzes (UMC).

---

## English

# ONG Charity

A system for creating and managing charity campaigns, developed to practice and consolidate skills with Java, Spring Boot, and Firebase.

## About

The system allows organizations to register and manage fundraising campaigns, connecting organizers and donors. Donations can be made either in items or money, using the **Decorator** design pattern to handle different donation types with dynamic behavior composition.

## Features

- User registration and authentication (Donors and Organizers)
- Create and manage charity campaigns
- Register donations in items or money
- List campaigns and donations
- Stateless JWT-based authentication

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.14**
- **Firebase Firestore** — cloud NoSQL database
- **Firebase Admin SDK** — authentication and database access
- **Spring Security + JWT** — stateless authentication
- **Lombok** — boilerplate reduction
- **Maven** — dependency management
- **JUnit 5 + Mockito** — automated testing

## Design Patterns

- **Decorator** — donation behavior composition (receipt, notification)
- **Builder** — campaign construction
- **Repository** — data access abstraction
- **MVC** — architectural pattern

## Prerequisites

- Java 21+
- Maven 3.8+
- Firebase project with Firestore enabled

## Setup

1. Clone the repository
   ```bash
   git clone https://github.com/GuSprang/Projeto-ONG.git
   ```

2. Create a project on [Firebase Console](https://console.firebase.google.com) and enable Firestore

3. Generate a private key at **Project Settings → Service Accounts → Generate new private key** and save the `.json` file outside the repository

4. Set the environment variables:
   ```bash
   FIREBASE_CREDENTIALS=<contents of your serviceAccountKey.json>
   JWT_SECRET=your-secret-key-at-least-32-characters
   JWT_EXPIRATION=86400000
   ```

5. Run the project
   ```bash
   ./mvnw spring-boot:run
   ```

The application will be available at `http://localhost:8080`

## Project Structure

```
src/
└── main/
    └── java/br/umc/ongcaridade/
        ├── config/        # Firebase configuration
        ├── entity/        # Domain models
        │   └── doacao/    # Donation entities (Decorator pattern)
        ├── repository/    # Firestore data access
        ├── service/       # Business logic
        ├── controller/    # REST endpoints
        └── security/      # JWT filter and configuration
```

## API Endpoints

| Method | Route | Description | Auth |
|--------|-------|-------------|------|
| POST | `/pessoas/cadastro` | Register user | ❌ |
| POST | `/pessoas/login` | Login (returns JWT) | ❌ |
| GET | `/campanhas` | List all campaigns | ✅ |
| POST | `/campanhas` | Create campaign | ✅ |
| GET | `/campanhas/{id}` | Get campaign by ID | ✅ |
| PUT | `/campanhas/{id}` | Update campaign | ✅ |
| DELETE | `/campanhas/{id}` | Delete campaign | ✅ |
| POST | `/doacoes` | Make a donation | ✅ |
| GET | `/doacoes/doador/{id}` | List donations by donor | ✅ |
| GET | `/doacoes/campanha/{id}` | List donations by campaign | ✅ |

## Live Demo

Deployed on Railway: [projeto-ong-production.up.railway.app](https://projeto-ong-production.up.railway.app)

## Authors

- **Gustavo** — [GuSprang](https://github.com/GuSprang)
- **Rafaella** — [RafaellaNovaes](https://github.com/RafaellaNovaes)
- **Ana Paula** — [An4PDM](https://github.com/An4PDM)

---

Academic project developed at Universidade de Mogi das Cruzes (UMC).
