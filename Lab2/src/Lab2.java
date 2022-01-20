public class Lab2 {
    private static final double EPSILON = .00001;
    private static int count = 0;

   public static double function(double x) {
       return 9 * Math.pow(x,6) + 3 * Math.pow(x,5) + 4 * Math.pow(x,4) + 2 * Math.pow(x,3) + 2 * Math.pow(x,2) + 9 * x + 1;
   }

   public static double derivativeFunction(double x) {
       return 54 * Math.pow(x,5) + 15 * Math.pow(x,4) + 16 * Math.pow(x,3) + 6 * Math.pow(x,2) + 4 * Math.pow(x,1) + 9;
   }

    public static void newtonRaphson(double x) {
        double h = function(x) / derivativeFunction(x);;
        while (Math.abs(h) >= EPSILON && count <= 2000) {
            h = function(x) / derivativeFunction(x);
            count++;
            x = x - h;
            System.out.println("Iteration: " + count + " Absolute Root: " + x + " Rounded Root: " + Math.round(x) * 100);
        }
        if(count >= 2000) {
            System.out.println("Roots not found");
        }
    }

    public static void main(String[] args) {
        double x0 = 2;
        newtonRaphson(x0);
    }

}
