package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Individual;
import entities.Company;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Individual ind; 
		
		List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();
		
		
		System.out.println("Enter the number of tax payers:");
		int n = sc.nextInt();
		
		
		for(int i = 1 ; i <=n ;i++){
			
			System.out.println("Tax payer # "+i+"data: ");
			System.out.println("Individual or company (i/c)?");
			char res = sc.next().charAt(0);
			
			System.out.println("Name:");
			String name = sc.next();
			
			System.out.println("Anual income:");
			double income = sc.nextDouble();
			
			if(res == 'i'){
				
				System.out.println("Health expenditures:");
				double health = sc.nextDouble();
				
				
				taxPayers.add(new Individual(name, income, health));
			
				
			}else if(res == 'c'){
				System.out.println("Number of employees:");
				int number = sc.nextInt();
				
				taxPayers.add(new Company(name, income, number));
				
				
			}else{
				System.out.println("digitou errado");
			}
			
			
		}
		
		System.out.println("TAXES PAID:");
		double sum = 0 ; 
		for(TaxPayer tp : taxPayers){
			
			double tax = tp.tax();
			System.out.println(tp.getName() +" : $ " +String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println("TOTAL TAXES: $ "+ String.format("%.2f",sum) );
		
		sc.close();
	}

}
