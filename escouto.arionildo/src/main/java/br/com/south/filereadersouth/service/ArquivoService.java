package br.com.south.filereadersouth.service;

import static java.util.Objects.isNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.south.filereadersouth.util.SystemProperties;

public class ArquivoService implements Service<File> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArquivoService.class);

    public void salvar(File arquivo) {
    	if (isNull(arquivo)) {
    		LOGGER.warn("[ArquivoService.salvar] - Não existe arquivo a ser salvo");
    		return;
    	}
    	
    	String nomeArquivo = arquivo.getName().replace(".dat", "");
        Path outputPath = Paths.get(SystemProperties.DATA_OUT)
        					.resolve(nomeArquivo + ".done.dat");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
        	StringBuilder relatorio = new StringBuilder("Quantidade de clientes no arquivo de entrada: ")
        			.append(ClienteService.getTotalClientes())
        			.append("\nQuantidade de vendedores no arquivo de entrada: ")
        			.append(VendedorService.getTotalVendedores())
        			.append("\nID da venda mais cara: ")
        			.append(VendaService.getIdMaiorVenda())
        			.append("\nO nome do pior vendedor: ")
        			.append(VendaService.getNomeVendedorMenorVenda())
        			.append("\n");

            writer.write(relatorio.toString());
            writer.close();
            LOGGER.info("[ArquivoService.salvar] - Arquivo processado com sucesso");
            resetServices();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

	private void resetServices() {
		ClienteService.limparLista();
		VendaService.limparLista();
		VendedorService.limparLista();
	}
}
