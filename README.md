# Todo List Application

## Description
A simple Todo List application built with Java, Spring Boot, Thymeleaf, and MySQL. This application allows users to create, read, update, and delete tasks.

## Technologies Used
- **Java SE**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Thymeleaf**
- **JUnit and Mockito**

## Features
- Add new tasks with a title and description
- View a list of all tasks
- Edit existing tasks
- Delete tasks
- Mark tasks as completed

## Prerequisites
- **Java 11 or higher**
- **Maven**
- **MySQL**

## Setup Instructions

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/todo-list-app.git
    cd todo-list-app
    ```

2. **Configure the database**
    - Create a MySQL database named `todo_list_db`.
    - Update the `application.properties` file with your MySQL username and password.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/todo_list_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build and run the application**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Access the application**
    Open your browser and go to `http://localhost:8080`
