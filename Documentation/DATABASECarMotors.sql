-- Creación de la base de datos
DROP DATABASE IF EXISTS CarMotors;
CREATE DATABASE CarMotors;
USE CarMotors;

-- Tabla para Estados de Repuestos
CREATE TABLE EstadoRepuesto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre ENUM('Disponible', 'Reservado', 'Fuera de servicio') NOT NULL
);

-- Tabla para Estados de Servicios
CREATE TABLE EstadoServicio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre ENUM('Pendiente', 'En proceso', 'Completado', 'Entregado') NOT NULL
);
CREATE TABLE Calificacion (
    ID INT PRIMARY KEY,
    Puntualidad INT,
    Calidad ENUM('normal', 'buena'),
    Costo ENUM('barato', 'estandar', 'elevado')
);
-- Tabla para Proveedores
CREATE TABLE Proveedores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    frecuencia_suministro ENUM('Semanal', 'Quincenal', 'Mensual', 'Otro') DEFAULT 'Mensual',
    idCalificacion int,
    foreign key(idCalificacion) references Calificacion(ID)
);



-- Tabla para Repuestos
CREATE TABLE Repuestos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('Mecánico', 'Eléctrico', 'Carrocería', 'Consumo') NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    cantidad INT NOT NULL DEFAULT 0,
    fecha_ingreso DATE NOT NULL,
    vida_util_estimada INT,
    id_estado INT,
    id_proveedor INT,
    FOREIGN KEY (id_estado) REFERENCES EstadoRepuesto(id),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id)
);

-- Tabla para Lotes (Trazabilidad)
CREATE TABLE Lotes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_repuesto INT,
    id_proveedor INT,
    fecha_ingreso DATE NOT NULL,
    fecha_caducidad DATE,
    cantidad INT NOT NULL,
    FOREIGN KEY (id_repuesto) REFERENCES Repuestos(id),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id)
);

-- Tabla para Clientes
CREATE TABLE Clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    identificacion VARCHAR(13) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(13),
    correo VARCHAR(50),
    direccion VARCHAR(50),
    proximaVisita DATE
);

-- Tabla para Vehículos
CREATE TABLE Vehiculos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) UNIQUE NOT NULL,
    tipo ENUM('Automóvil', 'SUV', 'Motocicleta', 'Camión', 'Otro') NOT NULL,
    modelo VARCHAR(50),
    marca VARCHAR(50),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id) ON DELETE CASCADE
);

-- tabla compatibilidad

CREATE TABLE Compatibilidad (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    idRepuesto INT,
    idVehiculo INT,
    FOREIGN KEY (idRepuesto) REFERENCES Repuestos(ID),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculos(ID)
);

-- Tabla para Técnicos
CREATE TABLE Tecnicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100)
);

-- Tabla: TipoMantenimiento
CREATE TABLE TipoMantenimiento (
    id INT PRIMARY KEY,
    tipo ENUM('Preventivo', 'Correctivo', 'Programado'),
    subTipo VARCHAR(50)
);

-- tabla mantenimiento Programado
CREATE TABLE Mantenimiento_Programado (
id INT PRIMARY KEY AUTO_INCREMENT,
idVehiculo int, 
estado varchar(100),
fecha_Programada date, 
id_Tipo_Mantenimiento int,
FOREIGN KEY (idVehiculo) REFERENCES Vehiculos(id),
FOREIGN KEY (id_Tipo_Mantenimiento) REFERENCES TipoMantenimiento(id)
);

-- Tabla para Campañas de Mantenimiento
CREATE TABLE Campanas_Mantenimiento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    descuento DECIMAL(5,2),
    id_Tipo_Mantenimiento int,
    FOREIGN KEY (id_Tipo_Mantenimiento) REFERENCES TipoMantenimiento(id)
);


-- Tabla para Servicios
CREATE TABLE Servicios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(500) NOT NULL,
    tiempo_estimado TIME,
    id_vehiculo INT,
    id_estado INT,
    orden_entrega TEXT,
    id_Tipo_Mantenimiento INT,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_estado) REFERENCES EstadoServicio(id),
    FOREIGN KEY (id_Tipo_Mantenimiento) REFERENCES TipoMantenimiento(id)
);

