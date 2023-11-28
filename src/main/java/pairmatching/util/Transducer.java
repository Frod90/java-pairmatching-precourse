package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transducer {

	private static final String SEPARATOR = ",";

	public static List<String> toList(String input) {

		return Arrays.stream(input.split(SEPARATOR))
			.map(String::trim)
			.collect(Collectors.toList());
	}

}
