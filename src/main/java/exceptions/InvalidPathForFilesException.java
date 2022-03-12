package exceptions;

public class InvalidPathForFilesException extends FrameworkException {

    public InvalidPathForFilesException(String mess){
        super(mess);
    }
    public InvalidPathForFilesException(String mess, Throwable cause){
        super(mess,cause);
    }
}
