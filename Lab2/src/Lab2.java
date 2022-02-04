public class Lab2 {
    private static final double EPSILON = .00001;
    private static int count = 0;

   public static double firstDerivativeXFunction(double x, double y) {
       return (4 * Math.pow(x,3) - y - 1);
   }

   public static double secondDerivativeXFunction(double x, double y) {
       return (12 * Math.pow(x,2));
   }

    public static double firstDerivativeYFunction(double x, double y) {
        return (12 * Math.pow(y,5) - x);
    }

    public static double secondDerivativeYFunction(double x, double y) {
        return (60 * Math.pow(y,4));
    }

    public static double findMinMax(double x, double y) {

        double oldX = 7;
        double oldY = 7;
        double A = 0, C = 0;
        while (Math.abs(x - oldX) >= EPSILON && Math.abs(y - oldY) >= EPSILON && count <= 10000) {
            double h = firstDerivativeXFunction(x,y) / secondDerivativeXFunction(x,y);
            double g = firstDerivativeYFunction(x,y) / secondDerivativeYFunction(x,y);
            count++;
            oldX = x;
            oldY = y;
            x = x - h;
            y = y - g;
            A = secondDerivativeXFunction(x,y);
            C = secondDerivativeYFunction(x,y);
        }
        if(count >= 10000) {
            return -1;
        }
        if(A * C > 0 && A > 0) {
            System.out.print("Minimum: ");
        } else if(A * C > 0 && A < 0) {
            System.out.print("Maximum: ");
        }
        double z = Math.pow(x,4) + 2 * Math.pow(y,6) - x * y - x + 2;
        assert z >= 2;
        return z;
    }

    public static void main(String[] args) {
        double x0 = 6;
        double y0 = 5;
        double value = findMinMax(x0,y0);
        if(value == -1){
            System.out.println("Infinity");
        } else {
            System.out.println(value);
        }
    }

}
