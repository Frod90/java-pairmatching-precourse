package pairmatching.constant;

import java.util.List;

public enum Level {
	LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", List.of()),
	LEVEL4("레벨4", List.of("성능개선", "배포")),
	LEVEL5("레벨5", List.of());

	private final String name;
	private final List<String> detail;

	Level(String name, List<String> detail) {
		this.name = name;
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public List<String> getDetail() {
		return detail;
	}
}
