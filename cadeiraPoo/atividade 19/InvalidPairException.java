public class InvalidPairException extends Exception{
    InvalidPairException(){
        super();
    }

    InvalidPairException(String message){
        super(message);
    }

    InvalidPairException(Throwable cause){
        super(cause);
    }

    InvalidPairException(String message, Throwable cause){
        super(message,cause);
    }
}