/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Curso;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface ICursoBLO {
    
    /**
     * Seleciona os dados de Curso.
     * @param curso Instancia da classe Curso.
     * @return Retorna uma lista de cursos.
     */
    public List<Curso> Selecionar(Curso curso);
    
    /**
     * Seleciona o primeiro item de Curso
     * @param curso Instância da classe Curso.
     * @return Retorna um item de curso.
     */
    public Curso SelecionarPrimeiro(Curso curso);
    
    /**
     * Inclui um curso
     * @param curso Instância da classe Curso.
     */
    public void Incluir(Curso curso);
    
    /**
     * Atualiza um curso
     * @param curso Instância da classe Curso.
     */
    public void Atualizar(Curso curso);
    
    /**
     * Excluir um curso
     * @param curso Instância da classe Curso.
     */
    public void Excluir(Curso curso);
    
}
