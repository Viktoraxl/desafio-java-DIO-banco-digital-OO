package desafio_banco_digital_OO;

public abstract class Contas {
	
	private int agencia;
	private int conta;
	private String tipo;
	private double saldo;
	private Cliente cliente;
	
	public abstract String sacar();
	public abstract String depositar();
	public abstract String transferir(Contas contaOrigem, Contas contaDestino);
	
	public Contas() {
		this.agencia = agencia;
		this.conta = conta;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}	

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}	

	public String getTipo() {
		return tipo;
	}
	
}
