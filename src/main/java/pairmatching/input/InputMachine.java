package pairmatching.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Level;

public class InputMachine {

	public static String inputFunctionOption() {

		boolean errorSign;
		String functionOption = "";

		do {
			try {
				System.out.println(
					"기능을 선택하세요.\n"
						+ "1. 페어 매칭\n"
						+ "2. 페어 조회\n"
						+ "3. 페어 초기화\n"
						+ "Q. 종료"
				);
				functionOption = Console.readLine();
				validateFunctionOption(functionOption);

				errorSign = false;

			} catch (IllegalArgumentException illegalArgumentException) {
				errorSign = true;
				System.out.println("[ERROR] 잘못 입력하셨습니다.");

			}
		}while (errorSign);

		return functionOption;
	}

	public static void validateFunctionOption(String functionOption) {
		if( !functionOption.equals("1")
			&& !functionOption.equals("2")
			&& !functionOption.equals("3")
			&& !functionOption.equals("Q")
		) {
			throw new IllegalArgumentException();
		}
	}

	public static List<String> inputFunctionDetail() {

		boolean errorSign;

		List<String> information = new ArrayList<>();
		do {
			try {
				System.out.println(
					"과정, 레벨, 미션을 선택하세요.\n"
						+ "ex) 백엔드, 레벨1, 자동차경주"
				);
				String inputInformation = Console.readLine();
				information = toList(inputInformation);

				errorSign = false;
			} catch (IllegalArgumentException illegalArgumentException) {
				errorSign = true;
				System.out.println("[ERROR] 잘못 입력하셨습니다.");
			}
		}while (errorSign);

		return information;
	}


	public static List<String> toList(String input) {

		final String SEPARATOR = ",";

		if(!input.contains(SEPARATOR)) {
			throw new IllegalArgumentException();
		}

		List<String> information = Arrays.stream(input.split(SEPARATOR))
			.map(String::trim)
			.toList();

		validateLevel(information);
		validateMission(information);

		return information;
	}

	private static void validateLevel(List<String> information) {

		int errorCount = 0;

		for(Level eachLevel : Level.values()) {

			if(information.get(1).equals(eachLevel.getName())) {
				errorCount++;
			}

		}

		if(errorCount == 0) {
			throw new IllegalArgumentException();
		}

	}

	private static void validateMission(List<String> information) {

		int errorCount = 0;

		for(Level eachLevel : Level.values()) {

			if(eachLevel.getDetail().contains(information.get(2))) {
				errorCount++;
			}

		}

		if(errorCount == 0) {
			throw new IllegalArgumentException();
		}

	}

	public static String inputRematchOption() {

		String rematchOption = "";
		boolean errorSign;

		do {
			try {
				System.out.println(
					"매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
						+ "네 | 아니오"
				);
				rematchOption = Console.readLine();
				validateRematchOption(rematchOption);
				errorSign = false;

			} catch (IllegalArgumentException illegalArgumentException) {
				errorSign = true;
				System.out.println("[ERROR] 잘못 입력하셨습니다.");
			}
		}while (errorSign);

		return rematchOption;
	}

	private static void validateRematchOption(String rematchOption) {
		if(!rematchOption.equals("네") && !rematchOption.equals("아니오")) {
			throw new IllegalArgumentException();
		}
	}

}
