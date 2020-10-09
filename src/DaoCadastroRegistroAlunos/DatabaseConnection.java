/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 * Conexão com o banco de dados PostgreSQL
 */
public class DatabaseConnection {
    
    /**Usada para localizar o BD*/
    private static ArrayList<String> bancos;
    
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

    /** Esse metodo realiza a conexao inicial com o banco, se ele não encontra
     * o database no sistema ele cria, se encontra, ele sinaliza e usa aquela.
     *
     * 
     * EXP: "jdbc:postgresql://localhost:5432/projeto_01, "sa", "sa" "
     * 
     *
     * @param strUsuario Login 
     * @param strSenha Senha
     */
    
    public void ConexaoInicial(String strUsuario, String strSenha) {

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
                                   
            rs = stmt.executeQuery("SELECT datname FROM pg_catalog.pg_database pd");
            
            bancos = new ArrayList<>();
            
            while(rs.next()){                
                bancos.add(rs.getString("datname"));                
            }
            
            if(!(bancos.contains("teste4"))){
                String sqlCreate = "CREATE DATABASE teste4;";
                stmt.addBatch(sqlCreate);
                stmt.executeBatch();
                System.out.println("Banco 'teste4' criado com sucesso!");
                stmt.clearBatch();
                stmt.close();
            }else{
                System.out.println("Banco 'teste4' já existente!");
            }
            
            //stmt.clearBatch();
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

        } finally {
            Desconectar();
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
