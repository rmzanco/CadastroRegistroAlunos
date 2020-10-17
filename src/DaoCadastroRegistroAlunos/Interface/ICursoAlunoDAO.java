/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.CursoAluno;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface ICursoAlunoDAO {    
    
    /**Seleciona uma lista de cursoAlunos.
     * @param cursoAluno Instância da classe para filtrar consulta.
     * @return  
     */
    List<CursoAluno> Selecionar(CursoAluno cursoAluno);
    
    /**Incluir um cursoAluno no BD.
     * @param cursoAluno Instância de um CursoAluno com dados para cadastro.
     */
    void Incluir(CursoAluno cursoAluno);
    
    /**Atualizar um registro no BD
     * @param cursoAluno Instância de um CursoAluno com dados para atualizacao.
     */
    void Atualizar(CursoAluno cursoAluno);
    
    /** 
     * Excluir registro do BD
     * @param cursoAluno 
     */
    void Excluir(CursoAluno cursoAluno);
    
}
