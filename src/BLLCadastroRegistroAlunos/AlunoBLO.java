/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos;

import BLLCadastroRegistroAlunos.Interface.IAlunoBLO;
import DaoCadastroRegistroAlunos.AlunoDAO;
import DaoCadastroRegistroAlunos.Interface.IAlunoDAO;
import ModelCadastroRegistroAlunos.Aluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public class AlunoBLO implements IAlunoBLO{

    private static IAlunoDAO alunoDao = null;

    public AlunoBLO() {
        this.alunoDao = new AlunoDAO();
    }
    
    
    @Override
    public List<Aluno> Selecionar(Aluno aluno) {
        return this.alunoDao.Selecionar(aluno);
    }

    @Override
    public Aluno SelecionarPrimeiro(Aluno aluno) {
        List<Aluno> alunos = this.alunoDao.Selecionar(aluno);
        if(alunos.isEmpty()){
            return new Aluno();
        }else{
            return alunos.get(0);
        }
    }

    @Override
    public void Incluir(Aluno aluno) {
        if(aluno == null) throw (new IllegalArgumentException());
        this.alunoDao.Incluir(aluno);
    }

    @Override
    public void Atualizar(Aluno aluno) {
        if(aluno == null) throw (new IllegalArgumentException());
        this.alunoDao.Atualizar(aluno);
    }

    @Override
    public void Excluir(Aluno aluno) {
        if(aluno == null) throw (new IllegalArgumentException());
        this.alunoDao.Excluir(aluno);
    }
    
}
