package br.com.south.filereadersouth;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.south.filereadersouth.command.arquivo.ProcessadorArquivoCommand;


public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @SuppressWarnings("null")
	public static void main(String[] args) {
    	ProcessadorArquivoCommand command = new ProcessadorArquivoCommand();
        
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
        	WatchService watchService = FileSystems.getDefault().newWatchService();

            Path inputPath = Paths.get(
                    System.getProperty("user.home")
                            .concat(File.separator)
                            .concat("data")
                            .concat(File.separator)
                            .concat("in"));

            inputPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey key;
            while ((key = watchService.take()) != null) {
	            for (WatchEvent<?> event : key.pollEvents()) {
	                Path changed = (Path) event.context();
	                if (changed.endsWith(".dat")) {
	                    Path inputFilePath = inputPath.resolve(changed);
	                    LOGGER.info("[Main.main] - Processando arquivo: ".concat(inputFilePath.toString()));
	                    command.executar(inputFilePath.toFile());
	                }
	            }
	            key.reset();
	        }
            key.toString();
        } catch (IOException e) {
        	LOGGER.error(e.getMessage());
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
    }
}