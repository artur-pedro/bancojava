package entities;

import java.util.ArrayList;

import application.leituraJava;

public class Banco {
	private String nome;
	private int agencia;
	private int senhaGerente;
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	

	public Banco(int agencia, int senhaGerente, ArrayList<Cliente> clientes) {
	    if (String.valueOf(agencia).length() != 6) {
	        System.err.println("O número da agência deve ter exatamente 6 dígitos. Não foi possível criar o banco.");
	        return;
	    }
	    this.agencia = agencia;
	    this.senhaGerente = senhaGerente;
	    this.clientes = clientes;
	}
	public String getNome() {
		return nome;
	}

	public int getSenhaGerente() {
		return senhaGerente;
	}

	public Boolean setSenhaGerente(int senhaGerente) {
	    if(String.valueOf(senhaGerente).length() == 6) {
	        this.senhaGerente = senhaGerente;
	        return true;
	    } else {
	        System.out.println("A senha do gerente deve ter exatamente 6 dígitos.");
	        return false;
	        
	}
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public boolean cadastrarCliente(Cliente novo) {
		
		System.out.print("Digite a sua senha de gerente:");
        int senha = leituraJava.lerInteiro();
        if(senha == senhaGerente) {
        	clientes.add(novo);
        	return true;
        }
        return false;
		
		
	}
	public boolean excluirCliente(long CPF) {
		
		System.out.print("Digite a sua senha de gerente:");
        int senha = leituraJava.lerInteiro();
        if(senha == senhaGerente) {
        	return clientes.removeIf(cliente -> cliente.getCPF() == CPF);
        }
        return false;
		
		
	}
	
	

}