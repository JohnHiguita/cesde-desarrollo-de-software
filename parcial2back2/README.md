Prueba Técnica – Abstracción básica y creación de objetos en Java

📌 Descripción

El Cinema Nova requiere un backend mínimo para registrar su información base: cines, sus detalles y sus salas.

El proyecto contiene:

Modelos:

    a. Cine
    b. DetalleCine
    c. Sala

Cada uno con sus atributos, constructores y métodos básicos.

**Repositorios:** Un repositorio por cada modelo (CineRepository, DetalleCineRepository, SalaRepository), 
cada uno con al menos una consulta personalizada.

**DTO + Mapper:** Se incluye un CineDTO junto a un @Mapper (MapStruct) para transformar entidades en DTOs.

**Servicios:** Se implementan tres servicios (CineService, DetalleCineService, SalaService), encargados de
la operación Guardar para cada entidad.

**Configuración:** Proyecto Maven con pom.xml que contiene todas las dependencias necesarias.

**Nota:** El proyecto no cuenta con controlador (solo capa de servicios y repositorios).

⚙️ **Instalación**

1. Clonar el repositorio:

git clone https://github.com/JohnHiguita/parcial2back2.git
cd parcial2back2

2. Compilar el proyecto:

mvn clean install

3. Ejecutar la aplicación:

Como no hay controlador ni endpoints, la aplicación sólo se levanta como backend base:

mvn spring-boot:run

🚀 Uso

Actualmente, el proyecto funciona como base de backend. Se pueden realizar pruebas de los 
servicios y repositorios mediante:

5. 

Unit tests / Integration tests:
Ejecutar los tests incluidos con:

mvn test

Ejemplo de creación de un Cine desde el servicio (pseudo-código)

Cine cine = new Cine("Cinema Nova", "Medellín");
cineService.guardar(cine);

DetalleCine detalle = new DetalleCine("Av. Siempre Viva 123", "3011234567", cine);
detalleCineService.guardar(detalle);

Sala sala = new Sala("Sala 1", 120, cine);
salaService.guardar(sala);

Esto almacenará la información en la base de datos configurada.

Requisitos: Java, Spring Boot. Maven Dependencies

6. Al finalizar realiza un pull request con la solución.


Autor: John Higuita Mejía