/**
 * @author nicolas et hadrien
 */
public class Executable {


    /**
     * An example of how to use the program.
     * It is up to you to create your own tests for the various instances.
     * @param args
     */
    public static void main(String[] args) {
        KnapsackData example = new KnapsackData(new int[]{6,4,2}, new int[]{1,3,5},new double[]{10,15,11}, 10);
        
        long time = System.currentTimeMillis();
        DPSolver solver = new DPSolver(example);
        solver.Solve();
        solver.PrintSolution();
        time = (System.currentTimeMillis()-time);

        System.out.println(String.format("OPT: %.3f CPUTime: %.3f s", solver.OptVal(),  (time/1000d)));
    }
}