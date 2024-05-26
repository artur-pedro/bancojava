package entities;
public class Cliente {
	 private String nome;
	 private long CPF;
	 private Conta conta;
	    public Cliente(String nome, long CPF) {
	        this.nome = nome;
	        this.CPF = CPF;
	        this.conta = new Conta();
	    }
	    public String getNome() {
	        return nome;
	    }
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    public long getCPF() {
	        return CPF;
	    }
	    public void setCPF(long CPF) {
	        this.CPF = CPF;
	    }
		public Conta getConta() {
			return conta;
		}
		public void setConta(Conta conta) {
			this.conta = conta;
		}
	    
}