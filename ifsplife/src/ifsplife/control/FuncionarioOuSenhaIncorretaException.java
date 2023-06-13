package ifsplife.control;

public class FuncionarioOuSenhaIncorretaException extends Exception{

    public FuncionarioOuSenhaIncorretaException() {
    }

    public FuncionarioOuSenhaIncorretaException(String msg) {
        super(msg);
    }
}
