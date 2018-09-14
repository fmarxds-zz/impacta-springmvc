package com.everis.io;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Arquivos {

	public static void gerarLog(String texto, int tipo) throws Exception {
		try {
			// TIPO - 1: Informação
			// TIPO - 2: Erro
			if (tipo != 1 && tipo != 2) {
				throw new Exception("Tipo de log incorreto informado");
			}

			FileWriter writer = new FileWriter(new File("C:\\Users\\fmarqusa\\eclipse-workspace\\Projeto01_ServletJSP\\logs\\Projeto01-logs.txt"), true);

			String log = String.format(
					"[\"%s\"] - %s : %s\r\n",
					tipo == 1 ? "INFO" : "ERRO",
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString(),
					texto);

			writer.write(log);
			writer.close();
			
		} catch (Exception e) {
			throw e;
		}
	}

}
