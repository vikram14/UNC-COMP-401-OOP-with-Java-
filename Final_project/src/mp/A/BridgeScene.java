package mp.A;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
@PropertyNames({"Arthur","Galahad", "Guard","Robin","Lancelot","Gorge","KnightArea","GuardArea","Occupied","KnightTurn"})
public class BridgeScene implements BridgeSceneInterface {
	AvatarInterface arthur,galahad,guard,lancelot,robin,interacting_knight;GorgeInterface g; CircleInterface knightArea,guardArea;
	public static final int GUARD_AREA_X=890,KNIGHT_AREA_X=700,KNIGHT_AREA_Y=Gorge.H_BRIDGE_Y,GUARD_AREA_Y=Gorge.H_BRIDGE_Y, ARTHUR_AND_LANCELOT_X=75, ARTHUR_AND_GALAHAD_Y=100,CORRECTION_FACTOR=30,
			GALAHAD_AND_ROBIN_X=195, LANCELOT_AND_ROBIN_Y=350 , LANCELOT_X=75, GUARD_X=920,GUARD_Y=Gorge.H_BRIDGE_Y-100;
	public static final String ARTHUR_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment12\\images\\data\\arthur.jpg",
			GALAHAD_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment12\\images\\data\\galahad.jpg", 
			LANCELOT_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment12\\images\\data\\lancelot.jpg",
			ROBIN_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment12\\images\\data\\robin.jpg",
			GUARD_IMAGEFFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment12\\images\\data\\guard.jpg";
	boolean occupied=false,knight_turn=false,guard_occupied=true;
	PropertyListenerSupportInterface pls= new PropertyListenerSupport();
	public BridgeScene() {
		arthur=new Avatar(new CharacterHead(ARTHUR_IMAGEFILE,ARTHUR_AND_LANCELOT_X,ARTHUR_AND_GALAHAD_Y));
		galahad=new Avatar(new CharacterHead(GALAHAD_IMAGEFILE,GALAHAD_AND_ROBIN_X,ARTHUR_AND_GALAHAD_Y));
		lancelot=new Avatar(new CharacterHead(LANCELOT_IMAGEFILE,LANCELOT_X,LANCELOT_AND_ROBIN_Y));
		robin=new Avatar(new CharacterHead(ROBIN_IMAGEFILE,GALAHAD_AND_ROBIN_X,LANCELOT_AND_ROBIN_Y));
		guard=new Avatar(new CharacterHead(GUARD_IMAGEFFILE,GUARD_X,GUARD_Y));
		g=new Gorge();
		knightArea=new Circle();
		knightArea.setX(KNIGHT_AREA_X);
		guardArea=new Circle();
		guardArea.setX(GUARD_AREA_X);
	}

	public AvatarInterface getArthur() {
		return  arthur;
	}


	public AvatarInterface getGalahad() {
		return galahad;
	}


	public AvatarInterface getGuard() {
		return  guard;
	}


	public AvatarInterface getRobin() {
		return robin ;
	}


	public AvatarInterface getLancelot() {
		return lancelot;
	}

	public GorgeInterface getGorge() {
		return  g;
	}
	public CircleInterface getKnightArea() {
		return knightArea;
	}
	public CircleInterface getGuardArea() {
		return  guardArea;
	}
	public boolean preapproach() {
		return(!occupied);
	}
	public boolean presay() {
		return(interacting_knight!=null && occupied);
	}
	public boolean prepassed() {
		return(interacting_knight!=null && !knight_turn && occupied);
	}
	public boolean prefailed() {
		return(interacting_knight!=null && occupied);
	}
	public void approach(AvatarInterface av) {
		assert preapproach();
		//System.out.println(occupied);
		if (occupied==false) {
			av.move(knightArea.getX()-av.getHead().getX()+CORRECTION_FACTOR,GUARD_Y-av.getHead().getY());
			occupied=true;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","approach", false));
			knight_turn=false;
			interacting_knight=av;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","passed", true));
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","failed", true));
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","say", true));
			
		}
		//System.out.println(occupied);
	}
	public boolean getOccupied() {
		return occupied;
	}
	@Visible(false) 
	public AvatarInterface getInteractingKnight() {
		if(getOccupied())
			return interacting_knight;
		else
			return null;
	}	

