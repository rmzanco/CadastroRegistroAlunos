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
    
    private String queryIncluir = "INSERT INTO aluno VALUES ( {0} )";
    
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
            
            conexao.Desconectar();                
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
              
       return alunos; 
    }

    @Override
    public void Incluir(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Atualizar(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Excluir(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
