package br.com.runescape.Exceptions;

public class EntityNullException extends Exception {

    public EntityNullException(){
        super("Invalid Entity to Save");
    }
}
