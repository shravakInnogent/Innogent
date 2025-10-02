
import java.util.Scanner;
class Factorial {
    int fact(int n){ //method creation in method area
        if(n==1 || n==0){ // base condition to terminate program
            return 1;
        }
        return n * fact(n-1); // recursive calling of fact method by decreasing value of n on each call
    }
    int factIterator(int n){
        int ans = 1;
        for(int i=n;i>=1;i--){ // loop from n till 1
            ans = ans *i;      //computing factorial and storing, in stack memory
        }
        return ans;
    }

}
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);  // sc object of Scanner class is created in Heap Memory
        System.out.println("Enter a number:");
       int n = sc.nextInt(); // taking input from user, stored in stack memory
        System.out.println("Approach to follow :\n1. Recursion \n2. Iteration");
        int choice = sc.nextInt();
        Factorial obj = new Factorial(); // obj is object of Factorial class, stored in heap memory
        int ans =0; // ans variable store in stack memory
        if(choice == 1){
            ans  = obj.fact(n); // method calling by obj object & taking result in ans
        }
        else if(choice==2){
            ans = obj.factIterator(n);// method calling by obj object & taking result in ans
        }
       System.out.println("Factorial of " + n + " is " + ans); // Displaying factorial
    }
}
