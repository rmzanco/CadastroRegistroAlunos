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
public class Curso implements Serializable {

    public Curso() {
    }
    
    public int IdCurso;
    public String Descricao;
    public String Ementa;

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public String getEmenta() {
        return Ementa;
    }

    public void setEmenta(String ementa) {
        this.Ementa = ementa;
    }       
}
