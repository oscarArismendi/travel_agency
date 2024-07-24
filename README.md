# travel_agency
Integrantes:
Oscar Fernando Arismendi Galvis
Oscar Fabian Mantilla Ochoa

Objetivos:
Desarrollo de consultas SQL eficientes.
Mejora de la estructura de la base de datos
Automatización de procesos
Análisis de datos
Se plantea la siguiente situación:

Vuelos Globales opera vuelos a nivel internacional y cuenta con una flota de aviones, tripulación variada, múltiples aerolíneas asociadas y una vasta red de aeropuertos y ciudades de destino. La empresa requiere una base de datos robusta para gestionar todos los aspectos de su operación, desde la reserva de vuelos hasta el mantenimiento de los aviones y la administración de la tripulación.

Requerimientos de la base de datos suministrada:

1.Registrar avión
2.Tripulación  y trayecto
3.Crear Reserva de vuelo
4.Registrar revisón de mantenimiento
5. Consultar información de cliente
6. Consultar reserva de vuelo
7. Registrar cliente
8. Consultar información de avión
9. Consultar información de trayecto
10. Registrar Aeropuerto
11. Consultar información de aeropuerto
12. Consultar información de revisiones de avión 
13. Actualizar información de cliente
14. Elimminar reserva de vuelo
15. Actualizar información de avión
16. Eliminar avión 
17. Asignar aeronave a trayecto
18. Actualizar información de trayecto
19. Elimminar trayecto
20. Actualizar información de aeropuerto
21. Eliminar aeropuerto
22. Actualizar información de cliente
23. Consultar información de vuelo
24. Actualizar información de revisión
25. Eliminar revisón de mantenimiento
26. Consultar asignación de tripulación
27. Consultar escalas de un trayecto
28. Actualizar información de escala
29. Eliminar escala
30. Registrar tarifa de vuelo
31. Actualizar información de tarifa de vuelo
32. Eliminar tarifa de vuelo 
33. Consultar tarifa de vuelo
34. Registrar tipo de documento
35. Actualizar tipo de documento
36. Eliminar tipo de documento
37. Consultar tipo de documento
38. Buscar vuelos
39. Seleccionar vuelo
40. Añadir pasajero
41. Seleccionar asientos
42. Realizar pagos
43. Consultar reserva de vuelo
44. Cancelar reserva de vuelo 
45. Modificar reserva de vuelo

----------------------------------------------------------------------------------------------------------------------

Base de datos empleada: 

![railway](https://github.com/user-attachments/assets/2e98f04d-db6e-4474-9229-c5fdef87fbcd)

Para llevar a cabo este proyecto el equipo de desarrollo empleó arquitectura hexagonal y vertical slicing:

El proyecto está organizado por actores, los cuales son: Agente de ventas, mantenimiento, administrador del sistema, clientes , donde cada uno tiene un paquete que le corresponde. Adicionalmente, hay un paquete para las clases que no corresponden a un actor en específico llamada "Generals". Así como un paquete para las clases útiles llamado "Shared".


![Hexagonal](https://github.com/user-attachments/assets/b1602ed7-6129-4ca9-9a77-dcb0ddfb2137)

En el menú principal del programa se muestran estos cuatro actores y las acciones que se pueden realizar con cada uno basado en los requerimientos.

![technician menu](https://github.com/user-attachments/assets/c21e45a1-43a2-4d0b-80a6-1414bb8a34d6)
![System admin menu](https://github.com/user-attachments/assets/a41a08be-5290-4df4-8002-089e66aba953)
![SalesAgentMenu](https://github.com/user-attachments/assets/d0882f85-1c09-4790-b784-118423b894f6)
![Login](https://github.com/user-attachments/assets/a06bbe1a-6fb9-48bd-86d6-e64798a13ad8)
![CustomerMenu](https://github.com/user-attachments/assets/41507a71-11f6-4ef7-8525-f0d694440e10)

El proyecto se llevó a cabo con base en los requerimientos presentados y en los casos de uso solicitados por el docente.
