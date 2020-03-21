package br.com.south.filereadersouth.util;

import java.io.File;

public class SystemProperties {
	private static StringBuilder data = new StringBuilder(System.getProperty("user.home"))
														.append(File.separator)
														.append("data")
														.append(File.separator);
	public static final String DATA_IN = new StringBuilder(data).append("in").toString();
	public static final String DATA_OUT = new StringBuilder(data).append("out").toString();
}
