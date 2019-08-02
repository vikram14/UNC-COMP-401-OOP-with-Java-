package mp.A;

import java.beans.PropertyChangeListener;

import util.annotations.PropertyNames;
import util.annotations.Tags;
@PropertyNames({"Legs","Body","Head","StringShape","arms"})
@Tags("Avatar")
public class Avatar implements AvatarInterface {
	static final int INIT_BODY_HEIGHT=75, ZERO=0; static final double ARM_LENGTH=35.0,LEG_LENGTH=50.0, ZERO_D=0.0, INIT_ANGLE=Math.PI/2; static final String EMPTY="";
	ImageShape hd;StringShape cs; AngleShapeInterface arms,legs;Line body; int imageHeight, imageWidth;double bodyHeight=INIT_BODY_HEIGHT;
	double armLength=ARM_LENGTH,legLength=LEG_LENGTH;
	public Avatar(ImageShape ch) {
		hd=ch;
		arms=new AngleShape();
		arms.getLeftLine().setRadius(armLength);
		arms.getRightLine().setRadius(armLength);
		legs= new AngleShape();
		legs.getLeftLine().setRadius(legLength);
		legs.getRightLine().setRadius(legLength);
		cs=new CharacterSpeak(EMPTY,ZERO,ZERO);
		body=new RotatingLine(ZERO_D,ZERO_D,ZERO,ZERO);
		body.setAngle(INIT_ANGLE);
		align();
	}
	public ImageShape getHead() {
		return hd;
	}
	public StringShape getStringShape() {
		return cs;
	}
	public AngleShapeInterface getArms() {
		return arms;
	}
	public AngleShapeInterface getLegs() {
		return legs;
	}
	public Line getBody() {
		return body;
	}
	
	public void scale(double s) {
		bodyHeight*=s;
		arms.getLeftLine().setRadius(s*arms.getLeftLine().getRadius());
		arms.getRightLine().setRadius(s*arms.getRightLine().getRadius());
		legs.getLeftLine().setRadius(s*legs.getLeftLine().getRadius());
		legs.getRightLine().setRadius(s*legs.getRightLine().getRadius());
		hd.setWidth((int)(hd.getWidth()*s));
		hd.setHeight((int)(hd.getHeight()*s));
		/*try {
			resize(hd.getImageFileName(),outputFilePath,(int)(imageHeight*s),(int)(imageWidth*s));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		align();
	}

	@Tags({"move"})
	public void move(int x,int y) {
		/*	arms.move(x, y);
		legs.move(x, y);*/
		hd.setX(hd.getX()+x);
		hd.setY(hd.getY()+y);
		align();
		/*cs.setX(hd.getX()+imageWidth+x);
		cs.setY(hd.getY()+y);*/
	}
	public void align() {
		
			cs.setText(cs.getText());
			cs.setX(hd.getX()+hd.getWidth());
			cs.setY(hd.getY());
			arms.getLeftLine().setX(hd.getX()+hd.getWidth()/2);
			arms.getRightLine().setX(hd.getX()+hd.getWidth()/2);
			arms.getLeftLine().setY(hd.getY()+hd.getHeight());
			arms.getRightLine().setY(hd.getY()+hd.getHeight());
			body.setX(arms.getLeftLine().getX());
			body.setY(arms.getLeftLine().getY());
			body.setRadius((double)bodyHeight);
			legs.getLeftLine().setX(body.getX());
			legs.getRightLine().setX(body.getX());
			legs.getLeftLine().setY(body.getY()+(int)bodyHeight);
			legs.getRightLine().setY(body.getY()+(int)bodyHeight);

		
	}
	
	public void addPropertyChangeListener(Line line, PropertyChangeListener pcl) {
		line.addPropertyChangeListener(pcl);
	}
	public void addPropertyChangeListener(StringShape stringShape, PropertyChangeListener pcl) {
		stringShape.addPropertyChangeListener(pcl);
	}
	@Override
	public void addPropertyChangeListener(AngleShapeInterface angle, PropertyChangeListener pcl) {
		addPropertyChangeListener(angle.getLeftLine(),pcl);
		addPropertyChangeListener(angle.getRightLine(),pcl);
		
	}
	
	/*public void resize(String inputImagePath,
			String outputImagePath, int scaledWidth, int scaledHeight)
					throws IOException {
		// reads input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth,
				scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		// writes to output file
		ImageIO.write(outputImage, "jpg", new File(outputImagePath));
		System.out.println(outputImagePath);
		hd.setImageFileName(outputImagePath);
	}*/
}
