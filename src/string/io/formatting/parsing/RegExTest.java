package string.io.formatting.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

	public static void main(String[] args) {
		String str = "yyxxxyxx";
		findMatching(str, ".*xx"); // Greedy Quantifier
		findMatching(str, ".*?xx"); // Reluctant Quantifier
		System.out.println("----------------------------");
		String strr = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, "
				+ "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post "
				+ "office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
		String str2 = "+?*.2?";
		Pattern pattern = Pattern.compile("(\\w+)");
		Matcher matcher = pattern.matcher(str2);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		System.out.println("----------------------------");
		String str3 = "???";
		System.out.println(str3.matches("^\\?+$"));
		System.out.println("---------  \\w matches numbers too, \\b matches word boundary ----------");
		Pattern patrn = Pattern.compile("\\b\\w+\\D\\b");
		Matcher match = patrn.matcher("AZER 1234 QSDF");
		while (match.find()) {
			System.out.println(">> " + match.group());
		}

		System.out.println("--------------\\b\\w+\\D\\b--------------");
		String str0 = "BBBB 2013 BBBB7";
		Pattern pattern0 = Pattern.compile("\\b\\w+\\D\\b");
		Matcher matcher0 = pattern0.matcher(str0);
		while (matcher0.find()) {
			System.out.println(">>"+matcher0.group()+"<<");
		}

	}

	private static void findMatching(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		StringBuilder output = new StringBuilder();
		while (matcher.find()) {
			output.append("(" + matcher.group() + ")\t");
		}
		System.out.println(output);
	}
}
