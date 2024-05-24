package desafio_banco_digital_OO;

import java.util.Scanner;

public class Banco {

    private Cliente clienteBanco;
    private ContaCorrente contaCorrenteCliente;
    private ContaPoupanca contaPoupancaCliente;
    Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente(String nome, String cpf, int agencia, int conta, double saldo, String tipo) {
        Cliente novoCliente = new Cliente(nome, cpf);
        clienteBanco = novoCliente;
        if (tipo.equalsIgnoreCase("Conta Corrente")) {
            contaCorrenteCliente = new ContaCorrente();
            contaCorrenteCliente.setAgencia(agencia);
            contaCorrenteCliente.setCliente(novoCliente);
            contaCorrenteCliente.setConta(conta);
            contaCorrenteCliente.setSaldo(saldo);
        } else if (tipo.equalsIgnoreCase("Conta Poupança")) {
            contaPoupancaCliente = new ContaPoupanca();
            contaPoupancaCliente.setAgencia(agencia);
            contaPoupancaCliente.setCliente(novoCliente);
            contaPoupancaCliente.setConta(conta);
            contaPoupancaCliente.setSaldo(saldo);
        }
    }

    public void mostrarConta(int conta) {
        System.out.println("Cliente: " + clienteBanco.getNome() + " - CPF: " + clienteBanco.getCpf());
        if (contaCorrenteCliente != null && conta == contaCorrenteCliente.getConta()) {
            System.out.println("  Conta Corrente: Agência " + contaCorrenteCliente.getAgencia() + 
            		", Conta " + contaCorrenteCliente.getConta()+", Saldo "+contaCorrenteCliente.getSaldo());
        } else if (contaPoupancaCliente != null && conta == contaPoupancaCliente.getConta()) {
            System.out.println("  Conta Poupança: Agência " + contaPoupancaCliente.getAgencia() + 
            		", Conta " + contaPoupancaCliente.getConta()+", Saldo "+contaPoupancaCliente.getSaldo());
        }
    }

    public static void main(String[] args) {
    	Banco cliente1 = new Banco();
        Banco cliente2 = new Banco();
        Banco cliente3 = new Banco();
        Banco cliente4 = new Banco();

        String cc = "Conta Corrente";
        String cp = "Conta Poupança";

        cliente1.cadastrarCliente("João Augusto", "106.822.854-75", 1214, 502010400, 200, cc);
        cliente2.cadastrarCliente("José Paulo", "104.500.542-20", 1216, 102050401, 200, cp);
        cliente3.cadastrarCliente("Maria Tereza", "985.652.157-25", 1215, 70402015, 200, cp);
        cliente4.cadastrarCliente("Joaquina Santos", "121.585.525-20", 1211, 205095820, 200, cc);

        cliente1.mostrarConta(502010400);
        String mensagemCliente1 = cliente1.contaCorrenteCliente.sacar();
        System.out.println(mensagemCliente1 + "\n");
        System.out.println("---------------------------------------------------------");
        cliente2.mostrarConta(102050401);
        String mensagemCliente2 = cliente2.contaPoupancaCliente.depositar();
        System.out.println(mensagemCliente2 + "\n");
        System.out.println("---------------------------------------------------------");
        cliente3.mostrarConta(70402015);
        String mensagemCliente3 = cliente3.contaPoupancaCliente.transferir(cliente3.contaPoupancaCliente, cliente4.contaCorrenteCliente);
        System.out.println(mensagemCliente3 + "\n");
        System.out.println("---------------------------------------------------------");
        cliente4.mostrarConta(205095820);
        cliente4.contaCorrenteCliente.extrato();  
        
        
    }
}
