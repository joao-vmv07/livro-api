<h1 align="center" style="font-weight: bold;">Livro API 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#pre"> Pré-requisitos</a> • 
 <a href="#doc">Documentação</a> •
  <a href="#routes">API Endpoints</a> •
  <a href="#obs">Observações</a> 
</p>

<p align="center">
    <b>API RESTFull para gerenciar catálogo de livros</b>
</p>

<h2 id="tech">🛠️ Tecnologias </h2>

- Java
- Spring Boot
- JPA e Data Base H2
- Maven
- JUnit


<h2 id="pre">Pré-requisitos 🚀</h2>

- [JAVA 21](https://www.oracle.com/br/java/technologies/downloads/)
- [Apache Maven 3.9.9 ](https://maven.apache.org/)


<h2>Clonando projeto</h2>

```bash
git clone https://github.com/joao-vmv07/livro-api.git
```

<h2>Bash/Terminal</h2>

Execute seguinte comandos para subir API!
```bash
cd livro-api
mvn clean spring-boot:run
mvn spring-boot:run 

```
Para testes unitários execute seguinte comandos:
```bash
cd livro-api
mvn test

```

<h2 id="doc">📚 Documentação</h2>
- Swagger configurado para visualizar <kbd>url </kbd>http://localhost:8080/swagger-ui/index.html#/

<h2 id="routes">📍 API Endpoints</h2>

<kbd>GET /livro/listagem</kbd>	Buscar todos os livros

<kbd>GET /livro/titulo/{titulo}</kbd>	Buscar livros pelo título

<kbd>GET /livro/autor/{autor}</kbd>	Buscar livros pelo autor

<kbd>GET /livro/ano/{ano}</kbd>	Buscar livros pelo ano

<kbd>POST /livro</kbd>	Salvar novo livro

<kbd>PUT /livro/{isbn}</kbd>	Atualizar livro pelo ISBN

<kbd>DELETE /livro/{isbn}</kbd>	Deletar livro pelo ISBN


<h2 id="obs">🔍 Observações</h2>

- Aplicação inicia por padrão já com alguns dados salvos no H2

- Definido no aquivo data.sql path /src/main/resources/data.sql
  
- Configurações Data base /src/main/resources/aplication.properties
