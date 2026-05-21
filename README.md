# ONG Caridade

Sistema para criação e gerenciamento de campanhas de caridade, desenvolvido com o objetivo de praticar e consolidar habilidades com Java, Spring Boot e Firebase.

## Sobre o projeto

O sistema permite que organizações cadastrem e gerenciem campanhas de arrecadação, conectando organizadores e doadores. As doações podem ser realizadas tanto em itens quanto em dinheiro.

## Funcionalidades

- Cadastro e autenticação de usuários (Doadores e Organizadores)
- Criação e gerenciamento de campanhas de caridade
- Registro de doações em itens ou dinheiro
- Listagem de campanhas por organizador

## Tecnologias

- **Java 21**
- **Spring Boot 3.5.14**
- **Firebase Firestore** — banco de dados NoSQL em nuvem
- **Firebase Admin SDK** — autenticação e acesso ao banco
- **Lombok** — redução de código boilerplate
- **Maven** — gerenciamento de dependências

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

4. Configure a variável de ambiente apontando para o arquivo de credenciais
   ```bash
   # Windows
   FIREBASE_CREDENTIALS=C:\caminho\para\firebase-credentials.json

   # Linux/macOS
   export FIREBASE_CREDENTIALS=/caminho/para/firebase-credentials.json
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
        ├── repository/    # Acesso ao Firestore
        ├── service/       # Regras de negócio
        └── controller/    # Endpoints REST
```

## Autores

- **Gustavo** — [GuSprang](https://github.com/GuSprang)
- **Rafaella**
- **Ana Paula**

---

Projeto acadêmico desenvolvido na Universidade de Mogi das Cruzes (UMC).
