package ejecucionconsultas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.MiConexion;

public class InsercionDeDatosEnTabla {
	public static void main(String[] args) {

		String nombreTabla = "Personas";

		try {
			if (insertarDatos(nombreTabla)) {
				System.out.println("Datos insertados en la Tabla \"" + nombreTabla + "\"");
			} else {
				System.out.println("No se han podido insertar los datos en la Tabla \"" + nombreTabla + "\"");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean insertarDatos(String nombreTabla) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		boolean creacionCompletada = false;

		try {

			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos las sentencias para insertar los datos en la tabla
			String[] todosLosInsert = {
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (1, 'Juan', 'Pérez', 25);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (2, 'Ana', 'García', 33);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (3, 'Luis', 'Fernández', 41);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (4, 'María', 'López', 15);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (5, 'Carlos', 'Martínez', 52);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (6, 'Lucía', 'Sánchez', 23);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (7, 'Pedro', 'Gómez', 67);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (8, 'Laura', 'Díaz', 12);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (9, 'Miguel', 'Romero', 58);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (10, 'Carmen', 'Hernández', 45);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (11, 'José', 'Jiménez', 19);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (12, 'Sofía', 'Ruiz', 38);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (13, 'Diego', 'Torres', 47);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (14, 'Daniela', 'Ramírez', 10);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (15, 'Antonio', 'Flores', 63);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (16, 'Paula', 'Gutiérrez', 55);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (17, 'Francisco', 'Molina', 29);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (18, 'Julia', 'Castro', 34);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (19, 'Jorge', 'Ortega', 70);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (20, 'Andrea', 'Morales', 40);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (21, 'Raúl', 'Delgado', 20);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (22, 'Patricia', 'Vega', 33);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (23, 'Alejandro', 'Chávez', 7);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (24, 'Isabel', 'Peña', 36);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (25, 'Ricardo', 'Campos', 74);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (26, 'Beatriz', 'Santana', 68);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (27, 'Manuel', 'Serrano', 11);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (28, 'Teresa', 'Reyes', 54);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (29, 'Gonzalo', 'Mendoza', 48);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (30, 'Elena', 'Soto', 14);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (31, 'Hugo', 'Suárez', 39);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (32, 'Valeria', 'Aguilar', 26);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (33, 'Rafael', 'Vargas', 72);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (34, 'Sandra', 'Cabrera', 60);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (35, 'Víctor', 'Ríos', 32);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (36, 'Marta', 'León', 8);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (37, 'Roberto', 'Silva', 65);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (38, 'Natalia', 'Paz', 53);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (39, 'Iván', 'Arias', 30);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (40, 'Claudia', 'Herrera', 21);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (41, 'Emilio', 'Figueroa', 17);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (42, 'Verónica', 'Correa', 50);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (43, 'Martín', 'Navarro', 69);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (44, 'Sara', 'Estrada', 37);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (45, 'Pablo', 'Mejía', 59);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (46, 'Adriana', 'Román', 28);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (47, 'Felipe', 'Santos', 22);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (48, 'Gloria', 'Miranda', 56);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (49, 'Samuel', 'Parra', 9);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (50, 'Carolina', 'Lara', 35);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (51, 'Javier', 'Vera', 22);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (52, 'Rosa', 'Montes', 41);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (53, 'Andrés', 'Rojas', 67);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (54, 'Alicia', 'Vázquez', 13);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (55, 'Gustavo', 'Muñoz', 76);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (56, 'Rocío', 'Padilla', 31);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (57, 'Matías', 'Blanco', 19);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (58, 'Fernanda', 'Rivas', 45);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (59, 'Tomás', 'Espinoza', 24);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (60, 'Marisol', 'Castillo', 37);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (61, 'Ernesto', 'Fuentes', 68);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (62, 'Silvia', 'Valenzuela', 14);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (63, 'Agustín', 'Ponce', 56);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (64, 'Carla', 'Romero', 10);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (65, 'Oscar', 'Quintero', 53);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (66, 'Mónica', 'Salinas', 43);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (67, 'Eduardo', 'Vargas', 26);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (68, 'Camila', 'Campos', 71);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (69, 'Felipe', 'Sepúlveda', 58);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (70, 'Renata', 'Guzmán', 12);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (71, 'Rodrigo', 'Bravo', 35);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (72, 'Patricia', 'Núñez', 66);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (73, 'Héctor', 'Zúñiga', 75);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (74, 'Lorena', 'Navarrete', 28);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (75, 'Alberto', 'Lagos', 38);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (76, 'Vanesa', 'Soto', 62);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (77, 'Ricardo', 'Carrasco', 50);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (78, 'Luz', 'Aravena', 9);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (79, 'Maximiliano', 'Peña', 33);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (80, 'Elsa', 'Moreno', 48);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (81, 'Sergio', 'Araya', 52);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (82, 'Mariana', 'Maldonado', 65);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (83, 'Benjamín', 'Becerra', 29);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (84, 'Rafael', 'González', 46);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (85, 'Magdalena', 'Navarro', 20);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (86, 'Francisca', 'Sandoval', 11);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (87, 'Joaquín', 'Riquelme', 55);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (88, 'Alejandra', 'Paredes', 17);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (89, 'Álvaro', 'Bustamante', 36);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (90, 'Pamela', 'Alvarez', 63);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (91, 'Claudio', 'Del Valle', 15);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (92, 'Natalia', 'Arce', 70);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (93, 'Jonathan', 'Escobar', 42);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (94, 'Luisa', 'Coronel', 25);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (95, 'Mauricio', 'Sáez', 73);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (96, 'Esteban', 'Mena', 54);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (97, 'Verónica', 'Cáceres', 39);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (98, 'Lucas', 'Saldaña', 78);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (99, 'Angélica', 'Olivares', 57);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (100, 'Damián', 'Medina', 8);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (101, 'Fabián', 'Villalobos', 25);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (102, 'María', 'Sepúlveda', 44);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (103, 'Gonzalo', 'López', 15);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (104, 'Isabel', 'Muñoz', 77);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (105, 'Felipe', 'Molina', 19);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (106, 'Paola', 'Escobar', 60);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (107, 'Cristian', 'Zamora', 49);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (108, 'Nicole', 'Oliva', 27);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (109, 'Jorge', 'Morales', 37);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (110, 'Marta', 'Valdés', 64);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (111, 'Santiago', 'Carrillo', 21);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (112, 'Daniel', 'Pizarro', 31);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (113, 'Antonia', 'Aravena', 66);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (114, 'Raúl', 'Galindo', 55);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (115, 'Laura', 'Palacios', 10);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (116, 'Iván', 'Sandoval', 74);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (117, 'Gabriela', 'Alarcón', 47);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (118, 'Mario', 'Silva', 18);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (119, 'Carolina', 'Garrido', 58);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (120, 'Luis', 'Herrera', 13);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (121, 'Ignacio', 'Catalán', 62);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (122, 'Violeta', 'Escalante', 32);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (123, 'Alfonso', 'Tapia', 48);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (124, 'Patricia', 'Mendoza', 26);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (125, 'Sebastián', 'Lagos', 34);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (126, 'Elisa', 'Miranda', 7);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (127, 'Francisco', 'Bermúdez', 29);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (128, 'Romina', 'Fierro', 75);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (129, 'Carlos', 'Aguirre', 23);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (130, 'Gloria', 'Campos', 72);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (131, 'Andrés', 'Orozco', 14);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (132, 'Silvana', 'Naranjo', 40);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (133, 'Pablo', 'Peñafiel', 67);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (134, 'Cristina', 'Vásquez', 9);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (135, 'René', 'Valenzuela', 59);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (136, 'Diana', 'Ibáñez', 50);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (137, 'Raquel', 'Olmedo', 22);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (138, 'Leonardo', 'Bustos', 38);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (139, 'Cecilia', 'Espinoza', 6);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (140, 'Óscar', 'Vera', 43);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (141, 'Manuela', 'Rivera', 12);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (142, 'Víctor', 'Lara', 69);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (143, 'Tania', 'Benítez', 57);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (144, 'Fernando', 'Santos', 28);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (145, 'Amparo', 'Lobo', 16);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (146, 'Julio', 'Ávila', 52);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (147, 'Soledad', 'Montoya', 61);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (148, 'Eduardo', 'Maldonado', 35);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (149, 'Yolanda', 'Rojas', 11);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (150, 'Ángela', 'Figueroa', 76);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (151, 'Roberto', 'Valle', 45);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (152, 'Marcela', 'Godoy', 20);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (153, 'Emilio', 'Medina', 37);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (154, 'Liliana', 'Cortés', 59);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (155, 'Joaquín', 'Salazar', 8);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (156, 'Beatriz', 'Ferrera', 64);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (157, 'Tomás', 'López', 18);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (158, 'Sonia', 'Guzmán', 27);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (159, 'Álvaro', 'Rosales', 53);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (160, 'Mariana', 'Fuentes', 12);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (161, 'Hernán', 'Bravo', 33);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (162, 'Gloria', 'Paredes', 60);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (163, 'Claudio', 'Martínez', 69);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (164, 'Daniela', 'Zúñiga', 25);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (165, 'Felipe', 'Romero', 31);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (166, 'Valentina', 'Pizarro', 48);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (167, 'Esteban', 'Olivares', 44);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (168, 'Elena', 'Gómez', 73);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (169, 'Luis', 'Mella', 11);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (170, 'Silvia', 'Sánchez', 39);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (171, 'Juan', 'Acevedo', 24);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (172, 'Alfredo', 'Lagos', 65);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (173, 'Carmen', 'Ríos', 7);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (174, 'Rodrigo', 'Cifuentes', 41);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (175, 'Jimena', 'Miranda', 58);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (176, 'Gustavo', 'Poblete', 54);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (177, 'Tamara', 'Arancibia', 16);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (178, 'Boris', 'Sepúlveda', 30);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (179, 'Rebeca', 'Aguilera', 9);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (180, 'Francisco', 'Ojeda', 28);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (181, 'Victoria', 'Carrasco', 70);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (182, 'Sergio', 'Reyes', 37);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (183, 'Consuelo', 'Peña', 43);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (184, 'Héctor', 'Contreras', 5);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (185, 'Loreto', 'Barrera', 66);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (186, 'Rafael', 'Ortiz', 22);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (187, 'Viviana', 'Valenzuela', 35);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (188, 'Manuel', 'Maturana', 40);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (189, 'Paula', 'Torres', 74);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (190, 'Ricardo', 'Farias', 26);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (191, 'Raquel', 'Escalante', 13);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (192, 'Diego', 'Aravena', 51);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (193, 'Camila', 'Riquelme', 32);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (194, 'Fernando', 'Riveros', 46);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (195, 'Clara', 'Venegas', 61);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (196, 'Lucía', 'Salas', 34);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (197, 'Pedro', 'Villanueva', 17);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (198, 'Jessica', 'Palma', 15);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (199, 'Ignacio', 'Tapia', 19);\r\n",
					"INSERT INTO " + nombreTabla + " (id, nombre, apellido, edad) VALUES (200, 'Laura', 'Andrade', 72);" };

			// Paso 4. Ejecutar todas las sentencias
			for (String sql : todosLosInsert) {
				stmt.executeUpdate(sql);
			}

			creacionCompletada = true;

		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// insercion
			se.printStackTrace();
		} catch (Exception e) {
			// Gestionamos los posibles errores
			e.printStackTrace();
		} finally {
			if(stmt!=null)
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}

		return creacionCompletada;
	}
}
