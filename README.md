# Desafio DIO: Design Patterns com Java

Este repositório contém a resolução do desafio de projeto **"Padrões de Projeto com Java"** da **DIO (Digital Innovation One)**.

O objetivo foi aplicar na prática um dos padrões vistos em aula. Optei por implementar o padrão **Singleton** de uma forma **robusta**, simulando um cenário real de mercado (Sistema de Logs) que exige controle de concorrência e persistência de dados.

## 🚀 Sobre a Implementação

Diferente de um exemplo simples de Singleton, esta implementação ("Logger") resolve problemas comuns em aplicações reais:

1.  **Thread Safety:** Utiliza a técnica de *Double-Checked Locking* (`synchronized` e `volatile`) para garantir que apenas uma instância seja criada mesmo em ambientes com múltiplas threads.
2.  **Persistência em Arquivo:** Além de imprimir no console, o log é salvo fisicamente no arquivo `app_logs.txt`.
3.  **Formatação Profissional:** Os logs incluem *Timestamp* (Data/Hora) e Níveis de Severidade (`INFO`, `ERROR`).

## 🛠️ Tecnologias Utilizadas

* **Java JDK** (Java Puro)
* **Padrão Singleton** (Categoria: Criação)
* **Manipulação de Arquivos** (`FileWriter`, `PrintWriter`)
* **Controle de Concorrência** (Threads, `synchronized`)

## 📂 Estrutura do Projeto

```text
src/
└── br/
    └── com/
        └── exemplo/
            └── singleton/
                ├── Logger.java   # Singleton com Thread Safety e escrita em arquivo
                └── Main.java     # Classe cliente para demonstrar o funcionamento
```

## ⚙️ Como Executar

Certifique-se de ter o Java instalado. No terminal, navegue até a pasta `src` do projeto e execute os comandos:

**1. Compilar:**
```bash
javac br/com/exemplo/singleton/*.java
```

**2. Executar:**
```bash
java br.com.exemplo.singleton.Main
```

**3. Verificar Resultado:**
Após a execução, verifique o console para ver as mensagens e abra o arquivo `app_logs.txt` que será gerado na raiz do projeto para ver o histórico salvo.

## 📝 Exemplo de Código

```java
// Recuperando a instância única do Logger
Logger log = Logger.getInstance();

// Registrando operações
log.info("Iniciando processamento...");
log.error("Erro ao conectar ao banco.");
```

---

## 👨‍💻 Autor

**Vitor Guedes**
