package mp.A;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@ StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X","Y","ImageFileName","Width","Height"})
public class CharacterHead implements ImageShape{
	 String imageFileName;
     int x, y,width,height;
     
public CharacterHead(String initImageFileName, int initX, int initY) {	
	imageFileName = initImageFileName;
	x = initX;
	y = initY; 
	Icon icon = new ImageIcon(imageFileName);
	setHeight(icon.getIconHeight());
	setWidth(icon.getIconWidth());
    }

	public int getX() {
		return x;
	}

	
	public void setX(int newX) {
		x=newX;
	}

	
	public int getY() {
		return y;
	}

	
	public void setY(int newY) {
        y=newY;		
	}

	
	public String getImageFileName() {
		return imageFileName;
	}

	
	public void setImageFileName(String newVal) {
		imageFileName=newVal;
	}
	public int getWidth() {return width;}
	public void setWidth(int newVal) {width = newVal;}
	public int getHeight() {return height;}
	public void setHeight(int newVal) {height = newVal;}

}
