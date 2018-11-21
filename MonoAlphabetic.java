/*this class can encode/decode a single alphabet 
  based on a give KeyWord object*/

public class MonoAlphabetic {
	private char[] encryptionArray = new char[26];
	protected char[] keywordArray;
	protected int position = 0;
	
// constructor: create an encryption Array according to the give keyword
	public MonoAlphabetic(KeyWord keyWord){
		keywordArray = keyWord.GetKeywordArray();
		encryptionArrayGenerate();
	}
//Generate an encryption table
    public char[] encryptionArrayGenerate() {   	
		int number = 65;   		
    	for(position=0;position<keywordArray.length;position++) {  //put keyword in front.
            encryptionArray[position] = keywordArray[position];
    	}    	       
    	for(;position<encryptionArray.length;position++){	       //the remaining positions       
    		 int i = 0;
    		 while(true) {    			 
    			 if(number==keywordArray[i]) {
    				 number++;
    				 i=0;
    				 continue;  				
    			 }   
    			 i++;
    			 if(i>keywordArray.length-1) {
    				 break;
    			 }
    		 }		
             encryptionArray[position] = (char)number;
    		 number++;  	        	
        }
    	return encryptionArray;
    }
// encode an alphabet and return
    public char encode(char content) {
    	char encodedContent;
        encodedContent = encryptionArray[content-65];
    	return encodedContent;
    }
// decode an alphabet and return
    public char decode(char content) {
    	char decodedContent;
    	int j=0;
    	for(int i=0;i<encryptionArray.length;i++) {
    		if (content == encryptionArray[i]) {
    			break;
    		}
    		j++;
    	}
    	decodedContent = (char)(j+65);
    	return decodedContent;
    }
}
