package hashmap;

public class KVPair<Key, Val> {
//	Each map element is a Key-Value Pair.
	Key key;
	Val val;

	public KVPair(Key key, Val val) {
		super();
		this.key = key;
		this.val = val;
	}

	@Override
	public String toString() {
		return (key + "->" + val);
	}

}
