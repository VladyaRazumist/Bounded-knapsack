/**
 * A class to implement the DynamicProgramming solver.
 * The attributes of this class (its state) are defined as the state of the DP algorithm.
 * So your dynamic programming solver can provide access afterwards to intermediate values in the table 
 * (e.g to provide the optimal value for other value of W without doing the complete computation again).
 * 
 * @author nicolas et hadrien, refactoring by a.melnikov
 */
 import static java.lang.Math.*;
public class DPSolver {

    /**
     * Reference to the data
     */
    private KnapsackData data;

    /**
     * Value of an optimal solution
     */
    private double optVal;
    private int [] optX;
    private double[][] s;
    private int[][] toTake;
    private double[] p;
    private double[] p1;
    private int[] w;
    private int[] w1;
    private int N;
    private int b[];

    /**
     * Build a DPSolver
     * @param data
     */
    public DPSolver(KnapsackData data) {
        this.data = data;
    }

    /**
     * @return the optimal value
     */
    public double OptVal() {
        return optVal;
    }

    /**
     * Initialize the data structures needed for the DP
     */
    private void Init() {
        int numOfItems = data.NumOfItems();
        int capacity = data.Capacity();
      
         int max=0;
         int b=0;
         int Q=0;
         int n=0;
         for (int i=0;i<numOfItems;i++)
        {
           Item I=data.GetItem(i);
          
          b=I.Quantity();
         
          Q=(int)Math.ceil((Math.log(b+1)/Math.log(2)));
          n=n+Q;
          System.out.printf("Q=%d \n", Q);
   
        }
        this.N=n;
        this.p1=new double[n+1];
        this.w1=new int[n+1];
        this.b=new int[numOfItems+1];
        this.p=new double[numOfItems+1];
        this.w=new int[numOfItems+1];
         this.s = new double[n+1][capacity+1];
        this.toTake = new int[n+1][capacity+1];
        this.optX=new int [numOfItems];
    }

    /**
     * Solve the knapsack problem
     * @return optimal solution of the problem; result[i] = number of (i+1)-th items in the knapsack
     */
    public int[] Solve() {
        Init();
        int numOfItems = data.NumOfItems();
        int capacity = data.Capacity();
        for (int i=1;i<numOfItems+1;i++)
        { 
            Item I=data.GetItem(i-1);
            p[i]=I.Value();
          
             
            w[i]=I.Weight();
         
        }
       for (int i=1;i<N+1;i++)
        { 
           
            p1[i]=0;
             
            w1[i]=0;
        }
        
        
        
        
        int n=0;
        for (int i=1;i<numOfItems+1;i++)
        {
            
             
            Item I=data.GetItem(i-1);
            int b=I.Quantity();
            int B=0;
            int k=1;
        
            do
    {
     if (B+k>b)
     {  k=b-B;          }
     n=n+1;
     p1[n]=k*p[i];
      
     w1[n]=k*w[i];
     B=B+k;
     k=k*2;
     
     
     
                 } while (B!=b);
            
        }
        
        
         numOfItems=N;
         for (int i=1;i<numOfItems+1;i++)
         {
             System.out.printf("w[i]=%d \n", w1[i]);
             System.out.println(String.format("%.0f",p1[i]));
         }
         
         
         
         
         for (int i=0;i<numOfItems+1;i++)
       { s[i][0]=0;                }
          for (int i=0;i<capacity+1;i++)
          {s[0][i]=0     ;          }  
        
        
        
           for (int i=1;i<numOfItems+1;i++)
    {
        for (int j=1;j<capacity+1;j++)
         {
           
            int w=w1[i];
            double p=p1[i];
            if (j-w>=0) {
             s[i][j]=max(s[i-1][j],s[i-1][j-w]+p);  }
            if (j-w<0)
          {
               s[i][j]=s[i-1][j];
               
              
          }
            
         }
    }
        optVal=s[numOfItems][capacity];
             
             
           for (int i=numOfItems;i>=1;i--)
    {
        for (int j=capacity;j>=1;j--)
         {
           if (s[i][j]==s[i-1][j])
              { toTake[i][j]=0; }
              else { toTake[i][j]=1; }
              
          }
      
        
    }
    int[] ct = new int[numOfItems+1]; int U=0;
     int yCur    = data.Capacity();
  for (int i=numOfItems;i>0;i--)
    {
        if (toTake[i][yCur] == 1)
       {
           ct[i]=1;
           yCur -= w1[i];
       }
           
              
         
         System.out.printf("ct[i]=%d \n", ct[i]);
         
    }
    double SUMM=0; double SUMM2=0;  int result [] = new int [data.NumOfItems()];
   double nh [] = new double [numOfItems+1]; int T=0;
    for (int i=0;i<data.NumOfItems();i++)
    {
        
        Item I=data.GetItem(i);
          
          int b=I.Quantity();
         
         int Q=(int)Math.ceil((Math.log(b+1)/Math.log(2)));
          System.out.printf("Q=%d \n", Q);
         for (int h=1;h<=Q;h++)
         {
             if (h<Q) 
             {nh[h]=Math.pow(2, h-1);        }
             if (h==Q) {for (int j=1;j<Q;j++) { SUMM= Math.pow(2, j-1)+SUMM;   }
                 nh[h]=b-SUMM; SUMM=0;              }
                
         }
           for (int k=1;k<=Q;k++)
           {
              SUMM2= nh[k]*ct[k+T]+SUMM2;
              
              
           }
           T=T+Q;
     System.out.println(String.format("%.0f",SUMM2));
             optX[i]= (int)SUMM2;
             
             SUMM2=0;
         }
    
    
    
    
   
        return optX;
    }
    /**
     * Print one optimal solution on the screen
     **/
    public void PrintSolution() {
        for (int i=0;i<data.NumOfItems();i++)
     {
         System.out.printf("optX[i]=%d \n", optX[i]);
    }

}
}