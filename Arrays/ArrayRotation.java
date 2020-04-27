import java.util.Scanner;

class Rotate
{
	void rotateArray(int arr[],int d,int n)
	{
		for(int i=0;i<d;i++)
		{
			rotateArraybyOne(arr,n);
		}
	}
	void rotateArraybyOne(int arr[],int n)
	{
		int i,temp;
		temp=arr[0];
		for(i=0;i<n-1;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[i]=temp;
	}
	
	void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
}
public class ArrayRotation {

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter array size-");
		int n=scan.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter array elements-");
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		Rotate rot=new Rotate();
		rot.rotateArray(arr,2, n);
		rot.printArray(arr, n);
	}

}
