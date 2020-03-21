package br.com.south.filereadersouth.command;

public interface Command<T> {

    void executar(T t);
}
