/*this class inherit from Mono class 
  It can also encode/decode a single 
  alphabet based on a give KeyWord object*/
public class Vignere extends MonoAlphabetic {
	char[][] encryptionArray; 
	private int encodePositionInCipherArray = 0;
	private int decodePositionInCipherArray = 0;
	public Vignere (KeyWord keyWord) {
		super(keyWord);
		VignereArrayGenerate();
	}

//   Generate an encryption table based on keyword
	public char[][] VignereArrayGenerate(){	 
		int number = 0;
		encryptionArray = new char[keywordArray.length][26]; 
		for(position=0;position<keywordArray.length;position++) {		
			number = 0;	
		    encryptionArray[position][0] = keywordArray[position];     // fill in the first column with keyword
		    for(int i=1;i<26;i++) {	    	                           // fill in every row.(first column already occupied by keyword)
		    	if(encryptionArray[position][0]+i>90) {
		    		encryptionArray[position][i] = (char)(number+65); 
		    		number++;
		    	}else {
		    		encryptionArray[position][i] = (char)(encryptionArray[position][0]+i);
		    	}
		    }	
		} 
		return encryptionArray;
	}
// encode an alphabet and return
	public char encode(char content) {
		char encodedContent=' ';
		int i = encodePositionInCipherArray%encryptionArray.length;
        encodedContent = encryptionArray[i][content-65];
        encodePositionInCipherArray++;
		return encodedContent;
	} 
// encode an alphabet and return
	public char decode(char content) {
		char decodedContent=' ';
		int i = decodePositionInCipherArray%encryptionArray.length;		
		int j=0;
    	for(int pos=0;i<encryptionArray[0].length;pos++) {
    		if (content == encryptionArray[i][pos]) {
    			break;
    		}
    		j++;
    	}
		decodedContent= (char)(j+65);			
		decodePositionInCipherArray++;
		return decodedContent;
	}
}
