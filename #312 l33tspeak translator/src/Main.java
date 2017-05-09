import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		HashMap <String, String> map = new HashMap<String, String>();
		Scanner in = new Scanner(System.in);
		
		map.put("Aa", "4");
		map.put("Bb", "6");
		map.put("Ee", "3");
		map.put("Ii", "1");
		map.put("Ll", "1");
		map.put("Mm", "(V)");
		map.put("Nn", "(\\)");
		map.put("Oo", "0");
		map.put("Ss", "5");
		map.put("Tt", "7");
		map.put("Vv", "\\/");
		map.put("Ww", "`//");
		
		HashMap<String, String> mapInversed = new HashMap<String,String>();
		
		mapInversed.put("4", "A");
		mapInversed.put("6", "B");
		mapInversed.put("3", "E");
		mapInversed.put("1", "I");
		mapInversed.put("(V)", "M");
		mapInversed.put("(\\)", "N");
		mapInversed.put("0", "O");
		mapInversed.put("5", "S");
		mapInversed.put("7", "T");
		mapInversed.put("\\/", "V");
		mapInversed.put("`//", "W");
		
		while(in.hasNextLine()){
			String currentLine = in.nextLine();
			String modified = currentLine + " -> ";
			int numbersInString = 0;
			
			for( int i = 0; i < currentLine.length(); i++){
				if(Character.isDigit(currentLine.charAt(i))){
					numbersInString++;
				}
			}
			
			if(numbersInString < currentLine.length()/3){
				for(int i = 0; i < currentLine.length(); i++){
					String currentChar = "" + currentLine.charAt(i);
					for(Entry<String, String> entry: map.entrySet()){
						if(entry.getKey().contains(currentChar)){
							currentChar = entry.getValue();
							break;
						}
					}
					modified += currentChar;
				}
			}else{
				for(int i = 0; i < currentLine.length(); i++){
					String currentChar = "" + currentLine.charAt(i);
					
					if(i < currentLine.length() - 2 && currentChar.equals("(") && currentLine.charAt(i+1) == 'V'){
						i = i + 2;
						modified += "m";
						continue;
					}
					
					if(i < currentLine.length() - 2 && currentChar.equals("(") && currentLine.charAt(i+1) == '\\'){
						i = i + 2;
						modified += "n";
						continue;
					}
					
					if(i < currentLine.length() - 2 && currentChar.equals("\\") && currentLine.charAt(i+1) == '/'){
						i = i + 1;
						modified += "v";
						continue;
					}
					
					if(i < currentLine.length() - 2 && currentChar.equals("`") && currentLine.charAt(i+1) == '/'){
						i = i + 2;
						modified += "w";
						continue;
					}
					
					for(Entry<String, String> entry: mapInversed.entrySet()){
						if(entry.getKey().contains(currentChar)){
							currentChar = entry.getValue();
							break;
						}
					}
					
					modified += currentChar;
					
				}
			}
			System.out.println(modified);
		}
		in.close();
	}
	
}
