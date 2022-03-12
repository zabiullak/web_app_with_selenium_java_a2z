package exceptions;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String mess){
        super(mess);
    }

    public FrameworkException(String mess, Throwable cause){
        super(mess, cause);
    }

}
