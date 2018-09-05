
public class FizzBuzzNotUsingIf {
	public static void main(String[] args) {

		final int MAX = 30;
		String[] out = new String[MAX + 1];

		for (int i = 1; i <= MAX; i++)
			out[i] = i + "";
		for (int i = 3; i <= MAX; i += 3)
			out[i] = "Fizz";
		for (int i = 5; i <= MAX; i += 5)
			out[i] = "Buzz";
		for (int i = 15; i <= MAX; i += 15)
			out[i] = "FizzBuzz";
		for (int i = 1; i <= MAX; i++)
			System.out.println(out[i]);

	}
}
