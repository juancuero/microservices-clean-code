# Devsu

## Descripción

En este proyecto se desarrollaron dos microservicios utilizando **Spring Boot** para gestionar servicios relacionados con cuentas de usuarios. Los microservicios fueron diseñados para ser independientes, escalables y fáciles de mantener, siguiendo las mejores prácticas de desarrollo de software y principios de arquitectura de microservicios.

Los microservicios se implementaron con una arquitectura **RESTful** y utilizan **JPA** para la gestión de la persistencia de datos y **Kafka** para la mensajería asíncrona entre servicios. Además, se configuraron contenedores **Docker** para facilitar el despliegue y la administración del entorno.

## Tecnologías Usadas

- **Spring Boot**: Para el desarrollo de los microservicios, proporcionando una estructura robusta y flexible.
- **JPA**: Para la gestión de la persistencia de datos en bases de datos relacionales.
- **Kafka**: Para la comunicación entre servicios mediante eventos asíncronos.
- **Docker**: Para la contenerización de los microservicios, bases de datos y Kafka, facilitando el despliegue y la escalabilidad.
- **Feign Repository**: Para la integración entre microservicios, realizando llamadas a otros servicios REST de forma declarativa.
- **PostgreSQL**: Base de datos relacional utilizada para almacenar la información de los usuarios y cuentas.

## Principios Aplicados

- **Clean Code**: El código fue estructurado de acuerdo a principios de **Clean Code**, asegurando que sea legible, fácil de mantener y que cumpla con las mejores prácticas.
- **Arquitectura de Microservicios**: Se utilizaron microservicios independientes para manejar funcionalidades específicas, promoviendo una arquitectura desacoplada.
- **Command Query Responsibility Segregation (CQRS)**: Aplicado en la gestión de consultas y comandos de manera separada para mejorar el rendimiento y la escalabilidad.
- **Event-Driven Architecture**: Usando **Kafka** como sistema de mensajería asíncrono entre los microservicios, para mejorar la escalabilidad y la resiliencia.
- **Domain-Driven Design (DDD)**: La estructura del código se basó en **DDD** para definir claramente los límites de los contextos y los servicios.

## Estructura del Proyecto


## Funcionalidades

### F1: 

Se desarrolló una funcionalidad para la creación de un cliente, donde el servicio expone un endpoint que permite recibir los datos del cliente, validarlos, y luego persistir la información en la base de datos. Al completar la creación, se genera un evento de **Kafka** para la creación de una cuenta asociada al cliente.

`screenshots/F1.png`

`screenshots/F1.1.png`

`screenshots/F1.2.png`

`screenshots/F1.3.png`

`screenshots/F1.4.png`

`screenshots/F1.5.png`

`screenshots/F1.6.png`


### F2: 

`screenshots/F2.png`


### F3: 

`screenshots/F3.png`

### F4: 

`screenshots/F4.png`

### F5: 

`screenshots/F5.png`

### F6: 

`screenshots/F6.png`

### F7: 

`screenshots/F7.png`


## Despliegue


git clone <url-del-repositorio>
cd <directorio-raiz>
docker-compose -f dev-stack.yaml up -d --build
cd <directorio-del-ms>
docker-compose up -d --build