package edu.nju;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ParamMap extends HashMap<String, Object> implements Map<String, Object>, Iterable<Entry<String, Object>> {
	private static final long serialVersionUID = 1L;

	public ParamMap() {
	}

	public ParamMap(String key, Object value) {
		super();
		this.put(key, value);
	}

	public ParamMap append(String key, Object value) {
		this.put(key, value);
		return this;
	}

	@Override
	public Iterator<java.util.Map.Entry<String, Object>> iterator() {
		return this.entrySet().iterator();
	}

}
