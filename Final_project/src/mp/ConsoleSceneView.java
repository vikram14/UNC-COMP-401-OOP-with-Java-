package mp;

import java.beans.PropertyChangeEvent;


import mp.A.AvatarInterface;
import mp.TableInterface;
import mp.A.BridgeSceneInterface;

public class ConsoleSceneView implements ConsoleSceneViewInterface {
    BridgeSceneInterface bs; TableInterface table;static final String ARR[]= {"arthur","galahad","robin","lancelot","guard"};
	public ConsoleSceneView() {
		table=SingletonsCreator.createTableInterface();
		bs=SingletonsCreator.createBridgeScene();
		initTable();
		for(int i=0;i<ARR.length;i++) {
		    ((AvatarInterface)(table.get(ARR[i]))).getArms().getLeftLine().addPropertyChangeListener(this);
		    ((AvatarInterface)(table.get(ARR[i]))).getArms().getRightLine().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getLegs().getLeftLine().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getLegs().getRightLine().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getArms().getLeftLine().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getBody().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getHead().addPropertyChangeListener(this);
			((AvatarInterface)(table.get(ARR[i]))).getStringShape().addPropertyChangeListener(this);
		 }
		bs.getGuardArea().addPropertyChangeListener(this);
		bs.getKnightArea().addPropertyChangeListener(this);
		bs.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
		System.out.println("Source: "+ evt.getSource());
		System.out.println("Property changed: "+ evt.getPropertyName());
		System.out.println("Old value: "+ evt.getOldValue());
		System.out.println("New value: "+ evt.getNewValue());
	}
	public void initTable() {
		table.put("lancelot", bs.getLancelot());
		table.put("robin", bs.getRobin());
		table.put("guard", bs.getGuard());
		table.put("galahad", bs.getGalahad());
		table.put("arthur", bs.getArthur());
	}

}
