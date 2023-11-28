package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	public static List<String> read(String path) {

		List<String> crewNames = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String str;
			while ((str = reader.readLine()) != null) {
				crewNames.add(str);
			}
			reader.close();
		}catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return crewNames;
	}
}
