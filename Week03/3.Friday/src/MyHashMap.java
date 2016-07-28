import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {

	List<List<Entry<K, V>>> buckets;
	private int capacity;

	// ************************-
	public class Entry<K, V> {

		private K key;
		private V value;

		public Entry() {
			this.key = null;
			this.value = null;
		}

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
	// ************************

	public MyHashMap() {
		capacity = 16; // initial capacity is 16
		buckets = new ArrayList<>(capacity);
		init(buckets, capacity);
	}

	private void init(List<List<Entry<K, V>>> buckets, int capacity) {
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<Entry<K, V>>());
		}
	}

	private int hash(K key) {
		return Math.abs((key.hashCode() % capacity));
	}

	public void put(K key, V value) {

		if (key == null) {
			return;
		}

		int position = hash(key);
		List<Entry<K, V>> bucket = buckets.get(position);

		if (bucket == null) {
			bucket = new LinkedList<>();
		}

		for (Entry<K, V> entry : bucket) {
			if (key.equals(entry.getKey())) {
				entry.setValue(value);
				return;
			}
		}

		Entry<K, V> newEntry = new Entry<>(key, value);
		bucket.add(newEntry);
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}

		int position = hash(key);
		List<Entry<K, V>> bucket = buckets.get(position);

		if (bucket == null) {
			return null;
		}

		for (Entry<K, V> entry : bucket) {
			if (key.equals(entry.getKey())) {
				return entry.getValue();
			}
		}

		return null;
	}

	public boolean containsKey(K key) {
		if (key == null) {
			return false;
		}

		V value = this.get(key);
		if (value != null) {
			return true;
		}

		return false;
	}

}
