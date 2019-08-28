package br.com.runescape.Exceptions;

public class InvalidIdException extends Exception{
    public InvalidIdException(){
        super("Category Not Found For This Id");
    }
}
