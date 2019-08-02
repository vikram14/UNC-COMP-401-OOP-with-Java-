package mp;

import util.annotations.Tags;

@Tags({"ScannerBeanClass"})
public interface ScannerBeanInterface {
	public void setScannedString(String newStr) throws ScanningException;
	public String getScannedString();
	public ClearableHistoryInterface getTokenList();
	public TokenInterface[] getTokens();
}
