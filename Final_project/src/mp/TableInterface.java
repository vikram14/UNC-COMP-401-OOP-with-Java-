package mp;

public interface TableInterface <T> {
	public void put(String k, T val);
	public T get(String k);
	public int size();
}
