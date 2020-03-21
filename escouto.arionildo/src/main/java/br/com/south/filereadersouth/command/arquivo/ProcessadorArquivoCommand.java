package br.com.south.filereadersouth.command.arquivo;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.south.filereadersouth.command.Command;
import br.com.south.filereadersouth.service.ArquivoService;
import br.com.south.filereadersouth.strategy.ProcessarLinhaStrategy;
import br.com.south.filereadersouth.strategy.linha.LinhaClienteStrategy;
import br.com.south.filereadersouth.strategy.linha.LinhaVendaStrategy;
import br.com.south.filereadersouth.strategy.linha.LinhaVendedorStrategy;
import br.com.south.filereadersouth.util.ArquivoUtil;

public class ProcessadorArquivoCommand implements Command<File> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessadorArquivoCommand.class);
	private static final String CARACTERE_SEPARADOR = "ç";

	private ArquivoService arquivoService = new ArquivoService();
	private List<ProcessarLinhaStrategy> strategies = Arrays.asList(new LinhaClienteStrategy(),
																	new LinhaVendaStrategy(),
																	new LinhaVendedorStrategy());

	@Override
	public void executar(File arquivo) {
		if (!validarArquivo(arquivo)) {
			return;
		}
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(arquivo), StandardCharsets.UTF_8))) {
			String linhaAtual;

			while (nonNull(linhaAtual = bufferedReader.readLine())) {
				LOGGER.info("[ProcessadorArquivoCommand.executar] - Processando linha");
				String[] campos = linhaAtual.split(CARACTERE_SEPARADOR);
				strategies.stream().forEach(s -> s.processar(campos));
			}

			arquivoService.salvar(arquivo);
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private boolean validarArquivo(File file) {
		if (isNull(file)) {
			LOGGER.error("[ProcessadorArquivoCommand.validarArquivo] - Arquivo não informado");
			return false;
		}
		if (!file.exists()) {
			LOGGER.error("[ProcessadorArquivoCommand.validarArquivo] - Arquivo não localizado");
			return false;
		}
		if (!ArquivoUtil.isFormatoDat(file)) {
			LOGGER.error("[ProcessadorArquivoCommand.validarArquivo] - O arquivo a seguir não possui um formato válido: "+file.toString());
			return false;
		}
		return true;
	}
}
