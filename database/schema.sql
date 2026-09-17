DROP DATABASE IF EXISTS centro_adopcion_tfg;
CREATE DATABASE centro_adopcion_tfg;


-- Tabla de Personas
CREATE TABLE PERSONA (
    identificador SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100), 
    dni VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono1 VARCHAR(20) NOT NULL,
    telefono2 VARCHAR(20),
    fecha_nacimiento DATE NOT NULL,
    calle VARCHAR(150) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    codigo_postal VARCHAR(10) NOT NULL,
    poblacion VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL
);

-- Tabla de Cuestionario
CREATE TABLE CUESTIONARIO (
    id_cuestionario SERIAL PRIMARY KEY,
    tipo_vivienda VARCHAR(100) NOT NULL,
    horas_solo INT NOT NULL,
    tiene_otros_animales BOOLEAN NOT NULL,
    cerca_zonas_verdes BOOLEAN NOT NULL
);

-- Tabla Transacciones de Pago
CREATE TABLE TRANSACCION_PAGO (
    id_transaccion SERIAL PRIMARY KEY,
    token_confirmacion VARCHAR(255) UNIQUE NOT NULL,
    importe NUMERIC(10, 2) NOT NULL,
    fecha_cobro TIMESTAMP NOT NULL,
    tipo_pago VARCHAR(50) CHECK(tipo_pago IN('Apadrinamiento', 'Donacion Puntual', 'Adopcion')) NOT NULL,
    estado VARCHAR(20) CHECK(estado IN('Completado', 'Pendiente', 'Fallido')) NOT NULL,
    id_persona INT NOT NULL,
    CONSTRAINT FK_TRANSACCION_PERSONA 
        FOREIGN KEY (id_persona) REFERENCES PERSONA(identificador) 
        ON DELETE CASCADE
);

-- Tabla del Centro de Adopcion
CREATE TABLE CENTRO_ADOPCION (
    identificador SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    calle VARCHAR(150) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    codigo_postal VARCHAR(10) NOT NULL,
    poblacion VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    email_contacto VARCHAR(150) UNIQUE NOT NULL,
    telefono1 VARCHAR(20) NOT NULL,
    telefono2 VARCHAR(20)
);



-- Tabla Persona Solicitante (Adoptante o Acogedor)
CREATE TABLE SOLICITANTE (
    identificador INT PRIMARY KEY,
    fecha_registro_plataforma DATE NOT NULL,
    estado_verificacion VARCHAR(50) NOT NULL,
    rol_solicitante VARCHAR(20) CHECK(rol_solicitante IN('Adoptante', 'Acogedor', 'Ambos')) NOT NULL,
    id_cuestionario INT UNIQUE NOT NULL, 
    CONSTRAINT FK_SOLICITANTE_PERSONA
    	FOREIGN KEY (identificador) REFERENCES PERSONA(identificador) 
    		ON DELETE CASCADE,
    CONSTRAINT FK_SOLICITANTE_CUESTIONARIO
    	FOREIGN KEY (id_cuestionario) REFERENCES CUESTIONARIO(id_cuestionario)
);


