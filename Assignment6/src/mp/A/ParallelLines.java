package mp.A;

public class ParallelLines {
	Line a,b; static final int VERTICAL_LINE_LENGTH=200,HORIZONTAL_LINE_LENGTH=75;
	public ParallelLines() {
		a=new RotatingLine(0.0,0.0,0,0);
		b=new RotatingLine(0.0,0.0,0,0);
	}
	public Line getLeftOrTopLine() {
		a.setRadius(VERTICAL_LINE_LENGTH);
		return a;
	}

	public Line getRightOrBottomLine() {
		b.setRadius(VERTICAL_LINE_LENGTH);
		return b;
	}

}
