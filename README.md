# Scooter Rental Microservices Platform

## Language Options

- [English](#english)
- [Español](#español)
- [Italiano](#italiano)

<a name="english"></a>

# English

## Project Overview

This project implements a scooter rental system using a microservices architecture built with Spring Boot. The platform allows users to rent electric scooters, track their journeys, manage scooter maintenance, and handle scooter stations/stops throughout a city.

## Project Structure

The project is organized into the following microservices:

### 1. User Service (microservicio_Usuario_Service)

- Manages user registration, authentication, and authorization
- Handles user profiles, roles, and permissions
- Stores user account information and payment methods
- Provides APIs for user management and authentication

### 2. Scooters Service (microservicio_Monopatines)

- Manages the scooter fleet inventory
- Tracks scooter status, location, and battery levels
- Handles scooter activation and deactivation
- Provides APIs for scooter availability and status updates

### 3. Travel Service (microservicio_Viajes)

- Records and manages user journeys/trips
- Calculates trip costs based on duration and distance
- Handles trip start and end operations
- Provides trip history and statistics

### 4. Stop Service (microservicio_Parada)

- Manages scooter stations/stops across the city
- Tracks capacity and availability at each stop
- Provides location data for stops 
- Handles scooter-to-stop assignment

### 5. Maintenance Log Service (microservicio_LogMantenimiento)

- Tracks scooter maintenance history
- Schedules routine maintenance
- Records repair activities and parts replacement
- Monitors scooter health metrics

## Technologies Used

- **Spring Boot**: Framework for building microservices
- **Spring Cloud**: For microservices coordination
- **Spring Data JPA**: For database access and ORM
- **Spring Security**: For authentication and authorization
- **MySQL**: Database for persistent storage
- **Docker**: For containerization and deployment
- **Docker Compose**: For orchestrating multi-container applications
- **Config Server**: Centralized configuration
- **Maven/Gradle**: Build tools

## Prerequisites

- JDK 11 or higher
- Docker and Docker Compose
- Maven or Gradle
- Git
- Postman or similar tool for API testing
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## How to Run

1. **Clone the repository**
   
   ```
   git clone <repository-url>
   cd scooter-rental-microservices
   ```

2. **Build the microservices**
   
   ```
   ./mvnw clean package -DskipTests
   ```
   
   or with Gradle:
   
   ```
   ./gradlew clean build -x test
   ```

3. **Run with Docker Compose**
   
   ```
   docker-compose up -d
   ```
- Example: http://localhost:8080/api/users, http://localhost:8080/api/scooters

## Basic Architecture

The system follows a typical microservices architecture pattern:

```
[Client Applications]
        |
[API Gateway] ---- [Config Server]
        |               |
[Service Discovery (Eureka)]
        |
--------------------------
|       |       |       |
v       v       v       v
[User  [Scooter [Travel [Stop   [Maintenance
Service] Service] Service] Service] Log Service]
|       |       |       |       |
v       v       v       v       v
[DB]    [DB]    [DB]    [DB]    [DB]
```

<a name="español"></a>

# Español

## Descripción del Proyecto

Este proyecto implementa un sistema de alquiler de patinetes utilizando una arquitectura de microservicios construida con Spring Boot. La plataforma permite a los usuarios alquilar patinetes eléctricos, realizar un seguimiento de sus viajes, gestionar el mantenimiento de los patinetes y administrar las estaciones/paradas de patinetes por toda la ciudad.

## Estructura del Proyecto

El proyecto está organizado en los siguientes microservicios:

### 1. Servicio de Usuarios (microservicio_Usuario_Service)

- Gestiona el registro, autenticación y autorización de usuarios
- Maneja perfiles de usuario, roles y permisos
- Almacena información de cuentas de usuario y métodos de pago
- Proporciona APIs para la gestión y autenticación de usuarios

### 2. Servicio de Patinetes (microservicio_Monopatines)

- Gestiona el inventario de la flota de patinetes
- Realiza seguimiento del estado, ubicación y niveles de batería de los patinetes
- Maneja la activación y desactivación de patinetes
- Proporciona APIs para la disponibilidad y actualizaciones de estado de los patinetes

### 3. Servicio de Viajes (microservicio_Viajes)

- Registra y gestiona los viajes/trayectos de los usuarios
- Calcula los costos de viaje basados en duración y distancia
- Maneja operaciones de inicio y fin de viaje
- Proporciona historial de viajes y estadísticas

### 4. Servicio de Paradas (microservicio_Parada)

- Gestiona las estaciones/paradas de patinetes en toda la ciudad
- Realiza seguimiento de la capacidad y disponibilidad en cada parada
- Proporciona datos de ubicación para las paradas
- Maneja la asignación de patinetes a paradas

### 5. Servicio de Registro de Mantenimiento (microservicio_LogMantenimiento)

- Realiza seguimiento del historial de mantenimiento de patinetes
- Programa mantenimientos rutinarios
- Registra actividades de reparación y reemplazo de piezas
- Monitorea métricas de salud de los patinetes

## Tecnologías Utilizadas

- **Spring Boot**: Framework para construir microservicios
- **Spring Cloud**: Para coordinación de microservicios
- **Spring Data JPA**: Para acceso a base de datos y ORM
- **Spring Security**: Para autenticación y autorización
- **MySQL**: Base de datos para almacenamiento persistente
- **Docker**: Para containerización y despliegue
- **Docker Compose**: Para orquestar aplicaciones multi-contenedor
- **Config Server**: Configuración centralizada
- **Maven/Gradle**: Herramientas de construcción

## Requisitos Previos

- JDK 11 o superior
- Docker y Docker Compose
- Maven o Gradle
- Git
- Postman o herramienta similar para pruebas de API
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Cómo Ejecutar

1. **Clonar el repositorio**
   
   ```
   git clone <url-repositorio>
   cd scooter-rental-microservices
   ```

2. **Construir los microservicios**
   
   ```
   ./mvnw clean package -DskipTests
   ```
   
   o con Gradle:
   
   ```
   ./gradlew clean build -x test
   ```

3. **Ejecutar con Docker Compose**
   
   ```
   docker-compose up -d
   ```
- Ejemplo: http://localhost:8080/api/users, http://localhost:8080/api/scooters

## Arquitectura Básica

El sistema sigue un patrón típico de arquitectura de microservicios:

```
[Aplicaciones Cliente]
        |
[API Gateway] ---- [Config Server]
        |               |
[Descubrimiento de Servicios (Eureka)]
        |
--------------------------
|       |       |       |
v       v       v       v
[Servicio [Servicio [Servicio [Servicio [Servicio de
Usuario] Patinetes] Viajes]  Parada]  Log Mantenimiento]
|       |       |       |       |
v       v       v       v       v
[BD]    [BD]    [BD]    [BD]    [BD]
```

<a name="italiano"></a>

# Italiano

## Panoramica del Progetto

Questo progetto implementa un sistema di noleggio di monopattini utilizzando un'architettura a microservizi costruita con Spring Boot. La piattaforma consente agli utenti di noleggiare monopattini elettrici, tracciare i loro viaggi, gestire la manutenzione dei monopattini e amministrare le stazioni/fermate dei monopattini in tutta la città.

## Struttura del Progetto

Il progetto è organizzato nei seguenti microservizi:

### 1. Servizio Utenti (microservicio_Usuario_Service)

- Gestisce la registrazione, l'autenticazione e l'autorizzazione degli utenti
- Gestisce profili utente, ruoli e permessi
- Memorizza le informazioni dell'account utente e i metodi di pagamento
- Fornisce API per la gestione e l'autenticazione degli utenti

### 2. Servizio Monopattini (microservicio_Monopatines)

- Gestisce l'inventario della flotta di monopattini
- Traccia lo stato, la posizione e i livelli di batteria dei monopattini
- Gestisce l'attivazione e la disattivazione dei monopattini
- Fornisce API per la disponibilità e gli aggiornamenti dello stato dei monopattini

### 3. Servizio Viaggi (microservicio_Viajes)

- Registra e gestisce i viaggi/percorsi degli utenti
- Calcola i costi del viaggio in base a durata e distanza
- Gestisce le operazioni di inizio e fine viaggio
- Fornisce cronologia e statistiche dei viaggi

### 4. Servizio Fermate (microservicio_Parada)

- Gestisce le stazioni/fermate dei monopattini in tutta la città
- Traccia la capacità e la disponibilità in ogni fermata
- Fornisce dati sulla posizione delle fermate
- Gestisce l'assegnazione dei monopattini alle fermate

### 5. Servizio Registro Manutenzione (microservicio_LogMantenimiento)

- Traccia la cronologia di manutenzione dei monopattini
- Programma manutenzioni di routine
- Registra attività di riparazione e sostituzione dei pezzi
- Monitora le metriche di salute dei monopattini

## Tecnologie Utilizzate

- **Spring Boot**: Framework per costruire microservizi
- **Spring Cloud**: Per il coordinamento dei microservizi
- **Spring Data JPA**: Per l'accesso al database e ORM
- **Spring Security**: Per autenticazione e autorizzazione
- **MySQL**: Database per l'archiviazione persistente
- **Docker**: Per la containerizzazione e il deployment
- **Docker Compose**: Per orchestrare applicazioni multi-container
- **Config Server**: Configurazione centralizzata
- **Maven/Gradle**: Strumenti di build

## Prerequisiti

- JDK 11 o superiore
- Docker e Docker Compose
- Maven o Gradle
- Git
- Postman o strumento simile per il test delle API
- IDE (IntelliJ IDEA, Eclipse, VS Code, ecc.)

## Come Eseguire

1. **Clonare il repository**
   
   ```
   git clone <repository-url>
   cd scooter-rental-microservices
   ```

2. **Costruire i microservizi**
   
   ```
   ./mvnw clean package -DskipTests
   ```
   
   o con Gradle:
   
   ```
   ./gradlew clean build -x test
   ```

3. **Eseguire con Docker Compose**
   
   ```
   docker-compose up -d
   ```
- Esempio: http://localhost:8080/api/users, http://localhost:8080/api/scooters

## Architettura di Base

Il sistema segue un tipico modello di architettura a microservizi:

```
[Applicazioni Client]
        |
[API Gateway] ---- [Config Server]
        |
[Descubrimiento de Servicios]
        |
--------------------------
|       |       |       |
v       v       v       v
[Servizio [Servizio [Servizio [Servizio [Servizio 
Utenti] Monopattini] Viaggi]  Fermate]  registro manutenzione]
|       |       |       |       |
v       v       v       v       v
[BD]    [BD]    [BD]    [BD]    [BD]
```
