package br.ufsc.atm;

import java.util.HashMap;
import java.util.Scanner;

import br.ufsc.atm.AtmBusinessRules.Note;

public class AtmStartMachine {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AtmBusinessRules atmBusiness = new AtmBusinessRules();
		System.out.println("------------------------");
    	System.out.println("Option 1 - Add cash");
		System.out.println("Option 2 - Withdraw cash");
		System.out.println("Select an option:");
		System.out.println("------------------------");
		
		Scanner menu = new Scanner (System.in);
	    while (menu.hasNextLine()) {
			int option = menu.nextInt();
			switch (option) {
				case 1:
					System.out.println("Note:");
					int note = menu.nextInt();
					System.out.println("Quantity:");
					int quantity = menu.nextInt();
					switch (note) {
						case 10:
							atmBusiness.addCash(AtmBusinessRules.Note.TEN, quantity);
							break;
						case 20:
							atmBusiness.addCash(AtmBusinessRules.Note.TWENTY, quantity);
							break;
						case 50:
							atmBusiness.addCash(AtmBusinessRules.Note.FIFTY, quantity);
							break;
						case 100:
							atmBusiness.addCash(AtmBusinessRules.Note.ONE_HUNDRED, quantity);
							break;
						default:
							System.out.println("Invalid note");
							break;	
						}
					printNotes();
					break;
				case 2:
					System.out.println("Type in the amount of cash you wish to withdraw:");
					int desiredAmount = menu.nextInt();
					String message = atmBusiness.cashWithdraw(desiredAmount);
					System.out.println(message);
					printNotes();
					break;
					
				default:
					System.out.println("Invalid option");
					break;	
				}
	    }
	}
	
	 private static void printNotes() {
    	System.out.println("------------------------");
		System.out.println("Updated Note/Quantity");
		for(HashMap.Entry<Note, Integer> entry : AtmBusinessRules.getAtmNotes().entrySet())
			System.out.println(entry.getKey() + ": " + entry.getValue());
		System.out.println("------------------------");
     }
}
