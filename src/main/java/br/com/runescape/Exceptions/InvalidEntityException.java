package br.com.runescape.Exceptions;

public class InvalidEntityException extends Exception {

    public InvalidEntityException(){
        super("Invalid Entity to Save");
    }
}
