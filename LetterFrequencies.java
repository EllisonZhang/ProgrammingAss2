public class LetterFrequencies {
	
	double sum = 0.0;  // quantity of the alphabets in file (it is used in calculating frequency)
	int pos = 0;       
	private String tableOfFrequency = "";
	private String filePath = null;
	private int[] Alphabet = new int[26];   // use to store the frequency of each alphabet
	private FileHandling process = null;
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
		                           0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
			                       6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};
	public LetterFrequencies(String filePath) {
		setFilePath(filePath);
		Alphabet=frequecyCalculate ();
	}
	
	public String tableCreate() {
		this.generateTableFrame();
		this.tableCalculation();
		return tableOfFrequency;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileContent() {
		this.process = new FileHandling (filePath);
		String content = process.getFileContent();
		return content;
	}
//this method calculate frequency of each alphabet in the file. 
//	and store the results in Alphabet[]  Array
	public int[] frequecyCalculate () {
		char[] tokens = getFileContent().toCharArray();        // store content of this file in char array
		for(int i=0; i<tokens.length;i++) {
			if(tokens[i]>64&&tokens[i]<91) {                 // choose the upper case
				for(int j=65; j<91;j++) {                    // find that letter(A,B,C,D...)
					if((int)tokens[i]==j) {
						Alphabet[j-65]++;                    // frequency of letter +1
					}
				}
			}		
		}
		return Alphabet;		
	}
	
	public int sumOfFrequency(int[] Alphabet) {
		int j = 0;
		for(int obj:Alphabet) {
		    j+= obj;
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
	
	public void generateTableFrame() {
		sum = sumOfFrequency(Alphabet);
		pos = maxPosition(Alphabet);
		tableOfFrequency+="LETTER ANALYSIS"+"\r\n"+"\r\n"
		       + "Letter"+"  "
			   + "Freq"+"  "
			   + "Freq%"+"  "
		       + "AvgFreq"+"  "
			   + "Diff"+"  "
		       + "\r\n";
	}
	
	public void tableCalculation() {
		String freq,Diff;
		for(int i=0;i<26;i++) {
			freq = String.format("%.1f",(Alphabet[i]/sum)*100);
			Diff = String.format("%.1f",(Alphabet[i]/sum-avgCounts[i]));
			tableOfFrequency+= Character.toString((char)(i+65))+"       "
		           + Alphabet[i]+"    "
		           + freq+"%    "
				   + avgCounts[i]+"%  " 
				   + Diff +"%    "
		           +"\r\n";
		}		
		tableOfFrequency+= "the most frequent letter is "
		       +  Character.toString((char)(pos+65))
		       +  " at " +String.format("%.2f",(Alphabet[pos]/sum)*100)+"%" ;
	}

}
