package mp.A;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
public interface BridgeSceneInterface {
public Avatar getArthur();
public Avatar getGalahad();
public Avatar getGuard();
public Avatar getRobin();
public Avatar getLancelot();
public Gorge getGorge();
public Circle getKnightArea();
public Circle getGuardArea();
}
