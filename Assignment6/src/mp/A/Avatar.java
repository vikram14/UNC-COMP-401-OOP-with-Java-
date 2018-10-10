package mp.A;

import util.annotations.PropertyNames;
import util.annotations.Tags;
@PropertyNames({"Legs","Body","Head","StringShape","arms"})
public class Avatar implements AvatarInterface {
	ImageShape hd;StringShape cs; AngleShapeInterface arms,legs;Line body; int imageHeight, imageWidth;double bodyHeight=75;
	double armLength=35.0,legLength=50.0; String outputFilePath="C:\\Users\\vikram14\\Pictures\\resised.jpg";
	public Avatar(CharacterHead ch) {
		hd=ch;
		arms=new AngleShape();
		arms.getLeftLine().setRadius(armLength);
		arms.getRightLine().setRadius(armLength);
		legs= new AngleShape();
		legs.getLeftLine().setRadius(legLength);
		legs.getRightLine().setRadius(legLength);
		cs=new CharacterSpeak("",0,0);
		body=new RotatingLine(0.0,0.0,0,0);
		body.setAngle(Math.PI/2);
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
		
			/*BufferedImage bi= ImageIO.read(new File(hd.getImageFileName()));
			imageHeight=bi.getHeight();
			imageWidth=bi.getWidth();*/
			cs.setText(cs.getText());
			cs.setX(hd.getX()+hd.getWidth());
			cs.setY(hd.getY());
			//arms=new AngleShape();
			arms.getLeftLine().setX(hd.getX()+hd.getWidth()/2);
			arms.getRightLine().setX(hd.getX()+hd.getWidth()/2);
			arms.getLeftLine().setY(hd.getY()+hd.getHeight());
			arms.getRightLine().setY(hd.getY()+hd.getHeight());
			body.setX(arms.getLeftLine().getX());
			body.setY(arms.getLeftLine().getY());
			body.setRadius((double)bodyHeight);
			//legs= new AngleShape();
			legs.getLeftLine().setX(body.getX());
			legs.getRightLine().setX(body.getX());
			legs.getLeftLine().setY(body.getY()+(int)bodyHeight);
			legs.getRightLine().setY(body.getY()+(int)bodyHeight);

		
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
