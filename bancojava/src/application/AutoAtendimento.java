package application;
import java.util.ArrayList;
import java.util.Scanner;
import entities.Banco;
import entities.Cliente;
//clase autoatendimento
public class AutoAtendimento {
	public static Banco banco; // instanciação do objeto banco da classe Banco.
	public static leituraJava input = new leituraJava();
	//função para cadastrar o Cliente, verifica a senha do gerente e adiciona o cliente ao array
	public static void gerenteCadastrarCliente (Cliente novo, ArrayList<Cliente> clientes, Banco banco) {
		if(novo.getConta().setSenha()) {
			banco.cadastrarCliente(novo);
			System.out.println("Cliente cadastrado com sucesso!");
			System.out.println("O numero da conta eh: " + novo.getConta().getNumero()); // mostra o numero da conta
		}
		else {
			System.out.println("Cliente não cadastrado");
			telagerente(clientes, banco); //se não for cadastrado volta para tela do gerente
		}	
	}
	public static void gerenteExcluirCliente (long CPF,ArrayList<Cliente> clientes, Banco banco) {
		if(banco.excluirCliente(CPF)) {  //faz a verificação do senha do gerente e exclui pelo CPF
			System.out.println("Cliente removido com sucesso");
		}
		else {
			System.out.println("Cliente não removido");
		}	
	}
	public static void gerenteGerarRelatorio () { //itera sobre todos os clientes e mostra o nome do cliente, o saldo de cada um e o saldo total
		float saldoTotal =0; 
		System.out.println("Relatorio da agência: " + AutoAtendimento.banco.getAgencia() + String.format(" de Açailândia"));
		for(Cliente x:  AutoAtendimento.banco.getClientes()) {
			System.out.println(x.getNome() + String.format("    ") + x.getConta().getSaldo());	
		}
		System.out.println();
		System.out.println();
		System.out.println("Total de Clientes: " +  AutoAtendimento.banco.getClientes().size());
		for(Cliente x:  AutoAtendimento.banco.getClientes()) {
			saldoTotal += x.getConta().getSaldo();	
		}
		System.out.println("Saldo total: R$ " +saldoTotal);	
	}	
	public static void clienteSacar (float valor, Cliente x, ArrayList<Cliente> clientes, Banco banco) { //faz  a verificação do valor, compara as senhas e retorna true ou false
		Scanner sc = new Scanner(System.in);
		if(x.getConta().sacar(valor)) {
			System.out.println("Saque efetuado com sucesso");
		}
		else {
			System.out.println("Saque não efetuado");
			System.out.println("Digite algo para voltar: ");
			sc.nextLine();	
		}
		telaCliente(clientes, banco, x);
		sc.close();
	}
	public static void clienteDepositar(float valor, Cliente x, ArrayList<Cliente> clientes, Banco banco) {
		if(x.getConta().depositar(valor)) {
			}
		else {
			System.out.println("Deposito não efetuado");	
		}
		telaCliente(clientes, banco, x);
	}
	public static void clienteVerificarSaldo(Cliente x, ArrayList<Cliente> clientes, Banco banco) { // verifica o saldo do cliente
		Scanner sc = new Scanner(System.in);
		System.out.println("Saldo atual eh: " + x.getConta().verificarSaldo());
		System.out.println("Digite algo para voltar");
		sc.nextLine();
		telaCliente(clientes, banco, x);
		sc.close();
	}
	// Classe menuInicial  onde mostra as opções de logar no banco
	public static void menuInicial(ArrayList<Cliente> clientes, Banco banco) {
			System.out.println("-------- Bem vindo ao banco Açailândia --------");
	        System.out.println(" 1 - Logar como gerente");
	        System.out.println(" 2 - Logar como cliente");
	        System.out.println(" 3 - Sair");
	        int escolha = leituraJava.lerInteiro();
	        switch (escolha) {
            case 1:
            	loginGerente(clientes, banco); // se opção 1 chama a tela de Login do Gerente
            	break;
            case 2:
            	loginCliente(clientes, banco); // se opção 2 chama a tela de Login ddo Cliente	
            	break;
            case 3:
            	System. exit(0); // Se opção 3 sai do código
            default:
            	System.out.println("Entrada inválida"); // Qualquer outra opção mostra a msg de entrada inválida
            	break;
	        }	
	}
	public static void loginCliente(ArrayList<Cliente> clientes, Banco banco) { //tela de login dos clientes
		Scanner sc = new Scanner(System.in);
		System.out.println("Login cliente: ");
        System.out.println("Conta: ");
        int numero = leituraJava.lerInteiro();
        System.out.println("Senha: ");
        int senha = leituraJava.lerInteiro();
        for(Cliente x: banco.getClientes()) {  // verifica o se existe alguém no arrayList dos clientes com as informações passadas 
        	if(x.getConta().getNumero()== numero && x.getConta().getSenha() == senha) {
        		telaCliente(clientes, banco, x);  // se tiver, vai para tela do cliente
        	}
	}
    System.out.println("Dados incorretos ");  
	System.out.println("Digite qualquer tecla para voltar");
    sc.nextLine();
    menuInicial(clientes, banco); // se não estiver ele volta para tela de menuinicial
    sc.close();
	}
	public static void telaCliente(ArrayList<Cliente> clientes, Banco banco, Cliente cliente) { // tela do cliente
			Scanner sc = new Scanner(System.in);
			System.out.println("------ Login efetuado com sucesso -------");
			System.out.println("-----------------------------------------");
	        System.out.println("1 – Sacar");
	        System.out.println("2 – Depositar");
	        System.out.println("3 - Verificar saldo");
	        System.out.println("4 - Sair");
	        int escolha = leituraJava.lerInteiro();
	        switch (escolha) {
	        case 1:
	        	System.out.println("Digite o valor que quer sacar: ");
	        	float valor = leituraJava.lerFloat();  
	        	clienteSacar(valor, cliente, clientes, banco); // chama a função de sacar
	        	break;
	        case 2:
	        	System.out.println("Digite o valor que quer depositar: ");
	        	float valor1 = leituraJava.lerFloat();
	        	clienteDepositar(valor1, cliente, clientes, banco); // chama a função de depositar
	        	break;
			case 3:
				clienteVerificarSaldo(cliente, clientes, banco); // chama a função de verificar saldo
				break;
			case 4:
				menuInicial(clientes, banco);  // volta para a tela inicial
				break;
			default:
				System.out.println("Entrada inválida");
				break;
	        }
			sc.close();			 
	}

