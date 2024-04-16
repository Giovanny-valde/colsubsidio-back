# Banco_api

 Api que genera el comportamiento de un banco con cuentas, usuarios y movimiento de saldos de la cuenta.
 
## Requisitos

- Java 17
- maven (gestion de dependencias)

## Tecnologias

- Framework SpringBoot
- Spring JPA (Para el acceso al repositorio y base de datos)
- Spring Web (Para el la exposicion de los endpoint)
- Spring Validation (Para la validacion del cuerpo de las peticiones HTTP PUT y POST)
- MapStruct (Para el mapeo entre las entidades y los DTO)
- H2 database (Base de datos en memoria)
- Liquibase (Para las migraciones de bases de datos)

## Instalacion y uso

1. Navega al directorio del proyecto
2. Inicia la aplicación: `mvnw spring-boot:run`
3. La URL base para consumir los servicios esta alojada en : `http://localhost:8080` (mas el path del servicio que desea consumir que estan expuestos en el paquete de controladores)

## Estructura del proyecto

La estructura del proyecto esta basado en una arquitectura por capas donde tenemos la capa de entidades, la capa de repositorio, la capa de servicio y la capa de controladores

───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───banco
│   │   │           └───api
│   │   │               ├───config
│   │   │               ├───controller
│   │   │               ├───dto
│   │   │               ├───entity
│   │   │               ├───exception
│   │   │               ├───mapper
│   │   │               ├───repository
│   │   │               ├───service
│   │   │               │   └───impl
│   │   │               └───util
│   │   └───resources
│   │       ├───db
│   │       │   └───changelog
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───banco
│                   └───api
│                       ├───controller
│                       └───service
│                           └───impl