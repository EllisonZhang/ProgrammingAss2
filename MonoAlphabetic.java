public class MonoAlphabetic {
	
	private char[] encryptionArray = new char[26];
	private String keyword;
	char[] keywordArray = null;
// constructor: create an encryption Array according to the give keyword
	public MonoAlphabetic(String keyword){
		setUpKeyword(keyword);
		keywordCheck();
		encryptionArrayGenerate();
	}
// I think a keyword set up method should be private, 
// in case someone changed it from outside. keyword can't be changed!!!
// but must be an alphabet  and no repeat 
    private void setUpKeyword(String keyword) {
        //    	repeat and legal check??????????
    	this.keyword = keyword;
    	keywordArray = keywordFormating();
    }	
// user can put keyword in either upper or lower case,
    public char[] keywordFormating() {
    	char[] keywordArray = keyword.toCharArray();  
    	for(int i=0;i<keywordArray.length;i++) {
    		if(keywordArray[i]>96&&keywordArray[i]<123) {
    			keywordArray[i] = (char) (keywordArray[i]-32);		
    		}
   	    }
    	return keywordArray;
    }
    
    public void keywordCheck() {
    	for(int i=0;i<keywordArray.length;i++) {
    		if(keywordArray[i]<65||keywordArray[i]>90) {
				System.out.println("warning!must be alphabetic characters");
				while(true) {
				}
    		}
    		for(int j=i+1;j<keywordArray.length;j++) {
    			if(keywordArray[i]==keywordArray[j]) {
    				System.out.println("No repeated alphabet in keyword, start the program again");
    				while(true) {
    				}
    			}
    		}
    	}
    }
     
    public char[] encryptionArrayGenerate() {   	
    	int position = 0;
		int number = 65;   		
        // The initial positions are occupied by the keyword
    	for(position=0;position<keywordArray.length;position++) {
            encryptionArray[position] = keywordArray[position];
    	}    	
        //the remaining positions are occupied by any characters not in the keyword
    	for(;position<encryptionArray.length;position++){	
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
 // assume content is already a upper case
    public char encode(char content) {
    	char encodedContent='a';
        encodedContent = encryptionArray[content-65];
    	return encodedContent;
    }
 // assume content is already a upper case
    public char decode(char content) {
    	char decodedContent='a';
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
