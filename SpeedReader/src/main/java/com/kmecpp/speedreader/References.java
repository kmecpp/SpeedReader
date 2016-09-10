package com.kmecpp.speedreader;

import java.util.HashSet;
import java.util.Optional;

public class References {

	private static HashSet<Object> references = new HashSet<Object>();

	private References() {
	}

	public static void clear() {
		references.clear();
	}

	public static <T> T store(T object) {
		references.add(object);
		return object;
	}

	public static <T> Optional<T> remove(T object) {
		boolean removed = references.remove(object);
		return removed ? Optional.of(object) : Optional.empty();
	}

}
