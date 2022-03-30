package br.ufsc.atm;

import java.util.HashMap;

public class AtmBusinessRules {

	public enum Note {
		TEN(10),
	    TWENTY(20),
	    FIFTY(50),
		ONE_HUNDRED(100);
		
	    private final int value;

	    private Note(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	private static HashMap<Note, Integer> createNotes() {
    	HashMap<Note, Integer> hashMap = new HashMap<Note, Integer>();
    	hashMap.put(Note.TEN, 0);
    	hashMap.put(Note.TWENTY, 0);
    	hashMap.put(Note.FIFTY, 0);
    	hashMap.put(Note.ONE_HUNDRED, 0);
        return hashMap;
    }
	
	private static HashMap<Note, Integer> atmNotes = createNotes();
	public static HashMap<Note, Integer> getAtmNotes() {
		return atmNotes;
	}
    
	public void addCash(Note note, int quantity) {
		atmNotes.put(note, atmNotes.get(note) + quantity);
	}
	
	private void takeoutCash(Note note, int quantity) {
		atmNotes.put(note, atmNotes.get(note) - quantity);
	}
	
	private int getTotalBalance() {
		int total = 0;
		for(HashMap.Entry<Note, Integer> entry : atmNotes.entrySet())
			total += entry.getKey().getValue() * entry.getValue();
		return total;
	}	
	
	private boolean selectNote(Integer desiredAmount, Note note, HashMap<Note, Integer> notesToTakeOut) {
		if (desiredAmount > 0) {
			int quantityNotes = desiredAmount/note.getValue();
			if (quantityNotes > atmNotes.get(note))
        		quantityNotes = atmNotes.get(note);
	        if (quantityNotes > 0 && atmNotes.get(note) > 0) {
	        	notesToTakeOut.put(note, quantityNotes);
	        	return true;
	        }
	        else
	        	return false;
			}
		else
			return false;
	}
	
	public String cashWithdraw(Integer desiredAmount) {
		if (desiredAmount > getTotalBalance())
			return "There is no cash available for this withdraw.";
		else {
			HashMap<Note, Integer> notesToTakeOut = new HashMap<Note, Integer>();
			
			// the strategy starts by the highest value
			if (selectNote(desiredAmount, Note.ONE_HUNDRED, notesToTakeOut))
				desiredAmount = desiredAmount % Note.ONE_HUNDRED.getValue();
			if (selectNote(desiredAmount, Note.FIFTY, notesToTakeOut))
				desiredAmount = desiredAmount % Note.FIFTY.getValue();
			if (selectNote(desiredAmount, Note.TWENTY, notesToTakeOut))
				desiredAmount = desiredAmount % Note.TWENTY.getValue();
			if (selectNote(desiredAmount, Note.TEN, notesToTakeOut))
				desiredAmount = desiredAmount % Note.TEN.getValue();
			
        	if (desiredAmount == 0) {
        		String notesTakenOut = "";
        		for(HashMap.Entry<Note, Integer> entry : notesToTakeOut.entrySet()) {
        			notesTakenOut += "\n- Note: " + entry.getKey().getValue() + ", Quantity: " + entry.getValue();
        			takeoutCash(entry.getKey(), entry.getValue());
        		}
        		return "Cash withdrawn. Notes taken out: " + notesTakenOut;
        	}
        	else {
        		return "There are not notes available for this operation.";
        	}
		}
	}
}
