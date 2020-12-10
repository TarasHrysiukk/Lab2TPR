public class Main {
    private static int[] M = {780, 230};

    private static int[][] D = {
            {250, -60},
            {220, -60}
    };

    private static double[][] P = {
            {0.8, 0.2},
            {0.8, 0.2},
            {0.9, 0.1},
            {0.75, 0.25}
    };

    private static double[] profit = new double[4];
    private  double b1;
    private  double a1;

    public static void main(String[] args){
        System.out.println("Вузол A. Побудова великого заводу негайно.");
        printInfo(D[0][0], D[0][1], P[0][0], P[0][1]);
        System.out.println("A = " + profitB());
        System.out.println();

        System.out.println("Вузол Б. Побудова малого заводу негайно.");
        printInfo(D[1][0], D[1][1], P[0][0], P[0][1]);
        System.out.println("Б = " + profitB() );
        System.out.println();

        System.out.println("А1. Побудова великого заводу через 1 рiк. Ймовiрнiсть - " + P[2][0]);
        printInfo(D[0][0], D[0][1], P[2][0], P[2][1]);
        System.out.println("A1 = " + profitA1());
        System.out.println();

        System.out.println("Б1. Побудова малого заводу через 1 рiк. Ймовiрнiсть - " + P[2][0]);
        printInfo(D[1][0], D[1][1], P[2][0], P[2][1]);
        System.out.println("Б1 = " + profitB1());
        System.out.println();

        System.out.println("Отже Вузол В = " + printVuzolV());
        printResult();

    }
    private static double profitA() {
        double a = (P[0][0]*D[0][0]*5 - P[0][1]*D[0][1]*5)-M[0];
        return a;
    }

    private static double profitB() {
        double b = (P[1][0]*D[1][0]*5 - P[1][1]*D[1][1]*5)-M[1];
        return b;
    }

    private static double profitA1() {
        double a1 = (P[2][0]*D[0][0]*4 - P[2][1]*D[0][1]*4)-M[0];
        return a1;
    }

    private static double profitB1() {
        double b1 = (P[2][0]*D[1][0]*4 - P[2][1]*D[1][1]*4)-M[1];
        return b1;
    }

    private static void printInfo(int D1, int D2, double P1, double P2) {
        System.out.println("\t\tВеликий попит  Низький попит");
        System.out.printf("Дохiд%15d%14d\n", D1, D2);
        System.out.printf("Ймовiрнiсть%10.2f\t\t%8.2f\n", P1, P2);
    }

    private static double printVuzolV() {
        double max = Math.max(profitA1(), profitB1());
        double vuzolV = P[3][0]*max-P[3][1]*0;
        return vuzolV;
    }

    private static void printResult(){
        System.out.println("////////////");
        System.out.println("Із всіх значень: " + profitA() + " , " + profitB() + " , " + printVuzolV());
         double a = Math.max(profitA(),profitB());
         double b = Math.max(a,printVuzolV());
        System.out.println("Найбільше значення = " + b);
    }

}
