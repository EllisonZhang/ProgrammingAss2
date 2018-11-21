
import java.util.Scanner;
public class AssExe2 {	
	static String filePath = null;	
	static FileHandling fileHandle = null;           //use this to decode/encode/write file
	static LetterFrequencies frequencytable = null;	
	static MonoAlphabetic cipher = null;
	static Scanner s = new Scanner(System.in);	
	String content;
	public static void main(String[] args) {
		inputName();
		System.out.println("Please enter the keyword:");
		KeyWord keyword = new KeyWord(s.nextLine());
// 	comment the first line and uncomment the second, and run the Vignere cipher instead.
		
//		cipher = new MonoAlphabetic(keyword);
		cipher = new Vignere(keyword);			
		if(filePath.charAt(filePath.length()-1)=='P') {
			encodeThisFile();	   // xxxP encode to xxxC
			writeFrequencyFile();
		}else if(filePath.charAt(filePath.length()-1)=='C') {
			decodeThisFile();	   // xxxP decode to xxxD
			writeFrequencyFile();
		}
	}
		
	public static void encodeThisFile() {
		filePath += ".txt"; 
		fileHandle = new FileHandling(filePath,cipher);
		String encodeContent = fileHandle.encodeFile();
		fileHandle.encodeFile();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "C.txt";
		fileHandle.writeAnyFile(filePath, encodeContent);
		System.out.println(filePath+" file were created");
	}
	public static void decodeThisFile() {
		filePath += ".txt"; 
		fileHandle = new FileHandling(filePath,cipher);
		String decodeContent = fileHandle.decodeFile();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "D.txt";
		fileHandle.writeAnyFile(filePath, decodeContent);
		System.out.println(filePath+" file were created");
	}
//create a  xxxxF.txt frequencies file ;	
	public static void writeFrequencyFile() {
		frequencytable = new LetterFrequencies(filePath);
		String fequencyContent = frequencytable.tableCreate();
		filePath=filePath.substring(0,filePath.length()-5);
		filePath += "F.txt";         		
		fileHandle.writeAnyFile(filePath, fequencyContent);
		System.out.println(filePath+" file were created");
	}
	public static void inputName() {
		boolean check = true;
		while (check) {
			System.out.println("Please enter the filename :");
			filePath = s.nextLine();	
			if(filePath.charAt(filePath.length()-1)!='P'&&
			    filePath.charAt(filePath.length()-1)!='C') {
				System.out.println("Please enter the right name format (xxxP or xxxC)");
			}else {
				check = false;
			}
		}		
	}
}
