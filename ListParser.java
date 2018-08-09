import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * こういう[[[]],[],[[],[]]]構文を整形？します
 * エラー処理がアレなのは触れないでください
 *
 * in: [[[]],[],[[],[]]]
 * out:
 *[
	[
		[
		]
	]
	,
	[
	]
	,
	[
		[
		]
		,
		[
		]
	]
]
 */

public class ListParser {

	public static void main(String[] args) throws Exception {

		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		br.close();

		System.out.println(parse(line));
	}

	public static String parse(String str) throws Exception {
		if (!check(str)) {
			throw new Exception("Syntax Error");
		}
		return parse(str, 0);
	}

	public static String parse(String str, int depth) throws Exception {
		if (str == null || str.length() == 0) return "";

		char head = str.charAt(0);
		if (head == '[') {
			return normalize(head, depth) + parse(str.substring(1), ++depth);
		}
		else if (head == ']') {
			return normalize(head, --depth) + parse(str.substring(1), depth);
		}
		else if (head == ',') {
			if (depth == 0) throw new Exception(",が入るならリスト内であるべきだよ");
			return normalize(head, depth) + parse(str.substring(1), depth);
		}
		else {
			throw new Exception("予期しない文字が含まれています");
		}
	}

	public static String normalize(char out, int depth) {
		String ret = "";
		for (int i = 0; i < depth; i++)
			ret += "\t";
		ret += out + "\n";
		return ret;
	}

	public static boolean check(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '[') sum++;
			if (c == ']') sum--;
		}
		if (sum != 0) return false;

		return str.matches("[\\[|\\],]*") || str.indexOf("][") == -1 && str.indexOf("[,") == -1 &&
				str.indexOf(",]") == -1 && str.indexOf(",,") == -1;
	}

}