/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import DaoCadastroRegistroAlunos.Interface.IAlunoDAO;
import ModelCadastroRegistroAlunos.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class AlunoDAO implements IAlunoDAO {
    
    private DatabaseConnection conexao = new DatabaseConnection();
    
    private String querySelecionar = "SELECT * FROM aluno";
    
    private String queryIncluir = "INSERT INTO aluno (nome) VALUES ( '{0}' );";
    
    private String queryAtualizar = "UPDATE aluno SET nome = '{0}' WHERE id_aluno = {1};";
    
    private String queryExcluir = "DELETE FROM aluno WHERE id_aluno = {0};";
    
    @Override
    public List<Aluno> Selecionar(Aluno aluno) {
        
        List<Aluno> alunos = new ArrayList<Aluno>();
       
        try {           
            conexao.Conectar("teste4", null, null);
            
            String sql = querySelecionar;
            
            if(aluno.Nome != null){               
                sql += " WHERE nome = '" + aluno.Nome + "'";                
            }
            
            if(aluno.IdAluno != 0){
                if(sql.contains("WHERE")){
                    sql += " AND id_aluno = " + Integer.toString(aluno.IdAluno);                                    
                }else{
                    sql += " WHERE id_aluno = " + Integer.toString(aluno.IdAluno);                                    
                }                
            }
            
            conexao.rs = conexao.stmt.executeQuery(sql);
            
            while(conexao.rs.next()){
                aluno = new Aluno();
                aluno.IdAluno = conexao.rs.getInt("id_aluno");
                aluno.Nome = conexao.rs.getString("nome");
                alunos.add(aluno);
            }
            
            //TODO: CRIAR PARAMETROS PARA O SELECIONAR (WHERE) - PARA ENCONTRAR QUAL CAMPO DEVE SER ATUALIZADO.
            conexao.Desconectar();                
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
              
       return alunos; 
    }

    @Override
    public void Incluir(Aluno aluno) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryIncluir.replace("{0}",aluno.Nome);           
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }

    @Override
    public void Atualizar(Aluno aluno) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryAtualizar.replace("{0}",aluno.Nome);
            sql = sql.replace("{1}",Integer.toString(aluno.IdAluno));           
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }       
    }

    @Override
    public void Excluir(Aluno aluno) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryExcluir.replace("{0}",Integer.toString(aluno.IdAluno));
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }            
    }

    @Override
    public ArrayList<String[]> SelecionarViewAluno() {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        String nome;
        String curso;
  
        conexao.Conectar("teste4", null, null);       
               
        try {
            String sql = 
                "SELECT "
                + "alu.nome AS nome_aluno, "
                + "curs.descricao AS nome_curso "
                + "FROM aluno alu "
                + "INNER JOIN curso_aluno ca ON ( alu.id_aluno = ca.id_aluno ) "
                + "INNER JOIN curso curs ON (curs.id_curso = ca.id_curso)" ;
        
            conexao.rs = conexao.stmt.executeQuery(sql);
            
            while(conexao.rs.next()){                
                nome = conexao.rs.getString("nome_aluno");
                curso = conexao.rs.getString("nome_curso");
                
                lista.add(new String[]{nome,curso});               
            }
            
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }finally{
            conexao.Desconectar();          
        }      
        
        return lista;
    }
    
}
