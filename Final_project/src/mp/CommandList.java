package mp;

import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

@Tags("CommandList")
public class CommandList implements Runnable{
	List<Runnable> cl= new ArrayList<Runnable>();
	@Tags("add")
	public void add(Runnable r) {
		cl.add(r);
	}
	@Override
	public void run() {
		for(Runnable r: cl) {
			if(r!=null)
			r.run();
		}
	}
}
