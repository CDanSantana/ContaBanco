import java.io.Console;

public class ContaTerminal {

    class Cliente {
        private String nomeCliente;
        private String numeroAgencia;
        private int numeroConta;
        private double saldoCliente;

        // * TO DO * construtor em branco da classe
        public Cliente() {
        }

        // * TO DO * Getter e setter para os campos da classe
        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getNumeroAgencia() {
            return numeroAgencia;
        }

        public void setNumeroAgencia(String numeroAgencia) {
            this.numeroAgencia = numeroAgencia;
        }

        public int getNumeroConta() {
            return numeroConta;
        }

        public void setNumeroConta(int numeroConta) {
            this.numeroConta = numeroConta;
        }

        public double getSaldoCliente() {
            return saldoCliente;
        }

        public void setSaldoCliente(double saldoCliente) {
            this.saldoCliente = saldoCliente;
        }

        // * TO DO * método para formatar o saldo do cliente
        public String getSaldoFormatado() {
            return "R$ " + String.format("%.2f", saldoCliente);
        }
    }

    private static String validarEntrada(Console console, String mensagemDeEntrada, String regex, String mensagemDeErro) {
        while (true) {
            String entrada = console.readLine(mensagemDeEntrada + "(insira um * para cancelar)");
            if (entrada.matches(regex)) {
                return entrada;
            } else if(entrada.contains("*")) {
                System.out.println("Ok. Cancelando...");
                System.exit(1);
            } else {
                System.out.println(mensagemDeErro);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo(a)!");
        Console console = System.console();
        if (console == null) {
            System.err.println("Erro: console não está disponível");
            System.exit(1);
        }
        ContaTerminal contaTerminal = new ContaTerminal();
        Cliente cliente = contaTerminal.new Cliente();

        cliente.setNomeCliente(validarEntrada(console, "Digite o nome do cliente: ", "[a-zA-Z|| ]+", "Nome inválido. O nome deve conter apenas letras e espaços."));
        cliente.setNumeroAgencia(validarEntrada(console, "Digite o número da agência: ", "[0-9\\-]+", "Número de agência inválido. A agência deve conter apenas números e '-'"));
        cliente.setNumeroConta(Integer.parseInt(validarEntrada(console, "Digite o número da conta: ", "[0-9]+", "Número de conta inválido. A conta deve conter apenas números.")));
        cliente.setSaldoCliente(Double.parseDouble(validarEntrada(console, "Digite o saldo disponível: ", "\\d+(\\.\\d+)?", "Saldo inválido. Insira um valor numérico válido.")));

        System.out.println("Olá " + cliente.getNomeCliente() + ", obrigado por criar uma conta em nosso banco!");
        System.out.println("Sua agência é " + cliente.getNumeroAgencia() + ", conta " + cliente.getNumeroConta() + ".");
        System.out.println("Seu saldo " + cliente.getSaldoFormatado() + " já está disponível para saque.");
    }
}
