package br.com.exemplo.singleton;

public class Main {
    public static void main(String[] args) {
        
        Logger logSistema = Logger.getInstance();

        logSistema.info("Inicializando o sistema de Vendas...");
        logSistema.info("Carregando configurações do usuário Vitor...");
        
        simularProcessoDemorado();

        logSistema.info("Conectando ao banco de dados...");
        
        logSistema.error("Falha ao conectar no servidor secundário (Timeout).");
        logSistema.info("Tentando reconexão...");
        logSistema.info("Conexão estabelecida com sucesso.");

        Logger logAuditoria = Logger.getInstance();
        
        if (logSistema == logAuditoria) {
            logAuditoria.info("Auditoria confirmada: Mesma instância de Logger sendo usada.");
        }

        logSistema.info("Sistema finalizado.");
    }

    private static void simularProcessoDemorado() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}