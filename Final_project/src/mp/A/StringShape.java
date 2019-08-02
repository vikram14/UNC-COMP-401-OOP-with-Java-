package mp.A;

import util.annotations.Tags;

@Tags("CharacterSpeak")
public interface StringShape extends LocatableInterface {
    public String getText() ;  
    public void setText(String newVal); 
}
