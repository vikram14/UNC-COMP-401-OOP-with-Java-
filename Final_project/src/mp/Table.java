package mp;

import java.util.ArrayList;
import java.util.List;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags("Table")
public class Table<T> implements TableInterface<T> {
	List<String> key=new ArrayList<String>();
	List<T> value=new ArrayList<T>();
	public void put(String k, T val) {
		if(key.contains(k))
			value.set(key.indexOf(k), val);
		else {
			key.add(k);
			value.add(key.indexOf(k), val);
		}
	}
	public boolean isMember(String k) {
		for(String s:key) {
			if(s.equals(k))
				return true;
		}
		return false;
	}
	public T get(String k) {
		if(key.contains(k))
			return value.get(key.indexOf(k));
		else 
			return null;
	} 
	public int size() {return key.size();}
}
