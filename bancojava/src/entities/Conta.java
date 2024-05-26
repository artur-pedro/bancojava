package entities;

import application.leituraJava;

public class Conta {
    private int numero;
    private float saldo;
    private int senha;
    public static leituraJava input = new leituraJava();
    
    public Conta() {
    	this.numero = (int) (Math.random()*1000);
		
	}

    public int getNumero() {
        return numero;
    }
    public float getSaldo() {
    	
    	return saldo;
    }

    public boolean setSenha() {
        System.out.print("Digite a nova senha do cliente:");
        int novaSenha = leituraJava.lerInteiro();
        String novaSenhaStr = String.valueOf(novaSenha);
        
        if (novaSenhaStr.length() != 6) {
            System.err.println("A nova senha não tem 6 caracteres.");
            return false;
        }

        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso!!!");
        return true;
    }

    public int getSenha() {
    	
    	return senha;
    }

    public float verificarSaldo(){
        System.out.print("Digite sua senha:");
        int senha = leituraJava.lerInteiro();
        
        if(this.senha == senha) {
            return this.saldo;
        }
        return -1.0f;
    }
    public boolean sacar(float valor) {
        if(valor > 0 && valor <= this.saldo) {
        	System.out.print("Digite sua senha:");
        	int senha = leituraJava.lerInteiro();
            if(senha == this.senha) {
                this.saldo -= valor;
            return true;
            }
        }
        return false;
    }
    public boolean depositar(float valor) {
        System.out.print("Digite sua senha: ");
        int senha = leituraJava.lerInteiro();        
        if (this.senha == senha) {
            if (valor > 0) { // Verifica se o valor é positivo
                this.saldo += valor;
                System.out.println("Depósito efetuado com sucesso.");
                return true;
            } else {
                System.out.println("O valor do depósito deve ser maior que zero.");
            }
        } else {
            System.out.println("Depósito não efetuado. Senha incorreta.");
        }
        return false;
    }
}