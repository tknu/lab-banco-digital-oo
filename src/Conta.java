
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente para sacar");
		}
		saldo -= valor;
		Log.log(String.format("Saque realizado com sucesso: %.2f na conta %d", valor, this.numero));
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		Log.log(String.format("Depósito realizado com sucesso: %.2f na conta %d", valor, this.numero));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente para transferir");
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		Log.log(String.format("Transferência realizada com sucesso: %.2f na conta", valor, this.numero));
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
