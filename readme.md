# 🚗 SystemCarMotor

**SystemCarMotor** es un sistema integral para la gestión de un taller automotriz, desarrollado en Java con Swing y MySQL. Permite registrar, visualizar, buscar, actualizar y eliminar vehículos, además de gestionar el inventario, clientes, proveedores y servicios técnicos.

## ✅ Funcionalidades actuales

- Registro de vehículos.
- Búsqueda de vehículos por placa.
- Visualización general de vehículos.
- Actualización de datos del vehículo (placa, tipo, modelo, marca, cliente).
- Eliminación de vehículos.
- Conexión a base de datos MySQL usando patrón Singleton.
- Patrón DAO aplicado para la gestión de `Vehiculo`.
- Arquitectura modular por componente (MVC por módulo).
- Uso de `JTabbedPane` para segmentar funcionalidades (Registrar, Ver, Buscar, Eliminar, Actualizar).

## 📂 Estructura del proyecto
```
com.mycompany.systemcarmotor
├── model # Clases de entidad (Vehiculo, Cliente, etc.)
├── modelDAO # DAO para acceso a datos (VehiculoDAO, etc.)
├── services # Lógica de negocio (VehiculoService)
├── controllers # Coordinadores entre UI y lógica (VehiculoController)
├── util # Conexión DB (DatabaseConnection con patrón Singleton)
└── view # Interfaz Swing (JFrame principal y paneles)
```

## 🛠️ Tecnologías utilizadas

- **Java** (versión 17)
- **Swing** (Java GUI)
- **MySQL** (base de datos local)
- **NetBeans** como entorno de desarrollo
- **Patrones aplicados**: Singleton, DAO, (Builder y Factory en otros módulos)

## 📦 Dependencias necesarias

- MySQL JDBC Driver (ya incluido en NetBeans si se configura bien el proyecto)
- Base de datos local llamada `CarMotors` con tabla `Vehiculos`

## 📝 Notas

- Los registros deben tener una placa única.
- La placa original se utiliza para permitir actualizaciones sin conflicto.
- A futuro se conectarán módulos de clientes, repuestos, órdenes y facturación.
