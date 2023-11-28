package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.Level;

public class Mission {

	private Level level;
	Map<String, List<Pair>> result = new HashMap<>();

	public Mission(String inputLevel) {
		findLevel(inputLevel);
		List<String> levelDetail = level.getDetail();

		for(String eachDetail : levelDetail) {
			result.put(eachDetail, new ArrayList<>());
		}
	}

	private void findLevel(String inputLevel) {

		for(Level eachLevel : Level.values()) {
			if(eachLevel.getName().equals(inputLevel)) {
				level = eachLevel;
			}
		}
	}

	private void validateMission(String mission) {

		String level = "";

		for (Level eachLevel : Level.values()) {
			if (eachLevel.getDetail().contains(mission)) {
				level = eachLevel.getName();
			}
		}

		if(level.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	public void replaceMission(String mission, List<Pair> pairs) {
		validateMission(mission);
		result.replace(mission, pairs);
	}

	public List<Pair> getResultPair(String inputMission) {
		return result.get(inputMission);
	}

	public void clear(String inputMission) {
		result.replace(inputMission, new ArrayList<>());
	}

}
