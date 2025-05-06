# CarMotors - Automotive Workshop Management System


Overview

CarMotors is a Java-based desktop application designed to manage the operations of an automotive workshop. The system handles inventory, maintenance services, client and supplier records, invoicing, and technician assignments. The application is built using Java Swing and follows the MVC architectural pattern, enhanced with design patterns like Singleton, Builder, Factory, State, Strategy, and Facade.

## Features

- Client Management: Register, update, and delete client records.

- Vehicle Management: Assign and manage client vehicles.

- Inventory Management: Register and track spare parts, including batch tracking.

- Maintenance Services: Schedule and record services with type and subtype of maintenance.

- Service Status Tracking: States include Pending, In Process, Completed, and Delivered.

- Technician Productivity Reports: Calculate average service time and total services completed.

- Supplier Management: Register suppliers along with performance ratings.

- Invoicing System: Automatically generates invoices and PDFs with embedded QR codes.

- Discount System: Strategy pattern implementation for dynamic discount calculation.

- Facade Integration: Encapsulates operations such as service execution involving technicians, spare parts usage, and labor costs.

##Architecture

- Language: Java (JDK 17+)

- GUI: Java Swing

- Database: MySQL

- Pattern Used:

- Singleton: For database connection

- Builder: For constructing domain models (Client, Vehicle, Service, Invoice...)

- Factory: For creating Client/Supplier instances

- State: To manage SparePart availability

- Strategy: For discount calculation

- Facade: For unified service processing (technician + labor + spare parts)
Database

## The database 
schema includes the following key tables:

- Clientes, Vehiculos, Repuestos, Lotes, Proveedores, Calificacion

- Servicios, EstadoServicio, TipoMantenimiento, Mano_de_obra, Uso_Repuestos

- Facturas, TallerInformacion, Ordenes_Compra, Inspecciones_Tecnicas

Triggers and views support productivity reports and filtered service queries.

## Setup

- Clone the repository.

- Open the project in NetBeans or IntelliJ.

- Import the SQL schema located in /sql/schema.sql into MySQL.

- Ensure your database connection credentials match those in DatabaseConnection.java.

- Build and run the project.



## Folder Structure

- com.mycompany.systemcarmotor

- view: Swing interfaces

- model: Entity classes

- dao: Data access objects

- controllers: Logic controllers

- services: Business services

- builder, factory, strategy, state, facade: Design pattern implementations
