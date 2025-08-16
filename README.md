# MovieCatalog-Java

Aplicação de catálogo de filmes desenvolvida em Java Swing, consumindo a API do The Movie Database (TMDb), com foco em Programação Orientada a Objetos (POO).

## 📌 Descrição

Este projeto simula um catálogo de filmes, onde o usuário pode:

-Fazer login na aplicação
-Selecionar filmes por gênero
-Visualizar pôsteres e títulos dos filmes
-Navegar por uma interface gráfica interativa

O código foi estruturado com foco no uso correto de POO, incluindo encapsulamento, composição e boas práticas de programação em Java.

---

## 🧩 Funcionalidades

- Login simples de usuário
- Painel lateral com botões de gêneros
- Exibição de filmes em grid com pôster e título
- Atualização dinâmica de filmes usando chamadas à API TMDb
- Tratamento de exceções em caso de falha na requisição

---
## 🛠️ Tecnologias Utilizadas

- Java 17+ (compatível com versões anteriores)
- IntelliJ IDEA (projeto criado e estruturado nele)
- Swing para interface gráfica
- Gson para manipulação de JSON
- Consumo da API TMDb para obter filmes por gênero
- Padrões de POO: encapsulamento, composição, separação por classes
- 
---
## 📂 Estrutura do Projeto

- Main.java – classe principal, responsável pelo login e interface gráfica
- MovieBrowser.java – classe que realiza chamadas à API e retorna filmes por gênero
- Recursos externos: pôsteres dos filmes carregados diretamente da API TMDb
