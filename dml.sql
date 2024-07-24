-- Tabla documenttype
INSERT INTO documenttype (name) VALUES ('Identification Card');
INSERT INTO documenttype (name) VALUES ('identity Card');
INSERT INTO documenttype (name) VALUES ('Passport');
INSERT INTO documenttype (name) VALUES ('Foreign ID');
INSERT INTO documenttype (name) VALUES ('Drivers License');


-- Tabla country
INSERT INTO country (name) VALUES ('Colombia');
INSERT INTO country (name) VALUES ('United States');
INSERT INTO country (name) VALUES ('Brazil');
INSERT INTO country (name) VALUES ('Argentina');
INSERT INTO country (name) VALUES ('México');

-- Tabla city
INSERT INTO city (name, idCountry) VALUES ('Bogotá', 1);
INSERT INTO city (name, idCountry) VALUES ('Medellín', 1);
INSERT INTO city (name, idCountry) VALUES ('Miami', 2);
INSERT INTO city (name, idCountry) VALUES ('São Paulo', 3);
INSERT INTO city (name, idCountry) VALUES ('Buenos Aires', 4);

-- Tabla airline
INSERT INTO airline (name) VALUES ('Avianca');
INSERT INTO airline (name) VALUES ('Latam');
INSERT INTO airline (name) VALUES ('American Airlines');
INSERT INTO airline (name) VALUES ('Copa Airlines');
INSERT INTO airline (name) VALUES ('Viva Air');

-- Tabla tripulationroles
INSERT INTO tripulationroles (name) VALUES ('Pilot');
INSERT INTO tripulationroles (name) VALUES ('Co-pilot');
INSERT INTO tripulationroles (name) VALUES ('Flight attendant');
INSERT INTO tripulationroles (name) VALUES ('Maintenance');
INSERT INTO tripulationroles (name) VALUES ('Security');


-- Tabla manufacturer
INSERT INTO manufacturer (name) VALUES ('Airbus');
INSERT INTO manufacturer (name) VALUES ('Boeing');
INSERT INTO manufacturer (name) VALUES ('Embraer');
INSERT INTO manufacturer (name) VALUES ('Bombardier');
INSERT INTO manufacturer (name) VALUES ('Cessna');

-- Tabla model
INSERT INTO model (name, manufacturerId) VALUES ('A320', 1);
INSERT INTO model (name, manufacturerId) VALUES ('737', 2);
INSERT INTO model (name, manufacturerId) VALUES ('E195', 3);
INSERT INTO model (name, manufacturerId) VALUES ('CRJ700', 4);
INSERT INTO model (name, manufacturerId) VALUES ('Citation X', 5);

-- Tabla statusA
INSERT INTO statusA (name) VALUES ('On Flight');
INSERT INTO statusA (name) VALUES ('Avalaible');
INSERT INTO statusA (name) VALUES ('On Repair');
INSERT INTO statusA (name) VALUES ('Scheduled Maintenance');
INSERT INTO statusA (name) VALUES ('Out of Service');

-- Tabla airport
INSERT INTO airport (name, idCity) VALUES ('El Dorado', 1);
INSERT INTO airport (name, idCity) VALUES ('José María Córdova', 2);
INSERT INTO airport (name, idCity) VALUES ('Miami International', 3);
INSERT INTO airport (name, idCity) VALUES ('Guarulhos', 4);
INSERT INTO airport (name, idCity) VALUES ('Ezeiza', 5);

-- Tabla gate
INSERT INTO gate (gateNumber, idAirport) VALUES ('A1', 1);
INSERT INTO gate (gateNumber, idAirport) VALUES ('B2', 2);
INSERT INTO gate (gateNumber, idAirport) VALUES ('C3', 3);
INSERT INTO gate (gateNumber, idAirport) VALUES ('D4', 4);
INSERT INTO gate (gateNumber, idAirport) VALUES ('E5', 5);

-- Tabla trip
INSERT INTO trip (tripDate, priceTrip, idOrigin, idDestination) VALUES ('2024-07-15', 200000, 1, 2);
INSERT INTO trip (tripDate, priceTrip, idOrigin, idDestination) VALUES ('2024-07-16', 250000, 3, 1);
INSERT INTO trip (tripDate, priceTrip, idOrigin, idDestination) VALUES ('2024-07-17', 300000, 4, 5);
INSERT INTO trip (tripDate, priceTrip, idOrigin, idDestination) VALUES ('2024-07-18', 350000, 2, 3);
INSERT INTO trip (tripDate, priceTrip, idOrigin, idDestination) VALUES ('2024-07-19', 400000, 5, 4);

-- ALTER TABLE trip AUTO_INCREMENT = 6;
-- UPDATE trip SET id = 5 where id = 12;

