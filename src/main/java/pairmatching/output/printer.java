package pairmatching.output;

import java.util.List;

import pairmatching.domain.Pair;

public class printer {

	public static void printInformation() {
		System.out.println();
		System.out.println(
			"#############################################\n"
				+ "과정: 백엔드 | 프론트엔드\n"
				+ "미션:\n"
				+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
				+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
				+ "  - 레벨3: \n"
				+ "  - 레벨4: 성능개선 | 배포\n"
				+ "  - 레벨5: \n"
				+ "############################################"
		);
	}

	public static void printPairResult(List<Pair> pairResult) {

		System.out.println();
		System.out.println("페어 매칭 결과입니다.");

		for(Pair eachPair : pairResult) {
			System.out.println(eachPair);
		}

		System.out.println();
	}
}
