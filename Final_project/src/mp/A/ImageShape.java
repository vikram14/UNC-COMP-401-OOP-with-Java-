package mp.A;

import util.annotations.Tags;

@Tags("CharacterHead")
public interface ImageShape extends BoundedShapeInterface{
    public String getImageFileName() ;  
    public void setImageFileName(String newVal);    
}
