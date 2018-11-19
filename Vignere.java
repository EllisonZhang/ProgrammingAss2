
public class Vignere extends MonoAlphabetic {
	char[][] cipherArray = null; 
	private int encodePositionInCipherArray = 0;
	private int decodePositionInCipherArray = 0;
	char[] keywordArray = null;
	public Vignere (String keyword) {
		super(keyword);
		VignereArrayGenerate();
	}
// now if the keyword is "A", then the  VignereArray will be alphabet table.
// A.B.C.D.E....... no encode in this way // remain to be solved.
	public char[][] VignereArrayGenerate(){
		keywordArray = super.keywordFormating();
		int position = 0; 
		int number = 0;
		cipherArray = new char[keywordArray.length][26];
// t .....
// i .....
// g .....
// e .....
		for(position=0;position<keywordArray.length;position++) {		
			number = 0;	
		    cipherArray[position][0] = keywordArray[position];
		    for(int i=1;i<26;i++) {	    	
		    	if(cipherArray[position][0]+i>90) {
		    		cipherArray[position][i] = (char)(number+65);
		    		number++;
		    	}else {
		    		cipherArray[position][i] = (char)(cipherArray[position][0]+i);
		    	}
		    }	
		} 
		return cipherArray;
	}
	public char encode(char content) {
		char encodedContent='a';
		int i = encodePositionInCipherArray%cipherArray.length;
        encodedContent = cipherArray[i][content-65];
        encodePositionInCipherArray++;
		return encodedContent;
	} 
	public char decode(char content) {
		char decodedContent='a';
		int i = decodePositionInCipherArray%cipherArray.length;		
		int j=0;
    	for(int pos=0;i<cipherArray[0].length;pos++) {
    		if (content == cipherArray[i][pos]) {
    			break;
    		}
    		j++;
    	}
		decodedContent= (char)(j+65);			
		decodePositionInCipherArray++;
		return decodedContent;
	}

}
