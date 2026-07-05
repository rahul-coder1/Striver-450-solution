package binary.search.minOfMaxOrMaxofMin;

/**
 * Brute force - linear search, TC- O(sum-max+1)*N, N->number of books in array
 * low=max(arr), high=sum(arr)
 * for(pages=low->high){
 * 	cntStd=fun(arr,students);
 *  if(cntStd==m) return pages
 * }
 * func(arr,pages){
 * 	stu=1, pagesCnt=0
 *  for(i=0->n-1){
 *  	if(pagesCnt+arr[i]<=pages) pagesCnt+=arr[i]
 *  	else{
 *  		stu++; pagesCnt=arr[i]
 *  	}
 *  }
 *  return stu;
 * }
 * 
 * int min = Arrays.stream(arr).min().getAsInt();
 * int max = Arrays.stream(arr).max().getASInt();
 * int sum = Arrays.stream(arr).sum();
 * double avg = Arrays.stream(arr).average().getAsDouble();
 */

//TC - log(sum-max+1)*N
public class AllocateMinimumPages {
	
	public static int countStudents(int[] arr,long pages){
		long pagesStudent=0;
		int student=1;
		
		for(int i=0;i<arr.length;i++) {
			if(pagesStudent+arr[i]<=pages) pagesStudent+=arr[i];
			else {
				pagesStudent=arr[i];
				student+=1;
			}
		}
		
		return student;
	}
	
	public static void main(String[] args) {
//		int arr[] = {15, 17, 20}, k = 5;
//		int arr[] = {10, 20, 30, 40}, k = 2;
		int arr[] = {12, 34, 67, 90}, k = 2;
		
		if(arr==null || arr.length==0 || k>arr.length){
			System.out.println("Maximum pages which is minimum:-1");
			return;
		}
		long low=arr[0]; long high=0,mid=0;
		for(int i:arr) {
			if(i>low) low=i;
			high+=i;
		}
		
		while(low<=high){
			mid=low+(high-low)/2;
			int students = countStudents(arr,mid);
			if(students>k) low=mid+1;
			else high=mid-1;
		}
		
		System.out.printf("Maximum pages which is minimum:%d",low);
	}
}




























