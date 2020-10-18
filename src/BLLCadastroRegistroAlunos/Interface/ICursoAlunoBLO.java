/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Aluno;
import ModelCadastroRegistroAlunos.Curso;
import ModelCadastroRegistroAlunos.CursoAluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface ICursoAlunoBLO {
    
    /**
     * Seleciona os dados de CursoAluno. 
     * @param cursoAluno Instância de CursoAluno
     * @return Lista de CursoAluno;
     */
    public List<CursoAluno> Selecionar(CursoAluno cursoAluno);
    
    /**
     * Seleciona um item de CursoAluno
     * @param cursoAluno Instância de CursoAluno
     * @return Item de cursoAluno
     */
    public CursoAluno SelecionarPrimeiro(CursoAluno cursoAluno);
    
    /**
     * Inclui um CursoAluno.
     * @param cursoAluno Instância de CursoAluno 
     */
    public void Incluir(CursoAluno cursoAluno);
    
    /**
     * Apos incluir um aluno esse método pega o último aluno cadastrado e
     * registra na tabela.
     * @param aluno Instância de Aluno.
     * @param curso Instância de Curso.
     */
    public void SelecionarAlunoECursoParaIncluir(Aluno aluno, Curso curso);
    
    /**
     * Atualiza um CursoAluno
     * @param cursoAluno Instância de CursoAluno 
     */
    public void Atualizar(CursoAluno cursoAluno);
    
    /**
     * Exclui um cursoAluno
     * @param cursoAluno 
     */
    public void Excluir(CursoAluno cursoAluno);
}
