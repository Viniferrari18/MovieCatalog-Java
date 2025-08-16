MovieCatalog-Java

Aplicação em Java Swing que consome a API do The Movie Database (TMDb) para exibir filmes por gênero, simulando um catálogo interativo com interface gráfica.

📌 Descrição

Este projeto permite ao usuário:

Fazer login na aplicação

Visualizar filmes categorizados por gênero

Navegar pelos filmes com exibição de pôster e título

Atualizar a lista de filmes dinamicamente através de chamadas à API TMDb

O código é estruturado com foco em Programação Orientada a Objetos (POO), incluindo encapsulamento, composição e separação de responsabilidades por classes.

🧩 Funcionalidades

Login simples de usuário

Painel lateral com botões de gêneros

Painel central com grid de filmes, exibindo pôster e título

Atualização dinâmica usando SwingWorker para carregar filmes da API

Tratamento de exceções em chamadas à API

🛠️ Tecnologias Utilizadas

Java 17+ (compatível com versões anteriores)

Swing para interface gráfica

Gson para manipulação de JSON

API TMDb para dados de filmes

IntelliJ IDEA (ambiente recomendado)

📂 Estrutura do Projeto

Main.java – classe principal, responsável pelo login e interface gráfica

MovieBrowser.java – classe que realiza chamadas à API TMDb e retorna os filmes por gênero

Recursos externos: imagens de pôster carregadas diretamente da API TMDb
