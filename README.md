# Servicio de Tareas Pendientes (ToDo) - Práctica 3

Este repositorio contiene la implementación de la Práctica III para la asignatura Taller Transversal I: Programación y Proceso de Información. 

El proyecto consiste en el desarrollo de un pequeño servicio de gestión de tareas (ToDos) aplicando el enfoque TDD (Test-Driven Development) en Java.

## Características del Proyecto

* **Gestión de Tareas:** Permite crear tareas con nombre y fecha límite, marcarlas como completadas y consultar las tareas pendientes.
* **Sistema de Alertas:** Verifica si existen tareas expiradas al realizar operaciones y envía notificaciones por correo electrónico a los contactos de la agenda.
* **Simulación de Componentes:** Utiliza `DBStub` para emular el almacenamiento de datos en memoria y `MailerStub` para simular el envío de correos electrónicos.
* **Pruebas Unitarias y de Integración:** Desarrollado utilizando metodologías guiadas por pruebas con JUnit.

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **Gestor de dependencias:** Maven
* **Testing:** JUnit 5

## Estructura del Proyecto

El código fuente principal se encuentra en `src/main/java`, mientras que la batería de pruebas unitarias y de integración, así como los mocks necesarios, residen en `src/test/java`.
