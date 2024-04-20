public class InvalidMenuSelectionException extends Exception{

    public InvalidMenuSelectionException(){

        super("Invalid Chose - Try Again");
    }
    public InvalidMenuSelectionException(String chose){

        super("Error: " + chose + " is an invalid selection");
    }
}
