/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Aluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface IAlunoBLO {
    
    /**
     * Seleciona os dados de aluno
     * @param aluno Instancia da classe Aluno.
     * @return Retorna uma lista de alunos
     */
    public List<Aluno> Selecionar(Aluno aluno);
    
    /**
     * Selecionar o primeiro registro referente aos dados de Projeto.
     * @param aluno Instância da classe aluno.
     * @return Retorna uma instancia de aluno.
     */
    public Aluno SelecionarPrimeiro(Aluno aluno);
    
    /**
     * Incluir aluno
     * @param aluno Instância da classe aluno.
     */
    void Incluir(Aluno aluno);
    
    /**
     * Atualizar aluno
     * @param aluno Instância da classe Aluno.
     */
    void Atualizar(Aluno aluno);
    
    /**
     * Excluir aluno
     * @param aluno Instância da classe Aluno.
     */
    void Excluir(Aluno aluno);
}
