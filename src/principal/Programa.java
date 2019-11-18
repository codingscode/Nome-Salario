package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import mais.ContratHora;
import mais.Departamento;
import mais.Trabalhador;
import mais.enums.NivelTrabalho;


public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Nome do Departamento : ");
		String nomedep = sc.nextLine();
		System.out.println("entre com informação do funcionário:");
		System.out.print("Nome: ");
		String nometrab = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		System.out.print("Base salarial: ");
		double baseSalarial = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nometrab, baseSalarial, NivelTrabalho.valueOf(nivel), new Departamento(nomedep) );
		
		System.out.print("Quantos contratos a esse trabalhador? ");
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
		  System.out.println("Entre contrato #" + (i+1) + " informação:");
		  System.out.print("Data (DD/MM/YYYY): ");
		  Date data = sdf.parse(sc.next());
		  System.out.print("Valor por hora: ");
		  double valorhora = sc.nextDouble();
		  System.out.print("Duração(horas): ");
		  int horas = sc.nextInt();
		  ContratHora contrato = new ContratHora(data, valorhora, horas);
		  trabalhador.adicContrato(contrato);	
		}
		
		System.out.println();
		System.out.print("Digite mês e ano para calcular renda (MM/YYYY): ");
		String meseano = sc.next();
		int mes = Integer.parseInt(meseano.substring(0,2)); //recortar a posição acima
		int ano = Integer.parseInt(meseano.substring(3)); // recort posição 3 em diante
		System.out.println("Nome: " + trabalhador.getNometrab());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNomedep());
		System.out.println("Renda de " + meseano + ": " + trabalhador.renda(ano,mes));
		
        sc.close();
	}

}
