
package org.example.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;
import util.Log;

public class ConexionBD {
    private static Connection conexion;
    private static final String URL = "jdbc:h2:./Base_de_datos/db";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection obtenerConexion(){
        if (conexion == null){
            try{
                conexion = DriverManager.getConnection(URL, USER, PASS);
            }catch(SQLException e){
                Log.error("No se pudo obtener la conexion a la base de datos",e);
            }
        }
        return conexion;
    }

    public static void cerrarConexion(){
        try{
            if(conexion != null && !conexion.isClosed()){
                conexion.close();
                conexion = null;
            }
        }catch(SQLException e){
            Log.error("No se pudo cerrar la conexion a la base de datos",e);
        }
    }

    public static boolean inicializar(){
        if (obtenerConexion() == null) {
            return false;
        }

        // Ejecutar script de creación de tablas
        ejecutarScriptSQL("init.sql");
        return true;
    }

    private static void ejecutarScriptSQL(String archivoSQL) {
        try (InputStream is = ConexionBD.class.getClassLoader().getResourceAsStream(archivoSQL)) {
            if (is == null) {
                Log.error("No se encontró el archivo SQL: " + archivoSQL, null);
                return;
            }

            String sql = new BufferedReader(new InputStreamReader(is))
                    .lines()
                    .collect(Collectors.joining("\n"));

            try (Statement stmt = conexion.createStatement()) {
                stmt.execute(sql);
                Log.info("Se ejecutó el script: " + archivoSQL);
            }
        } catch (Exception e) {
            Log.error("Error al ejecutar el script SQL: " + archivoSQL, e);
        }
    }

}
