package br.com.south.filereadersouth;

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
import br.com.south.filereadersouth.util.SystemProperties;


public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
    	ProcessadorArquivoCommand command = new ProcessadorArquivoCommand();
        
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Path path = Paths.get(SystemProperties.DATA_IN);
            path.register(service, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey key;
            while ((key = service.take()) != null) {
	            for (WatchEvent<?> event : key.pollEvents()) {
	                Path changed = (Path) event.context();
	                String nomeArquivo = changed.toString();
	                if (".dat".equalsIgnoreCase(nomeArquivo.substring(nomeArquivo.length() - 4))) {
	                    Path inputFilePath = path.resolve(changed);
	                    LOGGER.info("[Main.main] - Processando arquivo: ".concat(inputFilePath.toString()));
	                    command.executar(inputFilePath.toFile());
	                }
	            }
	            key.reset();
	        }
        } catch (IOException e) {
        	LOGGER.error(e.getMessage());
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
    }
}