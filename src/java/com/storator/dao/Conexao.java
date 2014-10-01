/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storator.dao;

import com.storator.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruom
 */
public class Conexao {

    private static Conexao conexao;
    private static ResourceBundle bundle;

    private Conexao() {
        bundle = ResourceBundle.getBundle("com.storator.dao.configuracao"); // CONFIGURAR
    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws PersistenciaException {
        Connection connection = null;
        try {
            Class.forName(bundle.getString("driver"));
            connection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("usuario"), bundle.getString("senha"));
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de bd.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível estabelecer a conexão com o bd.");
        }
        return connection;
    }
}