-- Tabla: Mano_de_obra
CREATE TABLE Mano_de_obra (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100),
    tarifaHora DECIMAL(10,2),
    idTecnico INT,
    idServicio INT,
    FOREIGN KEY (idTecnico) REFERENCES Tecnicos(ID),
    FOREIGN KEY (idServicio) REFERENCES Servicios(ID)
);


-- Tabla para Uso de Repuestos en Servicios (Trazabilidad)
CREATE TABLE Uso_Repuestos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_servicio INT,
    id_repuesto INT,
    id_lote INT,
    cantidad_usada INT NOT NULL,
    FOREIGN KEY (id_servicio) REFERENCES Servicios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_repuesto) REFERENCES Repuestos(id),
    FOREIGN KEY (id_lote) REFERENCES Lotes(id)
);

-- Tabla para Descuentos (Fidelización)
CREATE TABLE Descuentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    descripcion VARCHAR(200),
    porcentaje DECIMAL(5,2),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id) ON DELETE CASCADE
);

-- Tabla para Información del Taller
CREATE TABLE TallerInformacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_taller VARCHAR(50) NOT NULL,
    razon_social VARCHAR(50) NOT NULL,
    nit VARCHAR(13) NOT NULL,
    direccion VARCHAR(50),
    telefono VARCHAR(13)
);

-- Tabla para Facturas
CREATE TABLE Facturas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    n_factura INT UNIQUE NOT NULL,
    fecha DATE NOT NULL,
    cufe VARCHAR(100),
    qr TEXT,
    subtotal DECIMAL(10,2) NOT NULL,
    impuestos DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_cliente INT,
    id_servicio INT,
    id_TallerInformacion INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id) ON DELETE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES Servicios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_TallerInformacion) REFERENCES TallerInformacion(id)
);


-- Tabla para Detalles de Órdenes de Compra
CREATE TABLE Ordenes_Compra (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_repuesto INT,
    id_proveedor INT,
    cantidad INT NOT NULL,
    fecha_solicitud DATE NOT NULL,
    estado ENUM('Pendiente', 'Enviada', 'Recibida', 'Cancelada') DEFAULT 'Pendiente',
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id),
    FOREIGN KEY (id_repuesto) REFERENCES Repuestos(id)
);



-- Tabla para Inspecciones Técnicas
CREATE TABLE Inspecciones_Tecnicas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_vehiculo INT,
    fecha_inspeccion DATE NOT NULL,
    resultado ENUM('Aprobado', 'Reparaciones necesarias', 'Rechazado') NOT NULL,
    observaciones TEXT,
    proxima_revision DATE,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculos(id) ON DELETE CASCADE
);

-- Índices para mejorar rendimiento
CREATE INDEX idx_repuesto_estado ON Repuestos(id_estado);
CREATE INDEX idx_servicio_estado ON Servicios(id_estado);
CREATE INDEX idx_cliente_identificacion ON Clientes(identificacion);
CREATE INDEX idx_vehiculo_placa ON Vehiculos(placa);
CREATE INDEX idx_factura_nfactura ON Facturas(n_factura);

-- reporte producividad 
CREATE VIEW Reporte_Productividad_Tecnicos AS
SELECT 
    t.id,
    t.nombre,
    t.especialidad,
    COUNT(mo.id) AS servicios_completados,
    AVG(TIME_TO_SEC(s.tiempo_estimado) / 3600) AS tiempo_promedio_horas
FROM Tecnicos t
LEFT JOIN Mano_de_obra mo ON t.id = mo.idTecnico
LEFT JOIN Servicios s ON mo.idServicio = s.id
LEFT JOIN EstadoServicio es ON s.id_estado = es.id
WHERE es.nombre = 'Completado'
GROUP BY t.id, t.nombre, t.especialidad;

-- reporte servicios
CREATE VIEW Reporte_Servicios AS
SELECT 
    s.id,
    s.descripcion,
    s.tiempo_estimado,
    tm.tipo AS tipo_mantenimiento,
    tm.subTipo AS subtipo_mantenimiento,
    v.placa,
    v.marca,
    v.modelo,
    es.nombre AS estado,
    c.nombre AS cliente_nombre,
    c.apellido AS cliente_apellido
FROM Servicios s
JOIN Vehiculos v ON s.id_vehiculo = v.id
JOIN EstadoServicio es ON s.id_estado = es.id
JOIN TipoMantenimiento tm ON s.id = tm.id
JOIN Clientes c ON v.id_cliente = c.id;

