package mp;

import util.annotations.Tags;

@Tags("ClearableHistory")
public interface ClearableHistoryInterface extends TokenHistoryInterface {
	public void clear();
}
