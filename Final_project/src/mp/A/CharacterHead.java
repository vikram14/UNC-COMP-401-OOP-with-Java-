package mp.A;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@ StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X","Y","ImageFileName","Width","Height"})
@Tags("CharacterHead")
public class CharacterHead extends BoundedShape implements ImageShape{
	String imageFileName;
	
	public CharacterHead(String initImageFileName, int initX, int initY) {	
		imageFileName = initImageFileName;
		x = initX;
		y = initY; 
		Icon icon = new ImageIcon(imageFileName);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
	}

	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String newVal) {
		String oldFile=imageFileName;
		imageFileName=newVal;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"File name",oldFile,getImageFileName()));
	}

}
