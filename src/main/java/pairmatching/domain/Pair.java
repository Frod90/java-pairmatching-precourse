package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pair {

	List<String> pair;

	public Pair(List<String> inputPair) {
		this.pair = inputPair;
	}

	public void validateDuplication(Pair other) {

		String crew1 = other.pair.get(0);
		String crew2 = other.pair.get(1);

		if(this.pair.contains(crew1) && this.pair.contains(crew2)) {
			throw new IllegalStateException();
		}

		System.out.println(pair);
	}

	public List<String> getPair() {
		return pair;
	}

	public String toString() {
		if(pair.size() == 2) {
			return String.format("%s : %s", pair.get(0), pair.get(1));
		}

		return String.format("%s : %s : %s", pair.get(0), pair.get(1), pair.get(2));
	}

}
