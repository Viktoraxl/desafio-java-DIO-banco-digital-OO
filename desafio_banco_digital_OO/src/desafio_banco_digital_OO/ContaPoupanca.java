package desafio_banco_digital_OO;

import java.util.Scanner;

public class ContaPoupanca extends Contas{

Scanner scan = new Scanner(System.in);
	
	public String sacar() {
		double novoSaldo = getSaldo();
		if (novoSaldo <= 0) {
			return "Saldo insuficiente";
		}else {
			System.out.println("Qual valor deseja sacar na sua Conta Poupança? ");
			double saque = scan.nextDouble();
			if (saque <= novoSaldo) {
				novoSaldo -= saque;
                setSaldo(novoSaldo); // Atualizando o saldo
                return "Saque efetuado com sucesso Sr(a) "+getCliente().getNome()+".\n"
                		+ "O saldo atualizado da sua Conta Poupança é " + novoSaldo;
            } else {
                return "Valor de saque maior que o saldo disponível.";
            }
	}
}
	
	public String depositar() {
		double novoSaldo = getSaldo();
		System.out.println("Qual valor deseja depositar Conta Poupança? ");
		double deposito = scan.nextDouble();		
		novoSaldo += deposito;
		setSaldo(novoSaldo);
		return "Depósito efetuado com sucesso Sr(a) "+getCliente().getNome()+".\n"
			 + "O saldo atualizado da sua Conta Poupança é " + novoSaldo;
	}
	
	public String transferir(Contas contaOrigem, Contas contaDestino) {
		double valorContaOrigem = contaOrigem.getSaldo();
		double valorContaDestino = contaDestino.getSaldo();
		System.out.println("Ola Sr(a) "+contaOrigem.getCliente().getNome()+ ", digite o valor da transferencia da sua Conta"
				+ " Poupança para a conta do Sr(a) :"+contaDestino.getCliente().getNome());
		double transferencia = scan.nextDouble();
		if (transferencia < valorContaOrigem) {
			valorContaOrigem -= transferencia;
			valorContaDestino += transferencia;
			contaOrigem.setSaldo(valorContaOrigem); // Atualizando o saldo da conta origem
            contaDestino.setSaldo(valorContaDestino); // Atualizando o saldo da conta destino           
			return "Transferencia realizada com sucesso Sr(a). "+getCliente().getNome()+"\n"
					+ "O saldo atualizado da Conta do "+contaOrigem.getCliente().getNome()+" é: "+ valorContaOrigem+"\n"
					+ "E o saldo atualizado na Conta do "+ contaDestino.getCliente().getNome()+" é : "+ valorContaDestino;
		}else {
			return "Saldo indisponível ";
		}
	}
	
	public void extrato() {
		System.out.println("Saldo atual Conta Poupança: "+getSaldo());
	}	
}