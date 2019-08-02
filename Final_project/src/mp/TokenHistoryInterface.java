package mp;

public interface TokenHistoryInterface {
	public void addElement(TokenInterface element);
	public TokenInterface elementAt (int index); 
	public int size();
	public boolean memberEndToken();
}
