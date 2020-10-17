/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos;

import BLLCadastroRegistroAlunos.Interface.ICursoAlunoBLO;
import DaoCadastroRegistroAlunos.CursoAlunoDAO;
import DaoCadastroRegistroAlunos.Interface.ICursoAlunoDAO;
import ModelCadastroRegistroAlunos.CursoAluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public class CursoAlunoBLO implements ICursoAlunoBLO {

    private static ICursoAlunoDAO cursoAlunoDao = null;

    public CursoAlunoBLO() {
        cursoAlunoDao = new CursoAlunoDAO();
    }
     
    
    @Override
    public List<CursoAluno> Selecionar(CursoAluno cursoAluno) {
        return this.cursoAlunoDao.Selecionar(cursoAluno);
    }

    @Override
    public CursoAluno SelecionarPrimeiro(CursoAluno cursoAluno) {
        List<CursoAluno> cursoAlunos = this.cursoAlunoDao.Selecionar(cursoAluno);
        if(cursoAlunos.isEmpty()){
            return new CursoAluno();
        }else{
            return cursoAlunos.get(0);
        }
    }

    @Override
    public void Incluir(CursoAluno cursoAluno) {
        if(cursoAluno == null) throw (new IllegalArgumentException());
        this.cursoAlunoDao.Incluir(cursoAluno);
    }

    @Override
    public void Atualizar(CursoAluno cursoAluno) {
        if(cursoAluno == null) throw (new IllegalArgumentException());
        this.cursoAlunoDao.Atualizar(cursoAluno);
    }

    @Override
    public void Excluir(CursoAluno cursoAluno) {
        if(cursoAluno == null) throw (new IllegalArgumentException());
        this.cursoAlunoDao.Excluir(cursoAluno);     
    }
    
}
