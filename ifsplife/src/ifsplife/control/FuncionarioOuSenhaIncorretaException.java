/*
 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package ifsplife.control;

/**
 *
 * @author Aluno
 */
public class FuncionarioOuSenhaIncorretaException extends Exception{

    /**
     * Creates a new instance of <code>UsuarioOuSenhaIncorreta</code> without
     * detail message.
     */
    public FuncionarioOuSenhaIncorretaException() {
    }

    /**
     * Constructs an instance of <code>UsuarioOuSenhaIncorreta</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FuncionarioOuSenhaIncorretaException(String msg) {
        super(msg);
    }
}
