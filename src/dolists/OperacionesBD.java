/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolists;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author alber
 */
public class OperacionesBD {
    
    public OperacionesBD() {}

    private Connection conectar() throws ClassNotFoundException {
        // SQLite connection string
        String url = "jdbc:sqlite:bd.db";

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("error");
        }

        return conn;
    }

    private void desconectar(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    public String addUser(String dni, String nombre) throws FileNotFoundException, ClassNotFoundException, IOException {
        String sql = "INSERT INTO Usuarios(dni,nombre,reciente) VALUES (?,?,?);";

        try {
            Connection conn = this.conectar();
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dni);
            pstmt.setString(2, nombre);
            pstmt.setBoolean(3, false);
            
            pstmt.executeUpdate();

            this.desconectar(conn);
        } catch (SQLException e) { return "error"; }

        return "";
    }

    public ArrayList<String> obtainRecentUsers() throws ClassNotFoundException {
        String sql = "SELECT * FROM Usuarios WHERE reciente=1;";

        ArrayList<String> datos = new ArrayList<>();

        try {
            Connection conn = this.conectar();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                datos.add(rs.getString("nombre") + " - " + rs.getString("dni"));
            }

            this.desconectar(conn);
            
            if(datos.isEmpty()) datos.add("error");

            return datos;
        } catch (SQLException e) {
            datos.clear();
            datos.add("error");
            return datos;
        }
    }
    
    public ArrayList<String> obtainUsersAutocomplete(int opcion) throws ClassNotFoundException {
        String sql = "SELECT * FROM Usuarios;";
        
        if(opcion == 1) sql = "SELECT * FROM Usuarios WHERE reciente=0;";

        ArrayList<String> datos = new ArrayList<>();
        try {
            Connection conn = this.conectar();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                datos.add(rs.getString("nombre") + " - " + rs.getString("dni"));
            }

            this.desconectar(conn);
            
            if(datos.isEmpty()) datos.add("error");

            return datos;
        } catch (SQLException e) {
            datos.clear();
            datos.add("error");
            return datos;
        }
    }

    public String obtainNombre(String dni) throws ClassNotFoundException {
        String sql = "SELECT nombre FROM Usuarios WHERE dni=?;";

        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            // loop through the result set
            String valor = "error";
            if (rs.next()) valor = rs.getString("nombre");

            this.desconectar(conn);

            return valor;
        } catch (SQLException e) { return "error"; }
    }

    public String updateUser(String dni, String nombre) throws ClassNotFoundException, IOException {
        String sentencia = "UPDATE Usuarios SET nombre = ? WHERE dni = ?";
        
        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sentencia);
            stmt.setString(1, nombre);
            stmt.setString(2, dni);

            stmt.executeUpdate();

            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) { return "error"; }
    }
    
    public String updateRecent(String dni, boolean reciente) throws ClassNotFoundException, IOException {
        String sentencia = "UPDATE Usuarios SET reciente = ? WHERE dni = ?";
        
        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sentencia);
            stmt.setBoolean(1, reciente);
            stmt.setString(2, dni);

            stmt.executeUpdate();

            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) { return "error"; }
    }
                                                                
    public String deleteUser(String dni) throws ClassNotFoundException{
        String sql = "DELETE FROM Usuarios WHERE dni=?;";

        try {
            Connection conn = this.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dni);
            
            stmt.executeUpdate();

            this.desconectar(conn);

            return "";
        } catch (SQLException e) { return "error"; }
    }
}
