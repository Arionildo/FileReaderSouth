package br.com.south.filereadersouth.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class ArquivoUtilTest {

    @Test
    public void givenFormatoDatThenTrue() {
        assertTrue(ArquivoUtil.isFormatoDat(new File("file.dat")));
    }

    @Test
    public void givenFormatoDocThenFalse() {
        assertFalse(ArquivoUtil.isFormatoDat(new File("file.doc")));
    }
}
