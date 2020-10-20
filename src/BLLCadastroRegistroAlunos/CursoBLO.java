/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos;

import BLLCadastroRegistroAlunos.Interface.ICursoBLO;
import DaoCadastroRegistroAlunos.CursoDAO;
import DaoCadastroRegistroAlunos.Interface.ICursoDAO;
import ModelCadastroRegistroAlunos.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class CursoBLO implements ICursoBLO {

    private static ICursoDAO cursoDao = null;

    public CursoBLO() {
        this.cursoDao = new CursoDAO();
    }
        
    
    @Override
    public List<Curso> Selecionar(Curso curso) {
        return this.cursoDao.Selecionar(curso);
    }
    
    @Override
    public ArrayList<Curso> Selecionar() {
        return this.cursoDao.Selecionar();
    }

    @Override
    public Curso SelecionarPrimeiro(Curso curso) {
        List<Curso> cursos = this.cursoDao.Selecionar(curso);
        if(cursos.isEmpty()){
            return new Curso();
        }else{
            return cursos.get(0);
        }
    }

    @Override
    public void Incluir(Curso curso) {
        if(curso == null) throw (new IllegalArgumentException());
        this.cursoDao.Incluir(curso);
    }

    @Override
    public void Atualizar(Curso curso) {
        if(curso == null) throw (new IllegalArgumentException());
        this.cursoDao.Atualizar(curso);
    }

    @Override
    public void Excluir(Curso curso) {
        if(curso == null) throw (new IllegalArgumentException());
        this.cursoDao.Excluir(curso);
    }
    
}
