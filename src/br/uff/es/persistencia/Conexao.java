/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.persistencia;

/**
 *
 * @author felipe
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public static Connection conn = null;

    public static Connection obterConexao() {

        if (conn == null) {
            String db = "materiais.db";

            String url = "jdbc:sqlite:" + db;

            try {
                Class.forName("org.sqlite.JDBC");
                return conn = DriverManager.getConnection(url);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return conn;
        }
        return conn;
    }
}
