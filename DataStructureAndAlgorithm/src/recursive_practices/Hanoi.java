package recursive_practices;

public class Hanoi {
	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
	/**
	 * 汉诺塔问题，4399可玩
	 * @param i 一共有i个盘子
	 * @param from	开始的柱子	
	 * @param in		中间的柱子
	 * @param to		目标柱子
	 * 无论多少个盘子，都认为只有两个盘子，上面的所有盘子和下面的一个盘子
	 */
	public static void hanoi(int i, char from, char in, char to) {
		if(i == 1) {
			System.out.println("把第1个盘子从" + from + "移动到" + to);
		}else {
			hanoi(i-1, from, to, in);
			System.out.println("把第" + i + "个盘子从" + from + "移动到" + to);
			hanoi(i-1, in, from, to);
		}
	}
}
