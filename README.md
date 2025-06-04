# 📚 Biblioteca Java – Sistema de gestión con H2 y patrón DAO

Este proyecto es una aplicación de consola en Java para gestionar autores y libros utilizando una base de datos H2. Emplea el patrón DAO (Data Access Object) para separar la lógica de acceso a datos de la lógica del negocio, y proporciona un menú interactivo para realizar operaciones CRUD.

---

## 🛠️ Tecnologías utilizadas

- Java 17+
- H2 Database (modo archivo)
- JDBC
- Patrón DAO
- Gradle (opcional, si lo usas)
- SQL (script de inicialización init.sql)

---

## ⚙️ Estructura del proyecto



src/
├── main/
│   ├── java/
│   │   ├── org.example/
│   │   │   ├── Main.java                # Clase principal
│   │   │   ├── BibliotecaMenu.java      # Menú interactivo
│   │   │   ├── dao/
│   │   │   │   ├── GenericDAO.java
│   │   │   │   ├── LibroDAO.java
│   │   │   │   └── AutorDAO.java
│   │   │   ├── model/
│   │   │   │   ├── Autor.java
│   │   │   │   └── Libro.java
│   │   │   └── util/
│   │   │       ├── ConexionBD.java
│   │   │       └── Log.java
│   └── resources/
│       └── init.sql                     # Script SQL para crear tablas



---

## 📋 Funcionalidades del menú

El sistema ofrece un menú interactivo en consola:



\=== MENÚ BIBLIOTECA ===

1. Ingresar un autor
2. Ingresar un libro
3. Buscar un autor
4. Buscar un libro
5. Listar todos los autores
6. Listar todos los libros
7. Actualizar un autor
8. Actualizar un libro
9. Eliminar un autor
10. Eliminar un libro
11. Salir

`

---

## 🧩 Base de datos

El archivo init.sql se ejecuta automáticamente al inicio para crear las tablas necesarias:

sql
CREATE TABLE IF NOT EXISTS Autor (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Libro (
    numero INT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL UNIQUE,
    clasificacion VARCHAR(50),
    tema VARCHAR(20)
);
`

La base de datos se guarda localmente en: ./Base_de_datos/db.mv.db

---

## 🚀 Cómo ejecutar

1. Clona este repositorio:

   bash
   git clone https://github.com/tuusuario/biblioteca-java.git
   cd biblioteca-java
   

2. Asegúrate de que el archivo init.sql esté en src/main/resources.

3. Ejecuta la aplicación desde tu IDE o desde consola:

   bash
   ./gradlew run
   

   O si usas compilación manual:

   bash
   javac -d out src/main/java/org/example/*.java
   java -cp out org.example.Main
   

---

