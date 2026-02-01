package br.com.exemplo.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static volatile Logger instanciaUnica;
    private PrintWriter writer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        try {
            FileWriter fileWriter = new FileWriter("app_logs.txt", true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instanciaUnica == null) {
            synchronized (Logger.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new Logger();
                }
            }
        }
        return instanciaUnica;
    }

    public void info(String mensagem) {
        escreverLog("INFO", mensagem);
    }

    public void error(String mensagem) {
        escreverLog("ERROR", mensagem);
    }

    private void escreverLog(String nivel, String mensagem) {
        String logFormatado = String.format("[%s] [%s]: %s", 
            LocalDateTime.now().format(formatter), 
            nivel, 
            mensagem
        );
        
        System.out.println(logFormatado);
        
        if (writer != null) {
            writer.println(logFormatado);
        }
    }
}