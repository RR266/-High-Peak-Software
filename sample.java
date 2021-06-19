import java.io.File; 
import java.io.FileNotFoundException;  
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner; 

public class sample {
	static int minDiff(int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int findelements(int res,int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
    } 
  public static void main(String[] args) throws IOException {
    try {
      
    	  File dest = new File("C:\\Users\\Rahul\\eclipse-workspace\\high peak\\src\\sample_output.txt");
    	  int array[]={7980,22349,999,2799,229900,11101,9999,2195,9800,4999};
          String items[]={ "MI Band: 999","Sandwich Toaster: 2195" ,"Cult Pass: 2799","Scale: 4999","Fitbit Plus: 7980","Microwave Oven: 9800"  ,"Alexa: 9999","Digital Camera: 11101", "IPods: 22349","Macbook Pro: 229900" };
          int N = array.length;
          FileWriter writer = new FileWriter(dest);
          System.out.println("Enter the number of employees");
          Scanner s = new Scanner(System.in);
          int M=s.nextInt();
          int result=minDiff(array, N, M);
          writer.write("Number of the employees:"+M+"\n");
          writer.write("\n");
          writer.write("Here the goodies that are selected for distribution are:\n");
          int startindex=findelements(result,array,N,M);
          for(int i=startindex;i<startindex+M;i++)
        	  writer.write(items[i]+"\n".toString());
          	  writer.write("\n");
          	  writer.write("And the difference between the chosen goodies with highest price and the lowest price is:"+result);
          writer.flush();
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}