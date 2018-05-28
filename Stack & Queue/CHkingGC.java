/**
 * Created by Siddhant on 31-Mar-18.
 */
public class CHkingGC {
    int i;
    double[] d = new double[1000000];
    CHkingGC(int i)
    {
        this.i = i;
        System.out.println("cons"+i);
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        i-=1;
        System.out.println("finalize"+i);
    }
}
