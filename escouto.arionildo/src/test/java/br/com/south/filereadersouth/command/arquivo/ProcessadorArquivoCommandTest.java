package br.com.south.filereadersouth.command.arquivo;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class ProcessadorArquivoCommandTest {

    @Test
    public void givenArquivoVazioThenException() throws FileNotFoundException {
        ProcessadorArquivoCommand command = new ProcessadorArquivoCommand();
        File file = new File("src/test/resources/file.dat");
        command.executar(file);
        new AssertionError(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    public void givenArquivoThenExecutar() throws FileNotFoundException {
        ProcessadorArquivoCommand command = new ProcessadorArquivoCommand();
        File file = new File("src/test/resources/files.dat");
        command.executar(file);
    }

    @Test
    public void givenArquivoNullThenFalha() throws FileNotFoundException {
        ProcessadorArquivoCommand command = new ProcessadorArquivoCommand();
        command.executar(null);
        command.executar(new File(""));
        command.executar(new File("src/test/resources/files.doc"));
    }
}
