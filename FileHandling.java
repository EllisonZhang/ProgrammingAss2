import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*  this class do everything related to files such as getting the 
    file content, writing a file and encoding/decoding a file.
    We don't need to repeat the things like try, catch, fileWriter, 
    fileReader and so on.    */
public class FileHandling {
	private String filePath;
	private FileReader readFile;
	private Scanner s;
	private MonoAlphabetic cipher;
	private String content= "";

//Constructor1:	tell the FileHandling where is the file and use what cipher
	public FileHandling(String filePath,MonoAlphabetic cipher) {
		setFilePath(filePath);
		setCipher(cipher);
	}
//Constructor2:	tell the FileHandling where is the file 
	public FileHandling(String filePath) {
		setFilePath(filePath);
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setCipher(MonoAlphabetic cipher) {
		this.cipher = cipher;
	}	
	public String getFileContent () {
		try {
			readFile= new FileReader(filePath);
			s = new Scanner (readFile);
			while(s.hasNextLine()) {
				content+= s.nextLine()+"\r\n";
			  }      
			}catch (FileNotFoundException e) {
				System.out.println("wrong address!! file not found.");
			} finally{
				try {
					readFile.close();
				} catch (IOException e) {
					
			    }		
			}			
		return content;
	}
/*	encode all the content in this file and return the encoded content*/
	public String encodeFile () {
		getFileContent();
		String encodedContent ="";
				char[] tokens = content.toCharArray();        // store content in char array
				for(int i=0; i<tokens.length;i++) {
					if(tokens[i]>64&&tokens[i]<91) {
						tokens[i] = cipher.encode(tokens[i]); //if it is upper letter, encode it
					}
					encodedContent+= tokens[i];
				}

		return encodedContent;
	}
	
/*	decode all the content in this file and return the decoded content*/
	public String decodeFile () {
		getFileContent();
		String decodedContent = "";
				char[] tokens = content.toCharArray();        // store content in char array
				for(int i=0; i<tokens.length;i++) {
					if(tokens[i]>64&&tokens[i]<91) {
						tokens[i] = cipher.decode(tokens[i]); //if it is upper letter, encode it
					}
					decodedContent+=tokens[i];
				}
	
		return decodedContent;		
	}

	public void writeAnyFile(String fileName,String content) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {		
			System.out.println("wrong address!! file not found.");
		}		
	}	
}
