package pairmatching.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.Level;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.input.InputMachine;
import pairmatching.output.printer;
import pairmatching.service.PairMaker;
import pairmatching.util.Transducer;

public class FunctionController {

	Map<String, Mission> backendSummary = new HashMap<>();
	Map<String, Mission> frontendSummary = new HashMap<>();
	Crew backendCrew = new Crew("백엔드");
	Crew frontendCrew = new Crew("프론트엔드");

	public FunctionController() {

		for (Level eachLevel : Level.values()) {
			String level = eachLevel.getName();
			backendSummary.put(level, new Mission(level));
		}

		for (Level eachLevel : Level.values()) {
			String level = eachLevel.getName();
			frontendSummary.put(level, new Mission(level));
		}
	}

	public void run() {

		String functionOption;

		do {

			functionOption = InputMachine.inputFunctionOption();
			if (functionOption.equals("Q")) {
				break;
			}

			printer.printInformation();
			List<String> information = InputMachine.inputFunctionDetail();

			if (functionOption.equals("1")) {
				makePair(information);
				findPair(information);
			}

			if (functionOption.equals("2")) {
				findPair(information);
			}

			if (functionOption.equals("3")) {
				clearPair(information);
			}

		} while (true);

	}

	public void makePair(List<String> information) {

		String courseName = information.get(0);
		String inputLevel = information.get(1);
		String inputMission = information.get(2);

		if (courseName.equals("백엔드")) {

			List<Pair> resultPair = backendSummary.get(inputLevel).getResultPair(inputMission);

			if (!resultPair.isEmpty()) {
				String rematchOption = InputMachine.inputRematchOption();
				if (rematchOption.equals("예")) {
					PairMaker pairMaker = new PairMaker();
					List<Pair> pairResult = pairMaker.make(backendCrew);

					backendSummary.get(inputLevel).replaceMission(inputMission, pairResult);
					resultPair = backendSummary.get(inputLevel).getResultPair(inputMission);
					printer.printPairResult(resultPair);
				}
			}

			if (resultPair.isEmpty()) {
				PairMaker pairMaker = new PairMaker();
				List<Pair> pairResult = pairMaker.make(backendCrew);

				backendSummary.get(inputLevel).replaceMission(inputMission, pairResult);
				resultPair = backendSummary.get(inputLevel).getResultPair(inputMission);
				printer.printPairResult(resultPair);
			}
		}

		if (courseName.equals("프론트엔드")) {

			List<Pair> resultPair = frontendSummary.get(inputLevel).getResultPair(inputMission);
			System.out.println(resultPair);

			if (!resultPair.isEmpty()) {
				String rematchOption = InputMachine.inputRematchOption();
				if (rematchOption.equals("예")) {
					PairMaker pairMaker = new PairMaker();
					List<Pair> pairResult = pairMaker.make(frontendCrew);

					frontendSummary.get(inputLevel).replaceMission(inputMission, pairResult);

				}
			}

			if (resultPair.isEmpty()) {
				PairMaker pairMaker = new PairMaker();
				List<Pair> pairResult = pairMaker.make(frontendCrew);

				frontendSummary.get(inputLevel).replaceMission(inputMission, pairResult);

			}

		}

	}

	public void findPair(List<String> information) {

		String courseName = information.get(0);
		String inputLevel = information.get(1);
		String inputMission = information.get(2);

		if (courseName.equals("백엔드")) {

			List<Pair> resultPair = backendSummary.get(inputLevel).getResultPair(inputMission);
			printer.printPairResult(resultPair);

		}

		if (courseName.equals("백엔드")) {

			List<Pair> resultPair = frontendSummary.get(inputLevel).getResultPair(inputMission);
			printer.printPairResult(resultPair);

		}
	}

	public void clearPair(List<String> information) {

		String courseName = information.get(0);
		String inputLevel = information.get(1);
		String inputMission = information.get(2);

		if (courseName.equals("백엔드")) {

			backendSummary.get(inputLevel).clear(inputMission);

		}

		if (courseName.equals("백엔드")) {

			frontendSummary.get(inputLevel).clear(inputMission);
		}
	}

	public Map<String, Mission> getBackendSummary() {
		return backendSummary;
	}

}
