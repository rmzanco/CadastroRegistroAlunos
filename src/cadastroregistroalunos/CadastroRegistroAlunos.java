/* 
AUTOR: Rodrigo M. Zanco, 2020
Projeto com a Intenção de ser apresentado a empresa VR Software.

Para mais informações, consulte o arquivo README.md ou
confira o Repositório do GitHub.

 */
package cadastroregistroalunos;

import DaoCadastroRegistroAlunos.DatabaseConnection;
/**
 *
 * @author rodri
 */
public class CadastroRegistroAlunos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("testeBD");
        DatabaseConnection conexao = new DatabaseConnection();
        
        conexao.ConexaoInicial("teste1", null, null);
        //conexao.Conectar("postgres", null, null);
    }
    
}
