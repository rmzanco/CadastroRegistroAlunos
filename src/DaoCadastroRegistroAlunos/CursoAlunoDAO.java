/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import DaoCadastroRegistroAlunos.Interface.ICursoAlunoDAO;
import ModelCadastroRegistroAlunos.Curso;
import ModelCadastroRegistroAlunos.CursoAluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class CursoAlunoDAO implements ICursoAlunoDAO {

    private DatabaseConnection conexao = new DatabaseConnection();
    
    private String querySelecionar = "SELECT * FROM curso_aluno;";
    
    private String queryIncluir = "INSERT INTO curso_aluno (id_aluno,id_curso) VALUES ( '{0}','{1}' );";
    
    private String queryAtualizar = "UPDATE curso_aluno SET id_aluno = '{0}',id_curso = '{1}' WHERE id_curso_aluno = {2};";
    
    private String queryExcluir = "DELETE FROM curso_aluno WHERE id_curso_aluno = {0};";
    
    @Override
    public List<CursoAluno> Selecionar(CursoAluno cursoAluno) {
        List<CursoAluno> cursoAlunos = new ArrayList<>();
       
        try {           
            conexao.Conectar("teste4", null, null);
            conexao.rs = conexao.stmt.executeQuery(querySelecionar);
            
            while(conexao.rs.next()){
                cursoAluno.IdCursoAluno = conexao.rs.getInt("id_curso_aluno");
                cursoAluno.IdAluno = conexao.rs.getInt("id_aluno");
                cursoAluno.IdCurso = conexao.rs.getInt("id_curso");
                cursoAlunos.add(cursoAluno);
            }
            
            
            //TODO: CRIAR PARAMETROS PARA O SELECIONAR (WHERE) - PARA ENCONTRAR QUAL CAMPO DEVE SER ATUALIZADO.
            conexao.Desconectar();                
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
              
       return cursoAlunos;
    }

    @Override
    public void Incluir(CursoAluno cursoAluno) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryIncluir.replace("{0}",Integer.toString(cursoAluno.IdAluno));   
            sql = sql.replace("{1}", Integer.toString(cursoAluno.IdCurso));
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }

    @Override
    public void Atualizar(CursoAluno cursoAluno) {        
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryAtualizar.replace("{0}", Integer.toString(cursoAluno.IdAluno));
            sql = sql.replace("[1]", Integer.toString(cursoAluno.IdCurso));
            sql = sql.replace("{2}", Integer.toString(cursoAluno.IdCursoAluno));           
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();
            
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }

    @Override
    public void Excluir(CursoAluno cursoAluno) {
        try{
            conexao.Conectar("teste4", null, null);
            
            String sql = queryExcluir.replace("{0}",Integer.toString(cursoAluno.IdCursoAluno));
            conexao.stmt.execute(sql);
            
            conexao.Desconectar();           
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }
    
}
