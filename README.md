# Gerenciador de Tarefas (em andamento)
Este é um projeto CRUD para um sistema de vendas. Permite criar produtos e fornecedores, bem como atualizar os dados, excluir e visualizar. Utiliza Java Spring Boot, PostgreSQL e Thymeleaf para renderização do front-end.

##  ⚒️🛠️ Funcionalidades do projeto
- Adicionar produto e fornecedor
- Atualizar produto e fornecedor
- Listar produto e fornecedor
- Excluir produto e fornecedor
- Adicionar compras (aumento de sua quantia no banco) de produto
## 🖥️Tecnologias utilizadas
- Java 21
- Spring Boot
- JDBC
- banco PostgreSQL
- Thymeleaf
- Lombok

## 🔎 Endpoints

| Método | Rota                      | Descrição                           |
| ------ | ------------------------- | ----------------------------------- |
| GET    | `/`                       | Página inicial |
| GET    | `/supplier/list`             | Listar todos os fornecedores   |
| GET    | `/supplier/form`             | Formulário para adição de novo fornecedor   |
| GET |`/supplier/add`| Adição dos dados do formulário no banco de dados
