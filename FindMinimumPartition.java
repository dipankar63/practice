package days30coding;

public class FindMinimumPartition {
	
	static int findMin(int[] a , int i, int sumCalulated , int sumTotal){
		if(i==a.length-1){
			return Math.abs(sumCalulated - (sumTotal-sumCalulated));
		}
		
		//Two case: i is included in sum calculation or not
		return Math.min(findMin(a, i+1, sumCalulated, sumTotal), findMin(a, i+1, sumCalulated+a[i], sumTotal));
		
		
		
	}
	
	
	public static void main(String args[]){
		int sum = 0;
		int[]  a = {9,3,3,3,2,1};
		
		for(int i:a){
			sum+=i;
		}
		int result = findMin(a, 0, 0, sum);
		System.out.println(" Result is: "+result);
		
		
	}

}