-- Tabla tripbooking
INSERT INTO tripbooking (date, idTrip) VALUES ('2024-07-01', 1);
INSERT INTO tripbooking (date, idTrip) VALUES ('2024-07-02', 2);
INSERT INTO tripbooking (date, idTrip) VALUES ('2024-07-03', 3);
INSERT INTO tripbooking (date, idTrip) VALUES ('2024-07-04', 4);
INSERT INTO tripbooking (date, idTrip) VALUES ('2024-07-05', 5);
-- ALTER TABLE tripbooking AUTO_INCREMENT = 1;

-- Tabla flightfare
INSERT INTO flightfare (description, details, value) VALUES ('Economy', 'Economy class fare', 100.000);
INSERT INTO flightfare (description, details, value) VALUES ('Business', 'Business class fare', 200.000);
INSERT INTO flightfare (description, details, value) VALUES ('First Class', 'First class fare', 300.000);
INSERT INTO flightfare (description, details, value) VALUES ('Premium Economy', 'Premium economy class fare', 150.000);
INSERT INTO flightfare (description, details, value) VALUES ('Basic', 'Basic fare with hand luggage', 50.000);

-- Tabla customer
INSERT INTO customer (firstName, lastName, age, nroIdc, idDocument) VALUES ('Juan', 'Pérez', 30, 123456, 1);
INSERT INTO customer (firstName, lastName, age, nroIdc, idDocument) VALUES ('María', 'González', 25, 234567, 2);
INSERT INTO customer (firstName, lastName, age, nroIdc, idDocument) VALUES ('Carlos', 'Ramírez', 40, 345678, 3);
INSERT INTO customer (firstName, lastName, age, nroIdc, idDocument) VALUES ('Ana', 'Torres', 35, 456789, 4);
INSERT INTO customer (firstName, lastName, age, nroIdc, idDocument) VALUES ('Luis', 'Martínez', 28, 567890, 1);
-- ALTER TABLE customer  AUTO_INCREMENT = 2;

-- Tabla tripbookingdetail
INSERT INTO tripbookingdetail (idTripBooking, idCustomers, idFares, s) VALUES (1, 1, 1, 'active');
INSERT INTO tripbookingdetail (idTripBooking, idCustomers, idFares, s) VALUES (2, 2, 2, 'active');
INSERT INTO tripbookingdetail (idTripBooking, idCustomers, idFares, s) VALUES (3, 3, 3, 'active');
INSERT INTO tripbookingdetail (idTripBooking, idCustomers, idFares, s) VALUES (4, 4, 4, 'active');
INSERT INTO tripbookingdetail (idTripBooking, idCustomers, idFares, s) VALUES (5, 5, 5, 'active');
-- ALTER TABLE tripbookingdetail  AUTO_INCREMENT = 1;



-- Tabla passenger
-- ALTER TABLE passenger  AUTO_INCREMENT = 1;
INSERT INTO passenger (name, lastName, nroId, age, seat, idDocument, idTripBookingDetails) VALUES ('Andrés', 'López', 678901, 31, 5, 1, 1);
INSERT INTO passenger (name, lastName, nroId, age, seat, idDocument, idTripBookingDetails) VALUES ('Gabriela', 'Moreno', 789012, 29, 6, 2, 2);
INSERT INTO passenger (name, lastName, nroId, age, seat, idDocument, idTripBookingDetails) VALUES ('Felipe', 'Méndez', 890123, 45, 7, 3, 3);
INSERT INTO passenger (name, lastName, nroId, age, seat, idDocument, idTripBookingDetails) VALUES ('Isabella', 'Rojas', 901234, 27, 8, 4, 4);
INSERT INTO passenger (name, lastName, nroId, age, seat, idDocument, idTripBookingDetails) VALUES ('Ricardo', 'Vargas', 123456, 34, 9, 5, 5);

-- Tabla plane
-- ALTER TABLE plane  AUTO_INCREMENT = 1;
INSERT INTO plane (plates, capacity, fabricationDate, idAirline, idStatus, idModel) VALUES ('HK-4546', 150, '2001-11-05', 1, 2, 1);
INSERT INTO plane (plates, capacity, fabricationDate, idAirline, idStatus, idModel) VALUES ('HK-7890', 200, '2010-05-15', 2, 1, 2);
INSERT INTO plane (plates, capacity, fabricationDate, idAirline, idStatus, idModel) VALUES ('HK-1234', 180, '2015-03-20', 3, 3, 3);
INSERT INTO plane (plates, capacity, fabricationDate, idAirline, idStatus, idModel) VALUES ('HK-5678', 220, '2018-07-25', 4, 2, 4);
INSERT INTO plane (plates, capacity, fabricationDate, idAirline, idStatus, idModel) VALUES ('HK-9876', 160, '2020-02-10', 5, 1, 5);

