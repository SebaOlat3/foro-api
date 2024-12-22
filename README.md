
# Foro API

Foro API es una aplicación REST desarrollada en **Java** con **Spring Boot**. Simula un foro básico, permitiendo la gestión de tópicos (creación, listado y eliminación) con autenticación basada en **JWT**.

## **Características**

- **Listar Tópicos**: Obtener una lista de todos los tópicos registrados.
- **Crear Tópico**: Agregar un nuevo tópico. **Requiere autenticación JWT.**
- **Eliminar Tópico**: Eliminar un tópico por su ID. **Requiere autenticación JWT.**

---

## **Tecnologías Utilizadas**

- **Java 11**
- **Spring Boot**:
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **H2 Database** (configuración predeterminada, puede cambiarse a PostgreSQL o MySQL).
- **JWT** para autenticación.

---

## **Requisitos Previos**

1. **Java 11** o superior instalado.
2. **Maven** configurado.
3. **Postman** (opcional, para probar los endpoints).

---

## **Configuración Inicial**

### 1. Clonar el repositorio
```bash
git clone https://github.com/SebaOlat3/foro-api.git
cd foro-api
2. Configurar la base de datos
El proyecto utiliza H2 Database como base de datos en memoria por defecto. Si deseas usar otra base de datos (como PostgreSQL o MySQL), modifica el archivo src/main/resources/application.properties.

Ejemplo de configuración para PostgreSQL:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/foro
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
3. Compilar el proyecto
Ejecuta el siguiente comando para compilar y construir el proyecto:

bash
Copiar código
mvn clean install
4. Ejecutar la aplicación
Ejecuta el proyecto con:

bash
Copiar código
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.

Uso de la API
1. Obtener lista de tópicos
Endpoint: GET /api/topics
Descripción: Devuelve una lista de todos los tópicos registrados.

2. Crear un nuevo tópico
Endpoint: POST /api/topics
Descripción: Agrega un nuevo tópico.
Requiere Autenticación JWT.

Ejemplo de request:

http
Copiar código
POST /api/topics
Content-Type: application/json
Authorization: Bearer <JWT_TOKEN>

Body:
{
  "title": "Título del tópico",
  "message": "Mensaje del tópico"
}
3. Eliminar un tópico
Endpoint: DELETE /api/topics/{id}
Descripción: Elimina un tópico por su ID.
Requiere Autenticación JWT.

Ejemplo de request:

http
Copiar código
DELETE /api/topics/1
Authorization: Bearer <JWT_TOKEN>
Autenticación JWT
Para acceder a las rutas protegidas (POST /api/topics y DELETE /api/topics/{id}), necesitas un token JWT.

Obtener un token JWT
Haz un login simulando un usuario válido. Actualmente, las credenciales son simuladas para facilitar las pruebas:

Endpoint: POST /api/auth/login
Ejemplo de request:

http
Copiar código
POST /api/auth/login
Content-Type: application/json

Body:
{
  "username": "user",
  "password": "password"
}
Ejemplo de respuesta:

json
Copiar código
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Estructura del Proyecto
bash
Copiar código
foro_api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── foro/
│   │   │           ├── controller/      # Controladores REST
│   │   │           ├── model/           # Modelos de datos
│   │   │           ├── repository/      # Interfaces JPA
│   │   │           └── security/        # Lógica de seguridad JWT
│   ├── resources/
│       └── application.properties       # Configuración del proyecto
├── pom.xml                              # Dependencias Maven
└── README.md                            # Documentación del proyecto
Pruebas
Listar Tópicos

http
Copiar código
GET http://localhost:8080/api/topics
Crear Tópico

http
Copiar código
POST http://localhost:8080/api/topics
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

Body:
{
  "title": "Nuevo Tópico",
  "message": "Este es un mensaje de prueba"
}
Eliminar Tópico

http
Copiar código
DELETE http://localhost:8080/api/topics/{id}
Authorization: Bearer <JWT_TOKEN>
Contribución
¡Contribuye a mejorar esta API!

Haz un fork del repositorio.
Crea una rama para tus cambios:
bash
Copiar código
git checkout -b mi-rama
Realiza tus cambios y haz un commit:
bash
Copiar código
git commit -m "Agregué una nueva funcionalidad"
Sube los cambios a tu repositorio:
bash
Copiar código
git push origin mi-rama
Crea un Pull Request en el repositorio original.
Autor
Sebastián Vásquez
GitHub: SebaOlat3
