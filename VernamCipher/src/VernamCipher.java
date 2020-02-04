import java.lang.Math;
public class VernamCipher {
	
	public VernamCipher(){
		
	}
	public char[] encrypt(char[] originalText,char[] encryptionKey) {
		for(int i=0; i<originalText.length; i++) {
			char encryptedText = originalText[i]^encryptionKey[i];
		}
	
	}
	public char[] createKey(char[] originalText) {
		// random letters 
		
	}
}
