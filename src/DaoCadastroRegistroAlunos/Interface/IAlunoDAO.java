/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoCadastroRegistroAlunos.Interface;

import ModelCadastroRegistroAlunos.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface IAlunoDAO {
    
    /**Seleciona uma lista de alunos.
     * @param aluno Instância da classe para filtrar consulta.
     * @return  
     */
    List<Aluno> Selecionar(Aluno aluno);
    
    /**Incluir um aluno no BD.
     * @param aluno  Instância de um aluno com dados para cadastro.
     */
    void Incluir(Aluno aluno);
    
    /**Atualizar um registro no BD
     * @param aluno Instância de um aluno com dados para atualizacao.
     */
    void Atualizar(Aluno aluno);
    
    /** 
     * Excluir registro do BD
     * @param aluno Instância de um aluno
     */
    void Excluir(Aluno aluno);
    
    /**
     * Retorna do banco a view para listar o aluno e seu curso na tabela aluno.
     * @return Lista com as colunas aluno/curso
     */
    public ArrayList<String[]> SelecionarViewAluno ();    
    
}
