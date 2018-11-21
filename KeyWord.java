// this keyword class can automatically check if the keyword
// is in right format and store the keyword into a char array
public class KeyWord {
	  private String keywordContent;
	  private char[] keywordArray;	  
	  public KeyWord(String keywordContent) {
		  setUpKeyword(keywordContent);
		  keywordFormating();
		  CheckIsAlphabet();
		  CheckRepeat();
	  }
	  public void setUpKeyword(String keywordContent){  
	    	this.keywordContent = keywordContent;
	  }
	  public char[] GetKeywordArray(){  
	    	return keywordArray;
	  }
// keywordFormating() will change the lower case in keyword
// to upper case and return every alphabets as an array.
// User can input a keyword in either upper or lower case,
//        "Tiger" will be changed to "TIGER"	  
	  public void keywordFormating() {
	    	keywordArray = keywordContent.toCharArray();  
	    	for(int i=0;i<keywordArray.length;i++) {
	    		if(keywordArray[i]>96&&keywordArray[i]<123) {
	    			keywordArray[i] = (char) (keywordArray[i]-32);		
	    		}
	   	    }
	  }
// make sure keyword is comprised by alphabets
	  public void CheckIsAlphabet() {
	    	for(int i=0;i<keywordArray.length;i++) {
	    		if(keywordArray[i]<65||keywordArray[i]>90) {
					System.out.println("warning!must be alphabetic characters");
					while(true) {
					}
	    		}
	    	}
	  }
// make sure no repeated alphabets in keyword, stop the program if there is.
	  public void CheckRepeat() {
		  for(int i=0;i<keywordArray.length;i++) {
			  for(int j=i+1;j<keywordArray.length;j++){		  
		  		 if(keywordArray[i]==keywordArray[j]) {
		  		    System.out.println("No repeated alphabet in keyword, start the program again");
		  			while(true) {
		  			}
		  		 }
		  	  }
		  }		  
	  }
	  
}
