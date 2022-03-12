package exceptions;

public class PropertyFileUsageException extends FrameworkException{

    public PropertyFileUsageException(String mess){
        super(mess);
    }
    public PropertyFileUsageException(String mess, Throwable cause){
        super(mess,cause);
    }
}
