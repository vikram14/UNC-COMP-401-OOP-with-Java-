package mp.A;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
public interface BridgeSceneInterface extends PropertyListenerRegisterer {
	public AvatarInterface getArthur();
	public AvatarInterface getGalahad();
	public AvatarInterface getGuard();
	public AvatarInterface getRobin();
	public AvatarInterface getLancelot();
	public GorgeInterface getGorge();
	public CircleInterface getKnightArea();
	public CircleInterface getGuardArea();
	public void say(String s);
	public void scroll(int x,int y);
	public void failed() ;
	public void passed();
	public void approach(AvatarInterface av);
	public void reset();
	public boolean preapproach();
	public boolean presay();
	public boolean prepassed(); 
	public boolean prefailed() ;
}
