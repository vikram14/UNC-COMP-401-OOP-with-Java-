package mp;

import util.annotations.Tags;

@Tags("RepeatCommand")
public class RepeatCommand implements Runnable{
	int n; Runnable r;
	public RepeatCommand(int k, Runnable ru) {
		n=k;
		r=ru;
	}
	@Override
	public void run() {
		for(int i=0;i<n;i++) {
			if(r!=null)
			r.run();
		}
	}
	
}
