/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelCadastroRegistroAlunos;

import java.io.Serializable;

/**
 *
 * @author rodri
 */
public class Aluno implements Serializable {

    public Aluno() {
    }
    
    public int IdAluno;
    public String Nome;

    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int IdAluno) {
        this.IdAluno = IdAluno;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
    
}
