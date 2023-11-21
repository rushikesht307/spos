import java.util.*;

public class InstructionTable {
	HashMap <String,Integer> AD,IS,DL,RG;
	
	public InstructionTable() {
		
		AD = new HashMap<>();
		IS = new HashMap<>();
		DL = new HashMap<>();
		RG = new HashMap<>();
		
		AD.put("START", 1);
		AD.put("END", 2);
		AD.put("ORIGIN", 3);
		AD.put("EQU", 4);
		AD.put("LTORG", 5);
		
		IS.put("ADD",1);
		IS.put("SUB",2);
		IS.put("MUL",3);
		IS.put("MOVER",4);
		IS.put("MOVEM",5);
		IS.put("STOP",0);
		
		DL.put("DC",1);
		DL.put("DS",2);
		
		RG.put("AREG",1);
		RG.put("BREG",2);
		RG.put("CREG",3);
		RG.put("DREG",4);
		
	}
	
	public String getType(String s ) {
		if(AD.containsKey(s))
			return "AD";
		else if(IS.containsKey(s))
			return "IS";
		else if(RG.containsKey(s))
			return "RG";
		else if(DL.containsKey(s))
			return "DL";
		
		return " ";
	}
	
	public Integer getCode(String s) {
		if(AD.containsKey(s))
			return AD.get(s);
		else if(IS.containsKey(s))
			return IS.get(s);
		else if(RG.containsKey(s))
			return RG.get(s);
		else if(DL.containsKey(s))
			return DL.get(s);
		return -1;
	}
}
