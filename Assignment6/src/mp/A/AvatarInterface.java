package mp.A;

public interface AvatarInterface {

	public ImageShape getHead();
	public StringShape getStringShape();
	public AngleShapeInterface getArms();
	public AngleShapeInterface getLegs();
	public Line getBody();
	public void scale(double s);
	public void align();
	public void move(int x,int y);
}
