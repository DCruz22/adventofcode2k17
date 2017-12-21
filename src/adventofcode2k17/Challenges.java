package adventofcode2k17;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Challenges {

	private static int InverseCaptcha(String seq) {
		int cantidad = 0;
		for (int i = 0; i < seq.length(); i++) {

			if (i == seq.length() - 1) {
				if (seq.charAt(i) == seq.charAt(0))
					cantidad += seq.charAt(i) - '0';

				break;
			}

			if (seq.charAt(i) == seq.charAt(i + 1)) {
				cantidad += seq.charAt(i) - '0';
			}
		}

		return cantidad;
	}

	private static int CorruptionChecksum(String input) {
		int checksum = 0;

		Scanner scan = new Scanner(input);

		while (scan.hasNext()) {
			String[] row = scan.nextLine().split("\\s+");

			List<Integer> list = Arrays.stream(row).map(Integer::valueOf).collect(Collectors.toList());

			checksum += Collections.max(list) - Collections.min(list);
		}

		return checksum;
	}

	private static int HighEntropyPassphrasesPartOne(String input) {
		int validPassphrasesCount = 0;

		Scanner scan = new Scanner(input);

		while (scan.hasNext()) {
			String[] row = scan.nextLine().split("\\s+");

			Set<String> nonRepeatedElements = new HashSet<>();

			boolean isValid = true;

			for (int i = 0; i < row.length; i++) {

				if (!nonRepeatedElements.add(row[i]))
					isValid = false;
			}

			if (isValid)
				validPassphrasesCount++;
		}

		return validPassphrasesCount;

	}

	private static int HighEntropyPassphrasesPartTwo(String input) {
		int validPassphrasesCount = 0;

		Scanner scan = new Scanner(input);

		while (scan.hasNext()) {
			String[] row = scan.nextLine().split("\\s+");

			Set<String> nonRepeatedElements = new HashSet<>();

			boolean isValid = true;

			for (int i = 0; i < row.length; i++) {

				if (!nonRepeatedElements.add(orderString(row[i])))
					isValid = false;
			}

			if (isValid)
				validPassphrasesCount++;
		}

		return validPassphrasesCount;

	}

	private static String orderString(String input) {
		char[] word = input.toCharArray();
		Arrays.sort(word);
		return new String(word);
	}

	private static int MazeOfTwistyTrampolinesPartOne(String input) {

		int steps = 0, index = 0, offset;
		int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		while (index != numbers.length) {
			offset = numbers[index];
			numbers[index]++;
			index += offset;
			steps++;
		}

		return steps;
	}

	private static int MazeOfTwistyTrampolinesPartTwo(String input) {

		int steps = 0, index = 0, offset;
		int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		while (index != numbers.length) {
			offset = numbers[index];

			if (offset >= 3)
				numbers[index]--;
			else
				numbers[index]++;

			index += offset;
			steps++;
		}

		return steps;
	}

	public static void main(String[] args) {
		String input1 = "abcde fghij\n" + "abcde xyz ecdab\n" + "a ab abc abd abf abj\n" + "iiii oiii ooii oooi oooo\n"
				+ "oiii ioii iioi iiio";

		String input = "";

		System.out.println(MazeOfTwistyTrampolinesPartTwo(input) + " steps where taken");
	}

}
