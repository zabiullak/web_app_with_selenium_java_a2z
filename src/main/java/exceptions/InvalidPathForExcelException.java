package exceptions;

import org.openqa.selenium.By;

public class InvalidPathForExcelException extends InvalidPathForFilesException{


    public InvalidPathForExcelException(String mess){
        super(mess);
    }

    public InvalidPathForExcelException(String mess, Throwable cause){
        super(mess, cause);
    }
}
