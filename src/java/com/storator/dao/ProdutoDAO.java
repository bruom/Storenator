/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storator.dao;

import com.storator.exception.PersistenciaException;
import com.storator.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruom
 */
public class ProdutoDAO {

    public void atualizar(Integer codigo, Integer quantidade) throws PersistenciaException {
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "UPDATE Produto SET estoque=estoque-? WHERE cod_prod=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quantidade);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Produto buscarPorId(Integer id) throws PersistenciaException {
        Produto produto = null;
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "SELECT * FROM Produto WHERE cod_prod=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produto = new Produto((Integer) rs.getObject(1), (String) rs.getObject(2), (String) rs.getObject(3), (Double) rs.getObject(4), (Integer) rs.getObject(5), (Integer) rs.getObject(6), (String) rs.getObject(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }

    public List<Produto> buscarPorNome(String e) throws PersistenciaException {
        ArrayList<Produto> list = new ArrayList<Produto>();
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "SELECT * FROM Produto WHERE UPPER(nome_prod) LIKE UPPER('%?%'))";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto((Integer) rs.getObject(1), (String) rs.getObject(2), (String) rs.getObject(3), (Double) rs.getObject(4), (Integer) rs.getObject(5), (Integer) rs.getObject(6), (String) rs.getObject(7));
                list.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<Produto> buscarPorCategoria(Integer id) throws PersistenciaException {
        ArrayList<Produto> list = new ArrayList<Produto>();
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "SELECT * FROM Produto WHERE (id_cat=" + id + ")";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto((Integer) rs.getObject(1), (String) rs.getObject(2), (String) rs.getObject(3), (Double) rs.getObject(4), (Integer) rs.getObject(5), (Integer) rs.getObject(6), (String) rs.getObject(7));
                list.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