	public static void loginGerente(ArrayList<Cliente> clientes, Banco banco) {
		System.out.println("Login gerente: ");
        System.out.println("Agencia: ");
        int agencia = leituraJava.lerInteiro();
        System.out.println("Senha: ");
        int senha = leituraJava.lerInteiro();
        if(banco.getAgencia() == agencia  && banco.getSenhaGerente() == senha) { //verifica se a agencia passada e a senha estão certas
        	System.out.println("Login efetuado: ");
        	telagerente(clientes, banco);
        }
        else {
        	System.out.println("Dados incorretos");
        	menuInicial(clientes, banco);// se não estiver ele repete a tela de menu inicial
        }
	}
	public static void telagerente(ArrayList<Cliente> clientes, Banco banco) { // tela do gerente, onde tenho as opções
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------");
        System.out.println("1 – Cadastrar Cliente");
        System.out.println("2 – Excluir Cliente");
        System.out.println("3 - Gerar relatório");
        System.out.println("4 - Sair");
        int escolha = leituraJava.lerInteiro();
        switch (escolha) {
        case 1:
            System.out.println("Digite o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.println("Digite o CPF do cliente: ");
            long cpf = leituraJava.lerLong();
            for(Cliente x: clientes) {
            	if(x.getCPF() == cpf) {
            		System.out.println("Esse CPF já está cadastrado");
            		telagerente(clientes, banco);
            	}
            }
            Cliente cliente = new Cliente(nome, cpf);
            gerenteCadastrarCliente(cliente, clientes, banco);
            telagerente(clientes, banco);
            break;
        case 2:
            System.out.println("Digite o CPF do cliente: ");
            long cpfExcluir = leituraJava.lerLong();
            gerenteExcluirCliente(cpfExcluir, clientes, banco);
            telagerente(clientes, banco);
            break;
        case 3:
        	 gerenteGerarRelatorio();
        	 System.out.println("Digite algo para continuar: ");
        	 sc.nextLine();
        	 telagerente(clientes, banco); 
        	 break;
        case 4:
            menuInicial(clientes, banco);
            break;
         default:
        	 System.out.println("Entrada inválida");
        	 break;
	}
    sc.close();	}	
	// Main
	public static void main(String[] args) {
	    ArrayList<Cliente> clientes = new ArrayList<Cliente>(); //criação do arraylist dos clientes
	    AutoAtendimento.banco = new Banco(123456, 123456, clientes);    // utilização do construtor do banco
	    menuInicial(clientes, banco);
	    
	                }  		
		}