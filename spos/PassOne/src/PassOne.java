import java.util.*;
import java.io.*;

public class PassOne {
	static LinkedHashMap<String,TableRow>SYMTAB;
	
	public static void main(String[] args) throws Exception{
		SYMTAB = new LinkedHashMap<>();
		
		InstructionTable instr = new InstructionTable();
		String line,code;
		int LC=0,SymIndex=0;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chetan\\eclipse-workspace\\PassOne\\src\\input.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chetan\\eclipse-workspace\\PassOne\\src\\IC.txt"));
		
		while((line = br.readLine()) != null) {
			String parts[] = line.split("\\s+",-1);
			
				// Write IC for START
				if(parts[1].equals("START")) {
					LC = Integer.parseInt(parts[2]);
					code = "(AD,01)\t(C,"+LC+")";
					bw.write(code+"\n");
				}
				// Write IC for END
				if(parts[1].equals("END")) {
					code = "(AD,02)\t";
					bw.write(code+"\n");
				}
				
				
				// Check if it is label/symbol 
				if(!(parts[0].isEmpty())) {
					// if label/symbol is already present in SYMTAB 
					if(SYMTAB.containsKey(parts[0])) {
						SYMTAB.put(parts[0],new TableRow(parts[0],LC,SYMTAB.get(parts[0]).getIndex()));
					}
					else {
						SYMTAB.put(parts[0], new TableRow(parts[0],LC,++SymIndex));
					}
				}

				
				// Check if it is Declaration statement (DC,DS)
				if(parts[1].equals("DC")) {
					parts[2] = parts[2].replace("'", "");
					int constant = Integer.parseInt(parts[2]);
					code = "(DL,01)\t(C,"+constant+")";
					bw.write(code+"\n");
					LC++;
				}
				if(parts[1].equals("DS")) {
					int size = Integer.parseInt(parts[2]);
					code = "(DL,02)\t(C,"+size+")";
					bw.write(code+"\n");
					LC = LC + size;
				}
				
				// Check if it is Imperative statement
				if(instr.getType(parts[1]).equals("IS")) {
					String acode = "";
					code = "(IS,0"+instr.getCode(parts[1])+")\t";
					int j=2;
					while(j<parts.length) {
						parts[j] = parts[j].replace(",","");
						
						// check for RG
						if(instr.getType(parts[j]).equals("RG")) {
							acode = acode + "(RG,0"+instr.getCode(parts[j])+")\t" ;
						}
						else {
							// parts[3] will be symbol
							if(SYMTAB.containsKey(parts[j])){
								int index = SYMTAB.get(parts[j]).getIndex();
								acode = acode + "(S,0"+index+")";
							}
							else {
								SYMTAB.put(parts[j],new TableRow(parts[j],-1,++SymIndex));
								int index=SYMTAB.get(parts[j]).getIndex();
								acode = acode+ "(S,0"+index+")";
							}
						}
						j++;
					}
					code = code + acode;
					bw.write(code+"\n");
					LC++;
			}

			
		}
		br.close();
		bw.close();
		printSymTab();
	}
	
	static void printSymTab() throws Exception{
		BufferedWriter bwr = new BufferedWriter(new FileWriter("C:\\Users\\Chetan\\eclipse-workspace\\PassOne\\src\\SYMTAB.txt"));
		Iterator<String>itr = SYMTAB.keySet().iterator();
		
		System.out.println("Symbol Table\n");
		
		while(itr.hasNext()) {
			String key = itr.next().toString();
			TableRow row = SYMTAB.get(key);
			System.out.println(row.getIndex()+"\t"+row.getSymbol()+"\t"+row.getAddress());
			bwr.write(row.getIndex()+"\t"+row.getSymbol()+"\t"+row.getAddress()+"\n");
		}
		bwr.close();
	}
	
}
