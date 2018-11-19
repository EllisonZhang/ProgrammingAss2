import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class AssExe2 {
	
	static String filePath = null;	
	static FileHandling ellison = null;
	static LetterFrequencies table = null;	
	static MonoAlphabetic cipher = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FileReader readFile = null;
		AssExe2 work = new AssExe2();
		System.out.println("Please enter the keyword:");
		String keyword = s.nextLine();					
// 	comment the first line and uncomment the second, and run the Vignere cipher instead.
		
//		cipher = new MonoAlphabetic(keyword);
		cipher = new Vignere(keyword);			
		
		System.out.println("Please enter the filename :");
		filePath = s.nextLine();				
		if(filePath.charAt(filePath.length()-1)=='P') {
//  read file encode and write file
			work.encodeThisFile();	   // xxxP encode to xxxC
			work.writeFrequencyFile();
		}else if(filePath.charAt(filePath.length()-1)=='C') {
//	read file decode and write file
			work.decodeThisFile();	   // xxxC decode to xxxD
			work.writeFrequencyFile();
		}else {
			System.out.println("Please enter the right name");
		}    
	}
		
	public void encodeThisFile() {
		filePath += ".txt"; 
		ellison = new FileHandling(filePath,cipher);
		ellison.encodeFile();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "C.txt";
		ellison.writeFile(filePath);
		
	}
	public void decodeThisFile() {
		filePath += ".txt"; 
		ellison = new FileHandling(filePath,cipher);
		ellison.decodeFile();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "D.txt";
		ellison.writeFile(filePath);
		table= new LetterFrequencies(filePath);
        String content = table.tableCreate();
//creat a flie called xxxxF.txt ;			
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "F.txt";        
		FileHandling.writeAnyFile(filePath, content);
	}
	public void writeFrequencyFile() {
		table= new LetterFrequencies(filePath);
		String content = table.tableCreate();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "F.txt";         		
		FileHandling.writeAnyFile(filePath, content);
	}
}
