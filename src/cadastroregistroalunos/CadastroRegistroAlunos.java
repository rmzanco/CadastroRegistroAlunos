/* 
AUTOR: Rodrigo M. Zanco, 2020
Projeto com a Intenção de ser apresentado a empresa VR Software.

Para mais informações, consulte o arquivo README.md ou
confira o Repositório do GitHub.

 */
package cadastroregistroalunos;

import DaoCadastroRegistroAlunos.DatabaseConnection;
import my.cadastroregistroalunos.CadastroRegistroAlunosUI;
/**
 *
 * @author rodri
 */
public class CadastroRegistroAlunos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("CRA - Cadastro de Registro de Alunos");
        DatabaseConnection conexao = new DatabaseConnection();
        
        conexao.ConexaoInicial("teste4", null, null);
        
        System.out.println("Iniciando a aplicação...");

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroRegistroAlunosUI().setVisible(true);
            }
        });
        
    }
    
}