-- Tabla Persona Padrino 
CREATE TABLE PADRINO (
    identificador INT PRIMARY KEY,
    cuota_mensual NUMERIC(10, 2) NOT NULL,
    periodicidad VARCHAR(50) NOT NULL,
    CONSTRAINT FK_PADRINO_PERSONA
    	FOREIGN KEY (identificador) REFERENCES PERSONA(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Persona Empleados
CREATE TABLE PERSONAL (
    id_empleado VARCHAR(50) PRIMARY KEY,
    cargo VARCHAR(100) NOT NULL,
    id_persona INT UNIQUE NOT NULL, 
    CONSTRAINT FK_PERSONAL_PERSONA
    	FOREIGN KEY (id_persona) REFERENCES PERSONA(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Animal
CREATE TABLE ANIMAL (
    identificador SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE, 
    caracter VARCHAR(255) NOT NULL,
    enfermedad VARCHAR(255), 
    estado VARCHAR(20) CHECK(estado IN('Disponible', 'Acogida', 'Adoptado')) NOT NULL DEFAULT 'Disponible', 
    fecha_ingreso DATE NOT NULL,
    id_centro_adopcion INT NOT NULL,
    CONSTRAINT FK_ANIMAL_CENTROADOPCION
    	FOREIGN KEY (id_centro_adopcion) REFERENCES CENTRO_ADOPCION(identificador)
);



-- Tabla Animal Perro
CREATE TABLE PERRO (
    identificador INT PRIMARY KEY,
    raza VARCHAR(100) NOT NULL,
    tamano VARCHAR(50) NOT NULL,
    nivel_energia VARCHAR(50) NOT NULL,
    CONSTRAINT FK_PERRO_ANIMAL
    	FOREIGN KEY (identificador) REFERENCES ANIMAL(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Animal Gato
CREATE TABLE GATO (
    identificador INT PRIMARY KEY,
    raza VARCHAR(100) NOT NULL,
    sociabilidad VARCHAR(100) NOT NULL,
    test_leucemia BOOLEAN NOT NULL,
    CONSTRAINT FK_GATO_ANIMAL
    	FOREIGN KEY (identificador) REFERENCES ANIMAL(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Animal Exótico
CREATE TABLE EXOTICO (
    identificador INT PRIMARY KEY,
    tipo_especie VARCHAR(20) CHECK(tipo_especie IN('Conejo', 'Ave', 'Reptil')) NOT NULL,
    necesidades_clima VARCHAR(255) NOT NULL,
    CONSTRAINT FK_EXOTICO_ANIMAL
    	FOREIGN KEY (identificador) REFERENCES ANIMAL(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Empleado-Centro de Adopcion
CREATE TABLE COLABORA (
    id_empleado VARCHAR(50) NOT NULL,
    id_centro_adopcion INT NOT NULL,
    PRIMARY KEY (id_empleado, id_centro_adopcion),
    CONSTRAINT FK_COLABORA_PERSONAL
    	FOREIGN KEY (id_empleado) REFERENCES PERSONAL(id_empleado) 
    		ON DELETE CASCADE,
    CONSTRAINT FK_COLABORA_CENTROADOPCION
    	FOREIGN KEY (id_centro_adopcion) REFERENCES CENTRO_ADOPCION(identificador) 
    		ON DELETE CASCADE
);


-- Tabla Apadrinamiento
CREATE TABLE APADRINA (
    id_apadrinamiento SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    id_padrino INT NOT NULL,
    id_animal INT NOT NULL,
    CONSTRAINT FK_APADRINA_PADRINO
    	FOREIGN KEY (id_padrino) REFERENCES PADRINO(identificador),
    CONSTRAINT FK_APADRINA_ANIMAL
    	FOREIGN KEY (id_animal) REFERENCES ANIMAL(identificador),
    CONSTRAINT UK_APADRINA UNIQUE (id_padrino, id_animal)
);


-- Tabla Solicitud de Animal
CREATE TABLE SOLICITUD (
    id_solicitud SERIAL PRIMARY KEY,
    id_solicitante INT NOT NULL,
    id_animal INT NOT NULL,
    tipo_tramite VARCHAR(20) CHECK(tipo_tramite IN('Adopcion', 'Acogida')) NOT NULL,
    fecha_solicitud DATE NOT NULL,
    id_centro_adopcion INT NOT NULL,
    CONSTRAINT FK_SOLICITUD_SOLICITANTE
    	FOREIGN KEY (id_solicitante) REFERENCES SOLICITANTE(identificador),
    CONSTRAINT FK_SOLICITUD_ANIMAL
    	FOREIGN KEY (id_animal) REFERENCES ANIMAL(identificador),
    CONSTRAINT FK_SOLICITUD_CENTROADOPCION
    	FOREIGN KEY (id_centro_adopcion) REFERENCES CENTRO_ADOPCION(identificador),
    CONSTRAINT UK_SOLICITUD UNIQUE (id_solicitante, id_animal, tipo_tramite)
);


-- Tabla Historial de Gestiones
CREATE TABLE HISTORIAL_GESTION (
    id_gestion SERIAL PRIMARY KEY,
    fecha_gestion TIMESTAMP NOT NULL,
    estado_gestion VARCHAR(20) CHECK(estado_gestion IN('Pendiente', 'Entrevista', 'Aceptado', 'Denegado')) NOT NULL DEFAULT 'Pendiente',
    id_solicitud INT NOT NULL,
    CONSTRAINT FK_HISTORIAL_GESTION
    	FOREIGN KEY (id_solicitud) REFERENCES SOLICITUD(id_solicitud) 
    		ON DELETE CASCADE
);


-- Tabla Historial de Seguimiento
CREATE TABLE HISTORIAL_SEGUIMIENTO (
    id_seguimiento SERIAL PRIMARY KEY,
    fecha_seguimiento TIMESTAMP NOT NULL,
    tipo_seguimiento VARCHAR(20) CHECK(tipo_seguimiento IN('Foto', 'Vacuna', 'Revisión')) NOT NULL,
    comentarios TEXT,
    id_solicitud INT NOT NULL,
    CONSTRAINT FK_HISTORIAL_SEGUIMIENTO
    	FOREIGN KEY (id_solicitud) REFERENCES SOLICITUD(id_solicitud) 
    		ON DELETE CASCADE
);
