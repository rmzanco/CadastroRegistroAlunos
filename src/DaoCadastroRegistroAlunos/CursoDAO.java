/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import DaoCadastroRegistroAlunos.Interface.ICursoDAO;
import ModelCadastroRegistroAlunos.Aluno;
import ModelCadastroRegistroAlunos.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class CursoDAO implements ICursoDAO {

    private DatabaseConnection conexao = new DatabaseConnection();
    
    private String querySelecionar = "SELECT * FROM curso;";
    
    private String queryIncluir = "INSERT INTO curso (descricao,ementa) VALUES ( '{0}','{1}' );";
    
    private String queryAtualizar = "UPDATE curso SET descricao = '{0}',ementa = '{1}' WHERE id_curso = {2};";
    
    private String queryExcluir = "DELETE FROM curso WHERE id_curso = {0};";
    
    @Override
    public List<Curso> Selecionar(Curso curso) {
        List<Curso> cursos = new ArrayList<Curso>();
       
        try {           
            conexao.Conectar("teste4", null, null);
            conexao.rs = conexao.stmt.executeQuery(querySelecionar);
            
            while(conexao.rs.next()){
                curso.IdCurso = conexao.rs.getInt("id_curso");
                curso.Descricao = conexao.rs.getString("descricao");
                curso.Ementa = conexao.rs.getString("ementa");
                cursos.add(curso);
            }
            
            conexao.Desconectar();                
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
              
       return cursos;       
    }

    @Override
    public void Incluir(Curso curso) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String query = queryIncluir.replace("{0}",curso.Descricao);   
            query = query.replace("{1}", curso.Ementa);
            conexao.stmt.executeQuery(query);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }        
    }

    @Override
    public void Atualizar(Curso curso) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String query = queryAtualizar.replace("{0}",curso.Descricao);
            query = query.replace("[1]", curso.Ementa);
            query = query.replace("{2}",Integer.toString(curso.IdCurso));           
            conexao.stmt.executeQuery(query);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        } 
    }

    @Override
    public void Excluir(Curso curso) {       
        try{
            conexao.Conectar("teste4", null, null);
            
            String query = queryExcluir.replace("{0}",Integer.toString(curso.IdCurso));
            conexao.stmt.executeQuery(query);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }   
    }    
}
