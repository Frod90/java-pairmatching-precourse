package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class PairMaker {

	List<Pair> matchResult = new ArrayList<>();

	public List<Pair> make(Crew crew, List<Pair> otherPairs) {

		match(crew);

		return matchResult;
	}

	private void match(Crew crew) {
		List<String> shuffledCrew = crew.shuffleCrew();

		if (shuffledCrew.size() % 2 != 0) {
			matchInOdd(shuffledCrew);
		}

		if (shuffledCrew.size() % 2 == 0) {
			matchInEven(shuffledCrew);
		}
	}

	private void matchInOdd(List<String> shuffledCrew) {

		for (int i = 0; i < shuffledCrew.size(); i += 2) {

			List<String> inputPair = new ArrayList<>();
			inputPair.add(shuffledCrew.get(i));
			inputPair.add(shuffledCrew.get(i + 1));

			if (i + 4 > shuffledCrew.size()) {
				inputPair.add(shuffledCrew.get(i + 2));
				matchResult.add(new Pair(inputPair));
				break;
			}

			matchResult.add(new Pair(inputPair));
		}
	}

	private void matchInEven(List<String> shuffledCrew) {

		for (int i = 0; i < shuffledCrew.size(); i += 2) {

			List<String> inputPair = new ArrayList<>();
			inputPair.add(shuffledCrew.get(i));
			inputPair.add(shuffledCrew.get(i + 1));

			matchResult.add(new Pair(inputPair));
		}
	}

	public void clear() {
		matchResult.clear();
	}

	public List<Pair> getMatchResult() {
		return matchResult;
	}

}
