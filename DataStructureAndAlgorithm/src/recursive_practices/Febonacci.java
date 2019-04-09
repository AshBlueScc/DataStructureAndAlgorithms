package recursive_practices;

public class Febonacci {
	public static void main(String[] args) {
		//斐波那契数列：1 1 2 3 5 8 13
		Febonacci feb = new Febonacci();
		System.out.println(feb.febnacci(6));
	}

	public int febnacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		}else {
			return febnacci(i-1) + febnacci(i-2);
		}
	}
}
