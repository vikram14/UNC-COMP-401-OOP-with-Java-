package mp;

import util.models.PropertyListenerRegisterer;

public interface CommandInterpreterInterface extends PropertyListenerRegisterer {
	public void setCommand(String c);
	public String getCommand();
	public String getErrors();
	public void asynchronousArthur() ;
	public void asynchronousRobin() ;
	public void asynchronousGalahad() ;
	public void asynchronousLancelot();
	public void asynchronousGuard();
	public void waitingArthur() ;
	public void waitingRobin() ;
	public void waitingGalahad() ;
	public void waitingLancelot();
	//public void waitingGuard();
	public void lockstepArthur() ;
	public void lockstepRobin() ;
	public void lockstepGalahad() ;
	public void lockstepLancelot();
	public void lockstepGuard();
}
