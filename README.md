# 📋 API de Gestión Médica - Voll Med

Este proyecto es una API RESTful para la gestión de consultas médicas, desarrollada con Spring Boot 3 y Java.

## 🚀 Características principales

- **Gestión de médicos**: Registro, actualización y listado de profesionales médicos
- **Gestión de pacientes**: Registro y activación/desactivación de pacientes
- **Sistema de consultas**: Reserva de turnos médicos con múltiples validaciones
- **Autenticación JWT**: Seguridad basada en tokens
- **Documentación con Swagger**: API documentada y fácil de probar

## 🛠 Tecnologías utilizadas

- **Backend**:
  - Java 17
  - Spring Boot 3
  - Spring Security
  - Spring Data JPA
  - Hibernate
  - MySQL
  - Flyway (para migraciones de base de datos)
  - Lombok

## 📌 Endpoints principales

### 🔒 Autenticación
- `POST /login` - Autenticación de usuarios

### 👨‍⚕️ Médicos
- `POST /medicos` - Registrar nuevo médico
- `GET /medicos` - Listar médicos activos
- `PUT /medicos` - Actualizar datos de médico
- `DELETE /medicos/{id}` - Desactivar médico

### 🏥 Pacientes
- `POST /pacientes` - Registrar nuevo paciente
- `GET /pacientes` - Listar pacientes activos
- `PUT /pacientes` - Actualizar datos de paciente
- `DELETE /pacientes/{id}` - Desactivar paciente

### 📅 Consultas
- `POST /consultas` - Reservar nueva consulta
- `GET /consultas` - Listar consultas (requiere autenticación)

## 🔧 Validaciones de consultas

El sistema implementa múltiples validaciones al reservar consultas:
1. **Horario de atención**: Solo en horario de 7:00 a 19:00
2. **Anticipación**: Mínimo 30 minutos de anticipación
3. **Paciente activo**: El paciente debe estar activo
4. **Médico activo**: El médico debe estar activo
5. **Disponibilidad**: El médico no debe tener otra consulta a la misma hora
6. **Paciente sin consulta el mismo día**: Un paciente no puede tener más de una consulta por día

## 🚧 Requisitos previos

- Java 17 o superior
- MySQL 8.0+
- Maven

## ⚙️ Configuración

1. Clonar el repositorio
2. Configurar las propiedades de la base de datos en `application.properties`
3. Ejecutar las migraciones de Flyway

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/med_voll_api
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## 🏃 Ejecución

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8086`

## 📚 Documentación API

Una vez iniciada la aplicación, accede a la documentación Swagger en:
`http://localhost:8086/swagger-ui.html`

## 🧠 Estructura del proyecto

```
src/
├── main/
│   ├── java/med/voll/api/
│   │   ├── config/          # Configuraciones de la aplicación
│   │   ├── controller/      # Controladores REST
│   │   ├── domain/          # Lógica de negocio
│   │   │   ├── consulta/    # Entidades y servicios de consultas
│   │   │   ├── medico/      # Entidades y servicios de médicos
│   │   │   └── paciente/    # Entidades y servicios de pacientes
│   │   ├── infra/           # Infraestructura (seguridad, errores)
│   │   └── Application.java # Punto de entrada
│   └── resources/
│       ├── db/migration/    # Scripts de Flyway
│       └── application.properties
```

## 🤝 Contribución

Si deseas contribuir al proyecto, por favor:
1. Haz un fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/nueva-feature`)
3. Haz commit de tus cambios (`git commit -am 'Añade nueva feature'`)
4. Haz push a la rama (`git push origin feature/nueva-feature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.


Ejemplos visuales tests:

![testEjmploMEDVOLL](https://github.com/user-attachments/assets/8c3c1b54-a436-4960-9343-5fdc9f685362)

![medRepoTEST_medVoll](https://github.com/user-attachments/assets/2caab680-27f3-4042-99e2-c3ed03f6c8db)
