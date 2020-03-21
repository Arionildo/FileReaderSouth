package br.com.south.filereadersouth.util;

import static java.util.Objects.isNull;

import java.io.File;

public class ArquivoUtil {

    private static final String DAT = "dat";

	public static boolean isFormatoDat(File arquivo) {
        if (isNull(arquivo)) {
            return false;
        }
        String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf(".") + 1);
        return DAT.equalsIgnoreCase(extensao);
    }
}