-- Tabla flightconnection
-- ALTER TABLE flightconnection  AUTO_INCREMENT = 6;
INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES ('FC-001', 1, 1, 1);
INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES ('FC-002', 2, 2, 2);
INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES ('FC-003', 3, 3, 3);
INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES ('FC-004', 4, 4, 4);
INSERT INTO flightconnection (connectionNumber, idTrip, idPlane, idAirport) VALUES ('FC-005', 5, 5, 5);


-- Tabla revision
-- ALTER TABLE revision  AUTO_INCREMENT = 1;
INSERT INTO revision (revisionDate, idPlane, description) VALUES ('2024-06-01', 1, 'General maintenance check');
INSERT INTO revision (revisionDate, idPlane, description) VALUES ('2024-06-15', 2, 'Review of electrical systems');
INSERT INTO revision (revisionDate, idPlane, description) VALUES ('2024-06-20', 3, 'Engine overhaul');
INSERT INTO revision (revisionDate, idPlane, description) VALUES ('2024-06-25', 4, 'Structure and fuselage review');
INSERT INTO revision (revisionDate, idPlane, description) VALUES ('2024-06-30', 5, 'Hydraulic systems review');

-- Tabla roles
 -- ALTER TABLE roles  AUTO_INCREMENT = 1;
INSERT INTO roles (name_role) VALUES ('Systems administrator');
INSERT INTO roles (name_role) VALUES ('Maintenance technician');
INSERT INTO roles (name_role) VALUES ('sales agent');
INSERT INTO roles (name_role) VALUES ('Customer');

-- Tabla employee
-- ALTER TABLE employee  AUTO_INCREMENT = 1;
INSERT INTO employee (name, ingressDate, idRol, idUserRole, idAirline, idAirport, email, password) 
VALUES ('Jorge', '2020-01-15', 1, 1, 1, 1, 'admin@example.com', 'password123');

INSERT INTO employee (name, ingressDate, idRol, idUserRole, idAirline, idAirport, email, password) 
VALUES ('Lucía', '2018-03-10', 2, 2, 2, 2, 'tech@example.com', 'password123');

INSERT INTO employee (name, ingressDate, idRol, idUserRole, idAirline, idAirport, email, password) 
VALUES ('Marcos', '2019-05-20', 3, 3, 3, 3, 'sales@example.com', 'password123');

INSERT INTO employee (name, ingressDate, idRol, idUserRole, idAirline, idAirport, email, password) 
VALUES ('Elena', '2021-07-25', 4, 4, 4, 4, 'customer@example.com', 'password123');

INSERT INTO employee (name, ingressDate, idRol, idUserRole, idAirline, idAirport, email, password) 
VALUES ('Fernando', '2017-09-30', 5, 1, 5, 5, 'fernando@example.com', 'password123');


-- Tabla revemployee
 -- ALTER TABLE revemployee  AUTO_INCREMENT = 1;
INSERT INTO revemployee (idRevision, idEmployee) VALUES (1, 1);
INSERT INTO revemployee (idRevision, idEmployee) VALUES (2, 2);
INSERT INTO revemployee (idRevision, idEmployee) VALUES (3, 3);
INSERT INTO revemployee (idRevision, idEmployee) VALUES (4, 4);
INSERT INTO revemployee (idRevision, idEmployee) VALUES (5, 5);

-- Tabla tripcrew
 -- ALTER TABLE tripcrew  AUTO_INCREMENT = 1;
INSERT INTO tripcrew (idEmployees, idConection) VALUES (1, 1);
INSERT INTO tripcrew (idEmployees, idConection) VALUES (2, 2);
INSERT INTO tripcrew (idEmployees, idConection) VALUES (3, 3);
INSERT INTO tripcrew (idEmployees, idConection) VALUES (4, 4);
INSERT INTO tripcrew (idEmployees, idConection) VALUES (5, 5);

