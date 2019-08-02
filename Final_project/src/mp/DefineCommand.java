package mp;

import util.annotations.Tags;


@Tags("DefineCommand")
public class DefineCommand  implements Runnable {
    long k;
	private String name;
	private Runnable command; TableInterface<Runnable> env;
	public DefineCommand(String n, Runnable c) {
		name=n;
		command=c;
		env=SingletonsCreator.createEnvironment();
	}

	@Override
	public void run() {
		env.put(name, command);
	}
}