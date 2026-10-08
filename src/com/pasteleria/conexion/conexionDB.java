package com.pasteleria.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    // Configura tu puerto (por defecto 1433), usuario y contraseña de SQL Server
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "1433";
    private static final String BASE_DATOS = "PasteleriaDB";
    private static final String USUARIO = "sa"; // Cambia si usas otro usuario
    private static final String PASSWORD = "tu_password"; // Cambia por tu contraseña

    private static final String URL = "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO + ";"
            + "databaseName=" + BASE_DATOS + ";"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con SQL Server: " + e.getMessage());
        }
        return conexion;
    }
}
