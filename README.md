# 🥷 Sistema de Cadastro de Ninjas

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-6DB33F?style=for-the-badge&logo=spring)
![Java](https://img.shields.io/badge/Java-24-blue?style=for-the-badge&logo=openjdk)

Bem-vindo ao **Sistema de Cadastro de Ninjas**!

Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetada para cadastrar ninjas e suas respectivas missões. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub.

---

## 📜 Visão Geral do Projeto

Este sistema foi desenvolvido para gerenciar ninjas e suas missões através de uma interface web e uma API REST. As principais funcionalidades incluem:

* **Cadastro de ninjas** com nome, idade, email e rank.
* **Gerenciamento de missões** e dos ninjas associados a elas.
* **Interface Web** para listar, detalhar, adicionar e excluir ninjas e missões.
* **API REST** documentada para integração com outros sistemas.

---

## 🛠️ Tecnologias Utilizadas

* **Spring Boot:** Para criação da aplicação web e gerenciamento de dependências.
* **Maven:** Para build e gerenciamento das dependências do projeto.
* **Java (versão 24):** Linguagem de programação principal do projeto.
* **Spring Web (MVC):** Para construir a aplicação web e criar controladores para as rotas e API REST.
* **Spring Data JPA (Hibernate):** Para o mapeamento objeto-relacional (ORM) e simplificação da interação com o banco de dados.
* **Banco de Dados H2:** Banco de dados em memória para desenvolvimento e testes.
* **Flyway:** Para gerenciamento de migrações (versionamento de schema) do banco de dados.
* **SQL:** Linguagem utilizada nos scripts do Flyway para manipulação do banco de dados.
* **Thymeleaf:** Para a criação das páginas HTML dinâmicas do lado do servidor (frontend).
* **SpringDoc OpenAPI:** Para documentação automática da API REST com interface Swagger UI.
* **Project Lombok:** Para reduzir código repetitivo (boilerplate) nas classes Java.
* **Spring Boot Test (JUnit/Mockito):** Para a criação de testes unitários e de integração.

---

## 🗃️ Design do Banco de Dados

O esquema do banco de dados segue as seguintes relações:

* **Ninja:** Contém atributos como `id`, `nome`, `idade`, `email` e `rank`.
* **Missão:** Contém atributos como `id`, `título` e `descrição`.

A relação principal é `Muitos-para-Um` (ManyToOne) do Ninja para a Missão. Vários ninjas podem estar na mesma missão, mas cada ninja é designado para no máximo uma missão por vez.

---

## 🚀 Configuração e Execução

Siga os passos abaixo para executar o projeto localmente.

### Pré-requisitos
* Java 24 (ou superior)
* Maven 3.x

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/eduardocaetano0/CadastroDeNinjas.git](https://github.com/eduardocaetano0/CadastroDeNinjas.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd CadastroDeNinjas
    ```

3.  **Construa o projeto com Maven:**
    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

5.  **Acesse a aplicação:**
    * **Interface Web:** [http://localhost:8080/ninjas/ui/listar](http://localhost:8080/ninjas/ui/listar)
    * **Documentação da API (Swagger):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    * **Console do Banco H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
