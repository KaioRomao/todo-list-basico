## Projeto Fácil

### Cadastro de Tarefas (To-Do List)

- Descrição:
  Desenvolver um aplicativo simples de cadastro de tarefas (To-Do List). Os usuários podem adicionar, atualizar, excluir e visualizar tarefas. Cada tarefa deve ter um título, uma descrição e um status (concluída ou não).

- Principais Conceitos e Tecnologias:
    - CRUD (Create, Read, Update, Delete) básico.
    - Utilização do Spring Boot para criar endpoints REST.
    - Armazenamento de dados em memória ou usando um banco de dados embutido como o H2.
    - Utilização de operações básicas de banco de dados (por exemplo, Spring Data JPA).


### TODO

- Alimentar o Readme com as tecnologias utilizadas no projeto; OK
- Alimentar o Readme com os descritivos das rotas do controller; OK
- Pesquisar os tipos de GenerationType do @GeneratedValue; OK
- Mapeadores automáticos para Java (ModelMapper, Orika, JMapper); OK
- Fazer o método getAll funcionar; OK
- Simplificar o código repetitivo; OK

### API BackEnd Todo-List
- SPRING
- JAVA 11

### Rotas
- BaseURL: /tasks
- POST: create()
- GET: getAll()

### Model
```json
{
  "name": "kaio",
  "title": "teste",
  "description": "teste",
  "status": true
}
```
