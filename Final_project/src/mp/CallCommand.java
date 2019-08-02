package mp;

import util.annotations.Tags;

@Tags("CallCommand")
public class CallCommand implements Runnable {
	private String name;
	TableInterface<Runnable> env;
	public CallCommand(String n) {
		name=n;
		env=SingletonsCreator.createEnvironment();
	}

	@Override
	public void run() {
		env.get(name).run();
	}
}
