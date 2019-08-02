package mp;
import java.lang.Thread;

import util.annotations.Tags;
@Tags("ThreadCommand")
public class ThreadCommand implements Runnable {
	private String name;
	TableInterface<Runnable> env;
	public ThreadCommand(String n) {
		name=n;
		env=SingletonsCreator.createEnvironment();
	}

	@Override
	public void run() {
		Thread t= new Thread(env.get(name));
		t.start();
	}
}