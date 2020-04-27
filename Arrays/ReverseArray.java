import java.util.Scanner;

class ArrayReverse
{
	int[] reverseArray(int[] a)
	{
		
         int temp; 
         int start=0;
         int end=a.length-1;  
         while (start < end) 
         { 
             temp = a[start];  
             a[start] = a[end]; 
             a[end] = temp; 
             start++; 
             end--; 
         }  
         return a;
    }
}

public class ReverseArray {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter array size-");
		int n=scan.nextInt();
		int[] arr = new int[n];
		System.out.print("Enter array elements-");
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		ArrayReverse rev=new ArrayReverse();
		int revArray[]=rev.reverseArray(arr);
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]+" ");
		}	
	}

}
