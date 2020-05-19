import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueByComparator 
{
	public static void main(String[] args){ 
        Scanner in = new Scanner(System.in); 
        // Creating Priority queue constructor having  
        // initial capacity=5 and a StudentComparator instance  
        // as its parameters 
        PriorityQueue<Student> pq = new 
             PriorityQueue<Student>(5, new StudentComparator()); 
                  
                // Invoking a parameterized Student constructor with  
                // name and cgpa as the elements of queue 
                Student student1 = new Student("Nandini", 5); 
                  
                // Adding a student object containing fields  
                // name and cgpa to priority queue  
                pq.add(student1); 
                Student student2 = new Student("Anmol", 3); 
                        pq.add(student2);          
                Student student3 = new Student("Palak", 4); 
                        pq.add(student3); 
                  
                // Printing names of students in priority order,poll() 
                // method is used to access the head element of queue 
                System.out.println("Students served in their priority order"); 
                  
                while (!pq.isEmpty()) { 
                System.out.println(pq.poll().getName()); 
        }  
    } 
}  
  
class StudentComparator implements Comparator<Student>{ 
              
            // Overriding compare()method of Comparator  
                        // for descending order of cgpa 
            public int compare(Student s1, Student s2) { 
            	return (s1.cgpa-s2.cgpa);
                
        } 
}
  
class Student { 
    public String name; 
    public int cgpa; 
          
    // A parameterized student constructor 
    public Student(String name, int cgpa) { 
      
        this.name = name; 
        this.cgpa = cgpa; 
    } 
      
    public String getName() { 
        return name; 
    }  

}
