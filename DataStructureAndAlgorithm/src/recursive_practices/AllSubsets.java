package recursive_practices;

//题目描述：请编写一个递归函数，用来输出n个元素的所有子集。例如，三个元素{a,b,c}的所有子集是：{},{a},{b},{c},{a,c},{ac},{b,c},{a,b,c}.
//解题思路：
//根据子集的定义，集合中的每一个元素在子集中都有两种状态：‘1’表示出现，'0'表示不出现；如果所有的元素都不出现，则该子集是空集，如果所有的元素都出现，则该子集是全集。
//我们定义一个标记数组tag，用于记录集合中对应的元素是否出现，每层遍历对应集合中的每个元素，都有出现（为‘1’）和不出现（为‘0’）两种可能，一直遍历到所有的元素的可能都标记完，然后根据数组函数输出结果。


public class AllSubsets{
	public static void main(String[] args) {
		char a[] = {'a', 'b'};
		int tag[] = new int[5];
		subset(a, tag, 0);
	}
	
	public static void subset(char[] s, int tag[], int n) {
		if(n == s.length) {
			System.out.print("{");
			for(int i =0; i < s.length; i++) {
				if(tag[i] == 1) {
					System.out.print(s[i]);
				}
			}
			System.out.println("}");
			return;
		}
		tag[n] = 0;
		subset(s, tag, n+1);
		tag[n] = 1;
		subset(s, tag, n+1);
	}
}
