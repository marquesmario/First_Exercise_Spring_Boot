package br.com.runescape.Exceptions;

public class InvalidUpdateEntityException extends Exception {
    public InvalidUpdateEntityException() {
        super("Entity Equal Or Bad Format To Be Updated");
    }
}
