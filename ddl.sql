DROP DATABASE IF EXISTS airport;
CREATE DATABASE airport;
USE airport;

-- Crear tablas sin dependencias primero
CREATE TABLE documenttypes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE countries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE tripulationroles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE airlines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE manufacturers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE statuses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE trips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    trip_date DATE,
    price_trip DOUBLE
);

CREATE TABLE flightfares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(20),
    details TEXT,
    value DOUBLE(7,3)
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    age INT,
    iddocument INT
);

CREATE TABLE cities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    idcountry INT
);

CREATE TABLE airports (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50),
    idcity INT
);

CREATE TABLE gates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    gatenumber VARCHAR(10),
    idairport VARCHAR(5)
);

CREATE TABLE models (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    idmanufacturerid INT
);

CREATE TABLE planes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    plates VARCHAR(30),
    capacity INT,
    fabrication_date DATE,
    id_status INT,
    id_model INT
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    idtripulationroles INT,
    id_employee INT,
    idairline INT,
    idairport VARCHAR(5),
    ingresdate DATE
);

CREATE TABLE revision_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT,
    id_employee INT
);

CREATE TABLE revisions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    revision_date DATE,
    id_plane INT
);

CREATE TABLE flight_connections (
    id INT AUTO_INCREMENT PRIMARY KEY,
    connection_number VARCHAR(20),
    id_trip INT,
    id_plane INT,
    id_airport VARCHAR(5)
);

CREATE TABLE tripcrews (
    idemployees INT,
    idconnection INT,
    PRIMARY KEY (idemployees, idconnection)
);

CREATE TABLE revemploye (
    idemployee INT,
    idrevision INT,
    PRIMARY KEY (idemployee, idrevision)
);

CREATE TABLE tripbooking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    idtrips INT
);

CREATE TABLE tripbookingdetails (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idtripbooking INT,
    idcustomers INT,
    idfares INT
);


-- Agregar claves externas
ALTER TABLE customers
ADD FOREIGN KEY (iddocument) REFERENCES documenttypes(id);

ALTER TABLE cities
ADD FOREIGN KEY (idcountry) REFERENCES countries(id);

ALTER TABLE airports
ADD FOREIGN KEY (idcity) REFERENCES cities(id);

ALTER TABLE gates
ADD FOREIGN KEY (idairport) REFERENCES airports(id);

ALTER TABLE models
ADD FOREIGN KEY (idmanufacturerid) REFERENCES manufacturers(id);

ALTER TABLE planes
ADD FOREIGN KEY (id_status) REFERENCES statuses(id),
ADD FOREIGN KEY (id_model) REFERENCES models(id);

ALTER TABLE employees
ADD FOREIGN KEY (idtripulationroles) REFERENCES tripulationroles(id),
ADD FOREIGN KEY (id_employee) REFERENCES revision_details(id),
ADD FOREIGN KEY (idairline) REFERENCES airlines(id),
ADD FOREIGN KEY (idairport) REFERENCES airports(id);

ALTER TABLE revision_details
ADD FOREIGN KEY (id_employee) REFERENCES employees(id);

ALTER TABLE revisions
ADD FOREIGN KEY (id_plane) REFERENCES planes(id);

ALTER TABLE flight_connections
ADD FOREIGN KEY (id_trip) REFERENCES trips(id),
ADD FOREIGN KEY (id_plane) REFERENCES planes(id),
ADD FOREIGN KEY (id_airport) REFERENCES airports(id);

ALTER TABLE tripcrews
ADD FOREIGN KEY (idemployees) REFERENCES employees(id),
ADD FOREIGN KEY (idconnection) REFERENCES flight_connections(id);

ALTER TABLE revemploye
ADD FOREIGN KEY (idemployee) REFERENCES employees(id),
ADD FOREIGN KEY (idrevision) REFERENCES revisions(id);

ALTER TABLE tripbooking
ADD FOREIGN KEY (idtrips) REFERENCES trips(id);

ALTER TABLE tripbookingdetails
ADD FOREIGN KEY (idtripbooking) REFERENCES tripbooking(id),
ADD FOREIGN KEY (idcustomers) REFERENCES customers(id),
ADD FOREIGN KEY (idfares) REFERENCES flightfares(id);
