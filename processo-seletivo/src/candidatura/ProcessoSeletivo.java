package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	public static void main(String[] args) {
		String [] candidatos = {"Maria", "Julia", "Bruno", "Melissa", "Adalberto"};
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	static void entrandoEmContato(String candidatos) {
		int tentativas = 1;
		
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			
			atendeu  = atender();
			continuarTentando = !atendeu;
			
			if(continuarTentando) {
				tentativas++;
			} else {
				System.out.println("Contato realizado com sucesso!");
			}
			
		} while(continuarTentando && tentativas < 3); {
			if(atendeu) {
				System.out.println("Conseguimos contato com o candidato " + candidatos + " na " + tentativas + " tentativa(s)");
			} else {
				System.out.println("Não conseguimos contato com o candidato " + candidatos + ". Tentativas realizadas " + tentativas);
			}
		}
	}
	
	//metodo atender
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		
		String [] candidatos = {"Maria", "Julia", "Bruno", "Melissa", "Adalberto"};
		
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
		
		// capturando o candidato pelo indice
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println("o candidato de numero " + (i + 1) + " eh " + candidatos[i]);
		}
		
		System.out.println("usando a forma foreach");
		
		for(String candidato: candidatos) {
			System.out.println("o candidato selecionado foi " + candidato);
		}
	}
	
	public static void selecaoCandidatos() {
		String [] candidatos = {"Maria", "Julia", "Bruno", "Melissa", "Adalberto", "Jorge", "Roberto", "Julio", "Matheus", "Renata"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println(" O candidato " + candidato + " Solicitou esse valor de salario " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println(" O candidato " + candidato + " foi selecionado para a vaga ");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(Double salarioPretendido) {
		double salario = 2000.0;
		
		if(salario > salarioPretendido) {
			System.out.println("Ligar para o candidado");
		} else if(salario==salarioPretendido) {
			System.out.println("Apresentar contra proposta");
		} else {
			System.out.println("Aguardar outros candidatos");
		}
	}

}
