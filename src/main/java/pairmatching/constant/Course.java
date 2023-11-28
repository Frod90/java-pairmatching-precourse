package pairmatching.constant;

import java.util.List;

import pairmatching.util.DataReader;

public enum Course {
	BACKEND("백엔드", DataReader.read("src/main/resources/backend-crew.md")),
	FRONTEND("프론트엔드", DataReader.read("src/main/resources/frontend-crew.md"));

	private final String name;
	private final List<String> crewNames;

	Course(String name, List<String> crewNames) {
		this.name = name;
		this.crewNames = crewNames;
	}

	public String getName() {
		return name;
	}

	public List<String> getCrewNames() {
		return crewNames;
	}
}
