package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Course;

public class Crew {
	private Course course;

	public Crew(String courseName) {

		validateCourseName(courseName);
		findCourse(courseName);
	}

	private void validateCourseName(String courseName) {
		if (!courseName.equals("백엔드") && !courseName.equals("프론트엔드")) {
			throw new IllegalArgumentException();
		}
	}

	private void findCourse(String courseName) {
		for (Course eachCourse : Course.values()) {
			if (eachCourse.getName().equals(courseName)) {
				course = eachCourse;
			}
		}
	}

	public List<String> shuffleCrew() {

		List<String> crewNames = new ArrayList<>(course.getCrewNames());

		return Randoms.shuffle(crewNames);
	}

	public Course getCourse() {
		return course;
	}

}
