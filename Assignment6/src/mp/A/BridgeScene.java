package mp.A;

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
	static final int GUARD_AREA_X=890,KNIGHT_AREA_X=700,ARTHUR_AND_LANCELOT_X=75, ARTHUR_AND_GALAHAD_Y=100,CORRECTION_FACTOR=30,
			GALAHAD_AND_ROBIN_X=195, LANCELOT_AND_ROBIN_Y=350 , LANCELOT_X=75, GUARD_X=920,GUARD_Y=Gorge.hbridgeY-100;
	static final String ARTHUR_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment6\\images\\data\\arthur.jpg",
			GALAHAD_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment6\\images\\data\\galahad.jpg", LANCELOT_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment6\\images\\data\\lancelot.jpg",
			ROBIN_IMAGEFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment6\\images\\data\\robin.jpg",
			GUARD_IMAGEFFILE="C:\\Users\\vikram14\\eclipse-workspace\\Assignment6\\images\\data\\guard.jpg";
	boolean occupied=false,knight_turn=false,guard_occupied=true;
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

	public Avatar getArthur() {
		return (Avatar) arthur;
	}


	public Avatar getGalahad() {
		return (Avatar) galahad;
	}


	public Avatar getGuard() {
		return (Avatar) guard;
	}


	public Avatar getRobin() {
		return (Avatar) robin ;
	}


	public Avatar getLancelot() {
		return (Avatar) lancelot;
	}

	public Gorge getGorge() {
		return (Gorge) g;
	}
	public Circle getKnightArea() {
		return (Circle) knightArea;
	}
	public Circle getGuardArea() {
		return (Circle) guardArea;
	}
	public void approach(Avatar av) {
		System.out.println(occupied);
		if (occupied==false) {
		av.move(knightArea.getX()-av.getHead().getX()+CORRECTION_FACTOR,GUARD_Y-av.getHead().getY());
		occupied=true;
		knight_turn=false;
		interacting_knight=av;
		}
	}
	public boolean getOccupied() {
		return occupied;
	}
	@Visible(false) 
	public Avatar getInteractingKnight() {
		if(getOccupied())
			return (Avatar) interacting_knight;
		else
			return null;
	}	

	public boolean getKnightTurn() {
		return knight_turn;
	}
	int reply_counter=0;
	public void say(String s) {
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
	public void passed() {
		
		//determineTurn();
		if(!knight_turn){
			say("off you go");
			occupied=false;
			knight_turn=false;
			interacting_knight.move(900, 0);
			System.out.println(knight_turn+" "+occupied);
			reply_counter=0;
		}
		//;
		

	}
	private void determineTurn() {
		if (reply_counter%2==0)
			knight_turn=true;
		else
			knight_turn=false;

	}

	public void failed() {
		//determineTurn();
		if(!getKnightTurn()) {
			occupied=false;
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
	}
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
}
