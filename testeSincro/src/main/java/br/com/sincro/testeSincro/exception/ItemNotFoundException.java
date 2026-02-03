package br.com.sincro.testeSincro.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id){
        super("Item não está disponível no estoque!");
    }
}
