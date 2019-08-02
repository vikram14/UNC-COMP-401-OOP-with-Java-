package mp;

public class TokenHistory implements TokenHistoryInterface {
	public static final int MAX_SIZE = 250;

	protected TokenInterface[] contents = new TokenInterface[MAX_SIZE];
	protected int size ;// number of filled elements (protected access)

	public TokenHistory() {
         size=0;
	}

	public TokenHistory(int someParameter) {
		System.out.println("ABaseStringHistory Single-Parameter Constructor Called");
	}

	/*
	 * Number of filled elements
	 */
	public int size() {
		return size;
	}

	public TokenInterface elementAt (int index) {
		return contents[index];
	}

	protected boolean isFull() {
		return size == MAX_SIZE;
	}

	public void addElement(TokenInterface element) {
		if (isFull()) {
			System.out.println("Cannot add item to a full history");
		} else {
			contents[size] = element;
			size++;
		}
	} 
	public boolean memberEndToken() {
		for(int i=0; i<size;i++) {
			if(contents[i] instanceof EndToken)
				return true;
		}
		return false;
			
	}

	@Override
	public String toString() {
		String retVal = "";
		for (int i = 0; i < size; i++) {
			String separator = (i == 0)?"":":";
			retVal += separator + contents[i];
		}	
		return retVal;
	}



}
