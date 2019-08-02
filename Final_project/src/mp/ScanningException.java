package mp;

import java.io.IOException;

import util.annotations.Tags;
@Tags("ScanningException")
public class ScanningException extends IOException {
	public ScanningException(String message) {
		super(message);
	}
}
