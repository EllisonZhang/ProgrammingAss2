import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//  function : encode/decode a file (give a filePath) using a given cipher (Vignere/MonoAlphabetic)
public class FileHandling {
	private String filePath = null;
	private FileReader readFile = null;
	private Scanner s = null;
	private MonoAlphabetic cipher = null;
	private String content ="";
//	tell the FileHandling where is the file and use what cipher
	public FileHandling(String filePath,MonoAlphabetic cipher) {
		setFilePath(filePath);
		setCipher(cipher);
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setCipher(Vignere cipher) {
		this.cipher = cipher;
	}public void setCipher(MonoAlphabetic cipher) {
		this.cipher = cipher;
	}
	
	public String encodeFile () {
		String encodeContent = "";
		try {
			readFile= new FileReader(filePath);
			s = new Scanner (readFile);
			while(s.hasNextLine()) {                          // read line by line
				encodeContent = s.nextLine();
				char[] tokens = encodeContent.toCharArray();        // store content in char array
				for(int i=0; i<tokens.length;i++) {
					if(tokens[i]>64&&tokens[i]<91) {
						tokens[i] = cipher.encode(tokens[i]); //if it is upper letter, encode it
					}
					content+=tokens[i];
				}
				content+="\r\n";
			}			
		} catch (FileNotFoundException e) {
			System.out.println("wrong address!! file not found.");
//			e.printStackTrace();
		} finally{
			try {
				readFile.close();
			} catch (IOException e) {
//				e.printStackTrace();
				
			}
		}	
		return content;
	}
	public String decodeFile () {
		String decodeContent = "";
		try {
			readFile= new FileReader(filePath);
			s = new Scanner (readFile);
			while(s.hasNextLine()) {                          // read line by line
				decodeContent = s.nextLine();
				char[] tokens = decodeContent.toCharArray();        // store content in char array
				for(int i=0; i<tokens.length;i++) {
					if(tokens[i]>64&&tokens[i]<91) {
						tokens[i] = cipher.decode(tokens[i]); //if it is upper letter, encode it
					}
					content+=tokens[i];
				}
				content+="\r\n";
			}			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("wrong address!! file not found.");
		} finally{
			try {
				readFile.close();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}	
		return content;		
	}
	public void writeFile(String fileName) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {	
			System.out.println("wrong address!! file not found.1");
		}		
	}
	static void writeAnyFile(String fileName,String content) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {			
		}		
	}	
}
