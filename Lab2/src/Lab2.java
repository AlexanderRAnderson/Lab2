public class Lab2 {
    private static final double EPSILON = .00001;
    private static int count = 0;

   public static double firstDerivativeFunction(double x, double y) {
       return (4 * Math.pow(x,3) - y - 1);
   }

   public static double secondDerivativeFunction(double x, double y) {
       return (12 * Math.pow(x,2));
   }

    public static double findMinMax(double x, double y) {
        double h = firstDerivativeFunction(x,y) / secondDerivativeFunction(x,y);
        while (Math.abs(h) >= EPSILON && count <= 10000) {
            h = firstDerivativeFunction(x,y) / secondDerivativeFunction(x,y);
            count++;
            double guessedX = x;
            x = x - h;
//            System.out.println("Iteration: " + count + " |Guessed x value: " + Math.round(guessedX * 100.0) / 100.0
//                    + " |Derived Root: " + Math.round(x * 100.0) / 100.0 + " |Polynomial Value: " + Math.round(firstDerivativeFunction(x,y) * 100.0) / 100.0);
        }
        if(count >= 10000) {
            return -1;
        }
        return x;
    }

    public static void main(String[] args) {
        double x0 = 6;
        double y0 = 5;
        double value = findMinMax(x0,y0);
        if(value == -1){
            System.out.println("Infinity");
        } else {
            System.out.println("Minimum or maximum value for z: " + value);
        }
    }

}
