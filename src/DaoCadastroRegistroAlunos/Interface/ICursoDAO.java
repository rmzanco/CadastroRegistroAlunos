/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface ICursoDAO {
    
    /**Seleciona uma lista de cursos.
     * @param curso Instância da classe para filtrar consulta.
     * @return Lista de cursos
     */
    ArrayList<Curso> Selecionar(Curso curso);
    
    /**Seleciona uma lista de cursos.
     * @return Lista de cursos
     */
    ArrayList<Curso> Selecionar();
    
    /**Incluir um curso no BD.
     * @param curso  Instância de um curso com dados para cadastro.
     */
    void Incluir(Curso curso);
    
    /**Atualizar um registro no BD
     * @param curso Instância de um curso com dados para atualizacao.
     */
    void Atualizar(Curso curso);
    
    /** 
     * Excluir registro do BD
     * @param curso 
     */
    void Excluir (Curso curso);
    
}
