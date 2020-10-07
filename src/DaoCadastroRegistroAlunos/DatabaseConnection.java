/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 * Conexão com o banco de dados PostgreSQL
 */
public class DatabaseConnection {
    
    
     /** Usada para a conexao com o banco de dados */
    private Connection con = null;
    
    /** Usada para realizar as instrucoes SQL */
    public Statement stmt; 
    
    /** Retorna os dados das tabelas do banco */
    public ResultSet rs; 
    
    
    /**Usada para receber o endereco da base de dados*/
    private String endereco;
    
    /**Usada para receber o nome do usuario do banco */
    private String usuario;
    
    /**Usada para receber a senha do usuario do banco */
    private String senha; 

    /** Esse metodo realiza a conexao com o banco, ele precisa de tres argumentos, o primeiro, recebe
     * o endereço do banco, o segundo recebe o nome do usuario e o terceiro recebe a senha do 
     * banco de dados. 
     * 
     * EXP: "jdbc:postgresql://localhost:5432/projeto_01", "sa", "sa"
     * 
     *
     * @param nomeBanco Nome do Banco de Dados
     * @param strUsuario
     */
    
    public void ConexaoInicial(String nomeBanco, String strUsuario, String strSenha) {

    	/** Recebendo o endereco,usuario e senha do usuario e repassando para a variavel global */
        endereco = "jdbc:postgresql://localhost:5432/"; 
        usuario = strUsuario == null ? "postgres" : strUsuario;
        //usuario = "postgres";
        senha = strSenha == null ? "admin" : strSenha ;
        //senha = "admin";

        try {
            
            /** Passando o nome do Driver do PostgreSQL */
            Class.forName("org.postgresql.Driver");
            
            /** Obtendo a conexao com o banco de dados*/
            con = DriverManager.getConnection(endereco, usuario, senha);
            
            /** Criando o Statement */
            stmt = con.createStatement();
            
            String sqlInicial = "SELECT 'CREATE DATABASE teste1 '\n"
                    + "WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname "
                    + "= 'teste1')\\gexec"; //TODO 07/10 -> Fixar query para fazer com que seja criado o bd.
            
            stmt.addBatch(sqlInicial);
            stmt.executeBatch();
            stmt.clearBatch();
            stmt.close();
            
        /** Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o mesmo
         * esteja errada */
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();

         /** Retorna um erro caso exista erro de query SQL */   
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();

        }
    }
    
    
    public void Conectar(String nomeBanco, String strUsuario, String strSenha) {

    	/** Recebendo o endereco,usuario e senha do usuario e repassando para a variavel global */
        endereco = "jdbc:postgresql://localhost:5432/"; 
        usuario = strUsuario == null ? "postgres" : strUsuario;
        //usuario = "postgres";
        senha = strSenha == null ? "admin" : strSenha ;
        //senha = "admin";

        try {
            
            /** Passando o nome do Driver do PostgreSQL */
            Class.forName("org.postgresql.Driver");
            
            /** Obtendo a conexao com o banco de dados*/
            con = DriverManager.getConnection(endereco, usuario, senha);
            
            /** Criando o Statement */
            stmt = con.createStatement();
            
        /** Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o mesmo
         * esteja errada */
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();

         /** Retorna um erro caso exista erro de query SQL */   
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();

        }
    }

    /** Esse metodo quando invocado, realiza a desconexao com o banco */
    public void Desconectar() {

        try {
            con.close();
            
        /** Retorna um erro caso nao consiga desconectar */    
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
            onConClose.printStackTrace();
        }
    }
    
}
