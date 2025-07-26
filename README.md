# 🎯 Projeto Spring-Boot Web Services
Este projeto é uma API RESTful construída com Spring Boot feito com orientação do Professor Nélio Alves, com foco na criação de web services usando JPA, Hibernate, banco de dados H2 e com conexão ao banco de dados PostgreSQL. Ele simula um sistema de pedidos contendo entidades como usuários, produtos, pedidos e pagamentos.

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Postman (para testes de API)
- PostgreSQL
<br>
<br>

## 📦 Entidades do Sistema

| Entidade     | Descrição                                                                |
|--------------|--------------------------------------------------------------------------|
| `Client`     | Representa um cliente com informações pessoais.                          |
| `Product`    | Produto disponível para venda.                                           |
| `Category`   | Categoria de produtos (um produto pode ter várias categorias).           |
| `Order`      | Pedido feito por um cliente.                                             |
| `OrderItem`  | Item de um pedido (associa um produto a um pedido com quantidade e preço).|
| `Payment`    | Representa o pagamento de um pedido, com data de confirmação.            |
<br>
<br>

## 🧬 Relacionamentos

- `Product` ↔️ `Category` → Muitos para muitos
- `Order` → `Client` → Muitos para um
- `OrderItem` → `Order` e `Product` → Muitos para um
- `Order` → `Payment` → Um para um (mapeado opcionalmente)
<br>
<br>

## 🔧 Como executar o projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/DevJuca/Spring-Boot-Web_Services.git
   cd Spring-Boot-Web_Services

2. **Execute com o Maven**

    ```bash
    ./mvnw spring-boot:run

3. **Acesse o banco de dados H2**
    
    ***URL***: http://localhost:8080/h2-console

    ***JDBC URL***: jdbc:h2:mem:testdb

    ***User***: sa

    ***Password***: (em branco)

## 🌐 Endpoinsts disponíveis
**🙎🏽‍♂️ Client**
- GET/clients - Lista todos os clientes.

- GET/clients/{id} - Lista cliente específco pelo id. 

- POST/clients - Cria um novo cliente.

- PUT/clients/{id} - Atualiza cliente específico pelo id. 

- DELETE/clients/{id} - Deleta um cliente pelo id.
<br>
<br>

**🏷️ Products**
- GET/products - Lista todos os produtos.

- GET/products/{id} - Lista produtos específco pelo id. 

- POST/products - Cria um novo produtos.

- PUT/products/{id} - Atualiza produtos específico pelo id. 

- DELETE/products/{id} - Deleta um produtos pelo id.
<br>
<br>

**☰ Category**
- GET/category - Lista todas as categorias.

- GET/category/{id} - Lista uma categoria específco pelo id.

- POST/category - Cria uma nova categoria.

- PUT/category/{id} - Atualiza uma categoria específica pelo id.

- DELETE/category/{id} - Deleta uma categoria pelo id.
<br>
<br>

**🛒 Orders**
- GET/orders - Lista todos os pedidos.

- GET/orders/{id} - Lista um pedidos específco pelo id.

- DELETE/orders/{id} - Deleta um pedido  pelo id.
<br>
<br>

## 🧰 Requisições com Postman
Para fazer as requisições com o Postman, deverá baixar ele. Caso não tenha, aqui esta o site para baixar: 

***URL***: https://www.postman.com/downloads/

Após a instalção, só fazer as resquisições conforme os **Endpoints** acima.
<br>
<br>

## 💡 Funcionalidades
- CRUD completo para as principais entidades

- Mapeamento JPA com @OneToMany, @ManyToOne, @ManyToMany, @OneToOne

- Banco de dados H2 com console web

- Relacionamentos compostos com chaves primárias compostas (OrderItemPK)

- População de dados iniciais via CommandLineRunner ou data.sql
<br>
<br>

## 📌 Objetivos do Projeto
- Praticar a construção de APIs RESTful com Spring Boot

- Aplicar conceitos de JPA e relacionamentos entre entidades

- Simular um sistema de pedidos com entidades reais
<br>
<br>

## 👤 Autor
Professor Nélio ALves (DevSuperior)

🔗 [youtube.com/DevSuperior](https://www.youtube.com/@DevSuperior )

João Carlos (DevJuca)

🔗 [github.com/DevJuca](https://github.com/DevJuca)
