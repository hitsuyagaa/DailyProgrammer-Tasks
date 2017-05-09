	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.Scanner;
	
	public class Main {
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
			while(in.hasNextLine()){
				String currentLine = in.nextLine();
				String[] numbers = currentLine.split(" ");
				String smallest = "", biggest = "";
				
				Comparator<String> comp = new Comparator<String>(){
					 public int compare(String o1, String o2) {
						 return (o2 + o1).compareTo(o1 + o2);
					 }
				};
				
				Arrays.sort(numbers,comp);
					 
				for(String s : numbers){
		            biggest = biggest + s;
		            smallest = s + smallest;
		        }
				System.out.println(smallest + " " + biggest);
			}
			in.close();
		}
	}
