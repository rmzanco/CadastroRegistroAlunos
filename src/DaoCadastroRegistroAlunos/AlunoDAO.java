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
    
    private String querySelecionar = "SELECT * FROM aluno;";
    
    private String queryIncluir = "INSERT INTO aluno (nome) VALUES ( '{0}' );";
    
    private String queryAtualizar = "UPDATE aluno SET nome = '{0}' WHERE id_aluno = {1};";
    
    private String queryExcluir = "DELETE FROM aluno WHERE id_aluno = {0};";
    
    @Override
    public List<Aluno> Selecionar(Aluno aluno) {
        
        List<Aluno> alunos = new ArrayList<Aluno>();
       
        try {           
            conexao.Conectar("teste4", null, null);
            conexao.rs = conexao.stmt.executeQuery(querySelecionar);
            
            while(conexao.rs.next()){
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
    
}