	public boolean getKnightTurn() {
		return knight_turn;
	}
	int reply_counter=0;
	public void say(String s) {
		assert presay();
		if(interacting_knight!=null) {
		if(getKnightTurn()) {
			interacting_knight.getStringShape().setText(s);
			determineTurn();reply_counter++;
			System.out.println("K"+knight_turn+" "+occupied+" "+reply_counter+s);
		}
		else {
			guard.getStringShape().setText(s);
			determineTurn();reply_counter++;
			System.out.println("G"+ knight_turn+" "+occupied+" "+reply_counter+s);
		}
		}
	}
	public void passed() {
		assert prepassed();
		if(interacting_knight!=null) {
			//determineTurn();
			if(!knight_turn){
				say("off you go");
				occupied=false;
				pls.notifyAllListeners(new PropertyChangeEvent(this,"this","approach", true));
				knight_turn=false;
				interacting_knight.move(900, 0);
				System.out.println(knight_turn+" "+occupied);
				reply_counter=0;
				interacting_knight=null;
				pls.notifyAllListeners(new PropertyChangeEvent(this,"this","passed", false));
				pls.notifyAllListeners(new PropertyChangeEvent(this,"this","failed", false));
				pls.notifyAllListeners(new PropertyChangeEvent(this,"this","say", false));
			}}
		//;

	}
	private void determineTurn() {
		if (reply_counter%2==0)
			knight_turn=true;
		else
			knight_turn=false;

	}

	public void failed() {
		assert prefailed();
		if(interacting_knight!=null) {
			//determineTurn();
			if(!getKnightTurn()) {
				occupied=false;
				pls.notifyAllListeners(new PropertyChangeEvent(this,"this","approach", true));
				knight_turn=false;
				interacting_knight.move(400, -300);
				//guard.cs.setText("");
			}
			else {
				guard.move(150,300);
				guard_occupied=false;
				//guard.cs.setText("");
			}
			reply_counter=0;
			interacting_knight=null;// change if some asect of animation doesnt seem right
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","passed", false));
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","failed", false));
			pls.notifyAllListeners(new PropertyChangeEvent(this,"this","say", false));			
		}}
	public void scroll(int x,int y) {
		arthur.move(-x,-y);
		galahad.move(-x, -y);
		robin.move(-x, -y);
		guard.move(-x,-y);
		lancelot.move(-x, -y);
		g.move(-x,-y);
		knightArea.move(-x,-y);
		guardArea.move(-x,-y);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		pls.addElement(arg0);
		
	}
	public static void addPropertyChangeListener(AvatarInterface av,PropertyChangeListener pcl) {
		av.addPropertyChangeListener(av.getLegs(),pcl);
		av.addPropertyChangeListener(av.getArms(),pcl);
		av.addPropertyChangeListener(av.getBody(),pcl);
		av.addPropertyChangeListener(av.getStringShape(),pcl);
	}
	public static void addPropertyChangeListenerToBackground(CircleInterface cir,CircleInterface cir1,GorgeInterface go,PropertyChangeListener pcl) {
		cir.addPropertyChangeListener(pcl);
	    cir1.addPropertyChangeListener(pcl);
		go.getEffect3D1().addPropertyChangeListener(pcl);
		go.getEffect3D2().addPropertyChangeListener(pcl);
		go.getEffect3D3().addPropertyChangeListener(pcl);
		go.getEffect3D4().addPropertyChangeListener(pcl);
		go.getEffect3D5().addPropertyChangeListener(pcl);
		go.getHorizontalBottom().addPropertyChangeListener(pcl);
		go.getHorizontalTop().addPropertyChangeListener(pcl);
		go.getVerticalRight().addPropertyChangeListener(pcl);
		go.getVerticalLeft().addPropertyChangeListener(pcl);
	}

	@Override
	public void reset() {
		guardArea.setX(GUARD_AREA_X);
		knightArea.setX(KNIGHT_AREA_X);
		guardArea.setY(GUARD_AREA_Y);
		knightArea.setY(KNIGHT_AREA_Y);
		arthur.getHead().setX(ARTHUR_AND_LANCELOT_X);
		arthur.getHead().setY(ARTHUR_AND_GALAHAD_Y);
		arthur.align();
		galahad.getHead().setX(GALAHAD_AND_ROBIN_X);
		galahad.getHead().setY(ARTHUR_AND_GALAHAD_Y);
		galahad.align();
		robin.getHead().setX(GALAHAD_AND_ROBIN_X);
		robin.getHead().setY(LANCELOT_AND_ROBIN_Y);
		robin.align();
		lancelot.getHead().setX(LANCELOT_X);
		lancelot.getHead().setY(LANCELOT_AND_ROBIN_Y);
		lancelot.align();
		guard.getHead().setX(GUARD_X);
		guard.getHead().setY(GUARD_Y);
		guard.align();
	}
	
}