import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LetterFrequencies {
	private String content = "";
	private String filePath = null;
	private String[] table = new String[5];
	private int[] Alphabet = new int[26];  // use to store the frequency of each alphabet
	private FileReader readFile = null;
	private Scanner s = null;
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
		                           0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
			                       6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};
	public LetterFrequencies(String filePath) {
		setFilePath(filePath);
		Alphabet=frequecyCalculate ();
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
//this method calculate frequency of each alphabet in the file. 
//	and store the results in Alphabet[]  Array
	public int[] frequecyCalculate () {
		String Content = "";
		try {
			readFile= new FileReader(filePath);
			s = new Scanner (readFile);
			while(s.hasNextLine()) {                          // read line by line
				Content = s.nextLine();
				char[] tokens = Content.toCharArray();        // store content in char array
				for(int i=0; i<tokens.length;i++) {
					if(tokens[i]>64&&tokens[i]<91) {          // choose the upper case
						for(int j=65; j<91;j++) {             // find that letter(A,B,C,D...)
							if((int)tokens[i]==j) {
								Alphabet[j-65]++;                // frequency of letter +1
							}
						}
					}		
				}
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		  } 
		return Alphabet;		
	}
	public int sumOfFrequency(int[] Alphabet) {
		int j = 0;
		for(int i=0; i<Alphabet.length;i++) {
		    j+= Alphabet[i];
		}
		return j;
	}
	public int maxPosition(int[] Alphabet) {
		int max = 0;
		max = Alphabet[0];
		int pos =0;
		for(int i=0; i<Alphabet.length;i++) {
		    if (Alphabet[i]>max) {
		    	max = Alphabet[i];
		    	pos = i;
		    }
		}
		return pos;
	}
	public String tableCreate() {
		double sum = sumOfFrequency(Alphabet);
		int pos = maxPosition(Alphabet);
		content+="LETTER ANALYSIS"+"\r\n"+"\r\n"
		       + "Letter"+"  "
			   + "Freq"+"  "
			   + "Freq%"+"  "
		       + "AvgFreq"+"  "
			   + "Diff"+"  "
		       + "\r\n";
		String freq,Diff;
		for(int i=0;i<26;i++) {
			freq = String.format("%.1f",(Alphabet[i]/sum)*100);
			Diff = String.format("%.1f",(Alphabet[i]/sum-avgCounts[i]));
			content+= Character.toString((char)(i+65))+"       "
		           + Alphabet[i]+"    "
		           + freq+"%    "
				   + avgCounts[i]+"%  " 
				   + Diff +"%    "
		           +"\r\n";
		}
		
		content+= "the most frequent letter is "
		       +  Character.toString((char)(pos+65))
		       +  " at " +String.format("%.2f",(Alphabet[pos]/sum)*100)+"%" ;
		return content;
	}
   
}
