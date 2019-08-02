package mp.A;

import util.annotations.Tags;

@Tags({"Angle"})
public interface AngleShapeInterface {
	public Line getLeftLine();
	public Line getRightLine();
	public void move(int xdir, int ydir);
}
