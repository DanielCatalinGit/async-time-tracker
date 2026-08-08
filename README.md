# ⏱️ Async Time-Tracking Platform | Arquitectura de Fichaje en Tiempo Real

> **Angular 17 | Signals | PrimeNG | Tailwind CSS | Spring Boot**

## 📌 Resumen del Proyecto (Business Case)
Prueba de concepto (MVP) de una plataforma de registro de jornada laboral diseñada para eliminar la fricción del usuario mediante integraciones de mensajería instantánea.

El sistema permite a los empleados registrar su entrada y salida enviando un simple mensaje a través de un Bot, actualizando el panel de control corporativo (Backoffice) de recursos humanos en tiempo real mediante un flujo asíncrono.

---

## 🏗️ Diseño de la Arquitectura

### Fase 1: MVP (Estado Actual)
Para validar la interfaz y el flujo de datos sin incurrir en costes de infraestructura, el sistema actual implementa la siguiente arquitectura de validación:

*   **Proxy de Mensajería:** Integración de Webhooks con Telegram Bot API para simular el tráfico de entrada.
*   **Backend:** Servicio monolítico en Java Spring Boot que expone una API RESTful y procesa los eventos entrantes. Almacenamiento en memoria (H2) para facilitar la portabilidad y ejecución local.
*   **Frontend (Panel de Control):** SPA construida con Angular 17, manejando la reactividad global y local de los componentes mediante **Signals**. Interfaz limpia y responsive maquetada con **Tailwind CSS** y tablas de datos avanzadas proporcionadas por **PrimeNG**.

### Fase 2: Producción & Escalabilidad (Roadmap)
El código base está diseñado aplicando principios SOLID y Arquitectura Hexagonal para permitir una evolución sin fricción hacia un entorno productivo de alta concurrencia (picos de peticiones a las 08:00 AM y 09:00 AM):

*   **Sustitución de API:** Migración transparente del adaptador de Telegram a WhatsApp Business Cloud API.
*   **Tolerancia a Fallos:** Introducción de un clúster de Apache Kafka / RabbitMQ para encolar las peticiones de fichaje masivas y evitar saturación en la escritura de la base de datos.
*   **Persistencia y Microservicios:** Migración a base de datos relacional (PostgreSQL) y separación del módulo de notificaciones y el módulo de generación de informes oficiales.

---

## 💻 Stack Tecnológico Principal

### Frontend (Client-Side)
*   **Framework:** Angular 17 (Standalone Components)
*   **Gestión de Estado:** Signals *(Sustituyendo flujos complejos de RxJS para una actualización más granular y eficiente del DOM)*
*   **UI / UX:** PrimeNG (Tablas dinámicas, paginación, filtros) + Tailwind CSS (Utilidades rápidas y diseño responsive)
*   **Lenguaje:** TypeScript

### Backend (Server-Side)
*   **Core:** Java Spring Boot
*   **Arquitectura:** API RESTful, Webhooks
*   **Persistencia (MVP):** H2 Database

---

## 🚀 Cómo ejecutar el proyecto en local

**1. Clonar el repositorio:**
```bash
git clone [https://github.com/DanielCatalinGit/async-time-tracker.git](https://github.com/DanielCatalinGit/async-time-tracker.git)
