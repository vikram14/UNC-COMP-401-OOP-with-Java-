package mp;

import util.annotations.Tags;

@Tags("ClearableHistory")
public class ClearableHistory extends TokenHistory implements ClearableHistoryInterface {
	public void clear() {
		size=0;
	}
}
