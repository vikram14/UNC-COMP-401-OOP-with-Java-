package mp.A;

import util.annotations.Tags;

@Tags("Circle")
public interface CircleInterface extends BoundedShapeInterface {
	public void move(int i, int j);
}
