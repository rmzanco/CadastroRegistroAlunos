/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Aluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface IAlunoDAO {
    
    /**Implementação que Seleciona uma lista de alunos.
     * @param aluno Instância da classe para filtrar consulta.
     * @return  
     */
    List<Aluno> Selecionar(Aluno aluno);
    
    /**Incluir um aluno no BD.
     * @param aluno  Instância de um aluno com dados para cadastro.
     */
    void Incluir(Aluno aluno);
    
    /**Atualizar um registro no BD
     * @param aluno Instância de um aluno com dados para cadastro.
     */
    void Atualizar(Aluno aluno);
    
    /** 
     * Excluir registro do BD
     * @param aluno 
     */
    void Excluir(Aluno aluno);
    
    
}
