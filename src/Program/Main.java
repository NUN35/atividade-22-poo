package Program;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entities.Registry;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Registry> lista = new ArrayList<>();
		
		while (true) {
		
		System.out.println("1- Adicionar");
		System.out.println("2- Retirar");
		System.out.println("3- Lista");
		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("Informe a placa: ");
			sc.nextLine();
			String placa = sc.nextLine();
			System.out.println();
			Registry registry = new Registry(placa, new Date());
			lista.add(registry);
			
			break;
			
		case 2:
			System.out.print("Informe a placa do veiculo para retirada: ");
			sc.nextLine();
			String buscaPlaca = sc.nextLine();
			Registry reg = null;
			
			for(Registry registro : lista) {
				if(registro.getPlaca().equals(buscaPlaca)) {
					reg = registro;
				}
			}
			
			if(reg == null) {
				System.err.println("Registro nao encontrado!!!");
	
			}else {
				
					reg.setHora_saida(new Date());
					reg.calcularValor();
				
					System.out.println("Valor total: " +reg.getValorTotal());
					lista.remove(reg);
				//dadadad
			}
			
			break;
			
		case 3:
			for(Registry registro : lista) {
				System.out.println(registro);
			}
			break;	

		default:
			System.err.println("Opção invalida!!!");
			
			break;
			}
		}
	}
	
}	
	/*remover buffer
	 private static void clearBuffer(Scanner scanner) {
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	    }*/