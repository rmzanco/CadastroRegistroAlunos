/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos;

import DaoCadastroRegistroAlunos.Interface.IAlunoDAO;
import ModelCadastroRegistroAlunos.Aluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public class AlunoDAO implements IAlunoDAO {
    
    private String querySelecionar = "SELECT * FROM aluno";
    
    private String queryIncluir = "INSERT INTO ";
    
    @Override
    public List<Aluno> Selecionar(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