-- tabla permissions
INSERT INTO permissions (permissions_name) VALUES ('Register Plane');
INSERT INTO permissions (permissions_name) VALUES ('Assign Crew to Route');
INSERT INTO permissions (permissions_name) VALUES ('Create Flight Reservation');
INSERT INTO permissions (permissions_name) VALUES ('Register Maintenance Review');
INSERT INTO permissions (permissions_name) VALUES ('Consult Customer Information');
INSERT INTO permissions (permissions_name) VALUES ('Consult Flight Reservation');
INSERT INTO permissions (permissions_name) VALUES ('Register Customer');
INSERT INTO permissions (permissions_name) VALUES ('Consult Plane Information');
INSERT INTO permissions (permissions_name) VALUES ('Consult Route Information');
INSERT INTO permissions (permissions_name) VALUES ('Register Airport');
INSERT INTO permissions (permissions_name) VALUES ('Consult Airport Information');
INSERT INTO permissions (permissions_name) VALUES ('Consult Plane Maintenance History');
INSERT INTO permissions (permissions_name) VALUES ('Update Customer Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Flight Reservation');
INSERT INTO permissions (permissions_name) VALUES ('Update Plane Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Plane');
INSERT INTO permissions (permissions_name) VALUES ('Assign Plane to Route');
INSERT INTO permissions (permissions_name) VALUES ('Update Route Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Route');
INSERT INTO permissions (permissions_name) VALUES ('Update Airport Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Airport');
INSERT INTO permissions (permissions_name) VALUES ('List All Customers');
INSERT INTO permissions (permissions_name) VALUES ('Consult Flight Information');
INSERT INTO permissions (permissions_name) VALUES ('Update Maintenance Review Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Maintenance Review');
INSERT INTO permissions (permissions_name) VALUES ('Consult Crew Assignment');
INSERT INTO permissions (permissions_name) VALUES ('Consult Route Stops');
INSERT INTO permissions (permissions_name) VALUES ('Update Stop Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Stop');
INSERT INTO permissions (permissions_name) VALUES ('Register Flight Fare');
INSERT INTO permissions (permissions_name) VALUES ('Update Flight Fare Information');
INSERT INTO permissions (permissions_name) VALUES ('Delete Flight Fare');
INSERT INTO permissions (permissions_name) VALUES ('Consult Flight Fare');
INSERT INTO permissions (permissions_name) VALUES ('Register Document Type');
INSERT INTO permissions (permissions_name) VALUES ('Update Document Type');
INSERT INTO permissions (permissions_name) VALUES ('Delete Document Type');
INSERT INTO permissions (permissions_name) VALUES ('Consult Document Type');
INSERT INTO permissions (permissions_name) VALUES ('Search Flights');
INSERT INTO permissions (permissions_name) VALUES ('Select Flight');
INSERT INTO permissions (permissions_name) VALUES ('Add Passengers');
INSERT INTO permissions (permissions_name) VALUES ('Select Seats');
INSERT INTO permissions (permissions_name) VALUES ('Make Payment');
INSERT INTO permissions (permissions_name) VALUES ('List Flight Reservation'); -- is repeat
INSERT INTO permissions (permissions_name) VALUES ('Cancel Flight Reservation');
INSERT INTO permissions (permissions_name) VALUES ('Modify Flight Reservation');


-- Avión
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 1); -- Register Plane
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 8); -- Consult Plane Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 8); -- Consult Plane Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 12); -- Consult Plane Maintenance History
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 12); -- Consult Plane Maintenance History
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 15); -- Update Plane Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 15); -- Update Plane Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 16); -- Delete Plane

-- Aeropuerto
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 10); -- Register Airport
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 11); -- Consult Airport Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 20); -- Update Airport Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 21); -- Delete Airport

-- Tripulación
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 2); -- Assign Crew to Route
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 26); -- Consult Crew Assignment

-- Cliente
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 5); -- Consult Customer Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 7); -- Register Customer
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 13); -- Update Customer Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 22); -- List All Customers

-- Vuelo y Reserva
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 3); -- Create Flight Reservation
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 6); -- Consult Flight Reservation
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 14); -- Delete Flight Reservation
INSERT INTO role_permissions (role_id, permissions_id) VALUES (3, 23); -- Consult Flight Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 38); -- Search Flights
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 39); -- Select Flight
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 40); -- Add Passengers
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 41); -- Select Seats
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 42); -- Make Payment
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 43); -- List Flight Reservation 
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 44); -- Cancel Flight Reservation
INSERT INTO role_permissions (role_id, permissions_id) VALUES (4, 45); -- Modify Flight Reservation

-- Mantenimiento
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 4); -- Register Maintenance Review
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 24); -- Update Maintenance Review Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (2, 25); -- Delete Maintenance Review

-- Trayecto
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 9); -- Consult Route Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 17); -- Assign Plane to Route
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 18); -- Update Route Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 19); -- Delete Route
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 27); -- Consult Route Stops
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 28); -- Update Stop Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 29); -- Delete Stop

-- Tarifas y Documentos
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 30); -- Register Flight Fare
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 31); -- Update Flight Fare Information
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 32); -- Delete Flight Fare
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 33); -- Consult Flight Fare
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 34); -- Register Document Type
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 35); -- Update Document Type
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 36); -- Delete Document Type
INSERT INTO role_permissions (role_id, permissions_id) VALUES (1, 37); -- Consult Document Type
