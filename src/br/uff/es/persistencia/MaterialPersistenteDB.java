/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.persistencia;

import br.uff.es.modelo.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class MaterialPersistenteDB implements IObjetoPersistente {

    @Override
    public boolean salvarObjeto(Object objeto) {
        Connection conn = Conexao.obterConexao();
        Material material = (Material) objeto;

        try {
            String sql = "INSERT INTO Material (nome, descricao, valorUnitario) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, material.getNome());
            ps.setString(2, material.getDescricao());
            ps.setDouble(3, material.getValorUnitario());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Object recuperarObjeto(Object objeto) {
        Connection conn = Conexao.obterConexao();

        Material material = (Material) objeto;

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM Material WHERE nome=? AND descricao=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, material.getNome());
            ps.setString(2, material.getDescricao());

            rs = ps.executeQuery();

            Material m = new Material();

            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));
            }

            return m;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Material recuperarMaterialNome(String nome) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;
            ResultSet rs;
            //String sql = "SELECT (email, nome, senha) FROM usuarios1 WHERE email=? AND senha=?";
            String sql = "SELECT * FROM Material WHERE nome=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            rs = ps.executeQuery();

            Material m = new Material();

            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));
            }

            return m;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Material> recuperarListaMaterialNome(String nome) {
        Connection conn = Conexao.obterConexao();
        List<Material> lista = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;
            //String sql = "SELECT (email, nome, senha) FROM usuarios1 WHERE email=? AND senha=?";
            String sql = "SELECT * FROM Material WHERE nome=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            rs = ps.executeQuery();

            while (rs.next()) {
                Material m = new Material();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));

                lista.add(m);
            }

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Material> recuperarMateriais() {
        Connection conn = Conexao.obterConexao();
        List<Material> lista = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;
            //String sql = "SELECT (email, nome, senha) FROM usuarios1 WHERE email=? AND senha=?";
            String sql = "SELECT * FROM Material";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Material m = new Material();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));

                lista.add(m);
            }

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Material recuperarMaterialDescricao(String descricao) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;
            ResultSet rs;
            //String sql = "SELECT (email, nome, senha) FROM usuarios1 WHERE email=? AND senha=?";
            String sql = "SELECT * FROM Material WHERE descricao=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, descricao);

            rs = ps.executeQuery();

            Material m = new Material();

            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));
            }

            return m;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Material recuperarMaterialID(int id) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;
            ResultSet rs;
            //String sql = "SELECT (email, nome, senha) FROM usuarios1 WHERE email=? AND senha=?";
            String sql = "SELECT * FROM Material WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            Material m = new Material();

            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                m.setValorUnitario(rs.getDouble("valorUnitario"));
            }

            return m;

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean removerMaterialId(int id) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;

            String sql = "DELETE FROM Material WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean removerMaterialNome(String nome) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;

            String sql = "DELETE FROM Material WHERE nome=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            return ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean removerMaterialDescricao(String descricao) {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;

            String sql = "DELETE FROM Material WHERE descricao=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, descricao);

            return ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public DefaultTableModel buildTableModel()
            throws SQLException {
        Connection conn = Conexao.obterConexao();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT id, nome, descricao, valorUnitario FROM Material";
        ps = conn.prepareStatement(sql);

        rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    public void criarTabelaMaterial() {
        Connection conn = Conexao.obterConexao();

        try {
            PreparedStatement ps;

            String sql = "CREATE TABLE Material (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, descricao TEXT, valorUnitario REAL);";
            ps = conn.prepareStatement(sql);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MaterialPersistenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
