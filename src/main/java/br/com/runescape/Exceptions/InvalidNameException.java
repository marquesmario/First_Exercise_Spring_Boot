package br.com.runescape.Exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super("Category Not Found For This Name");
    }
}
