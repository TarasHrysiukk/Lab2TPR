import java.text.DecimalFormat;

public class Main {
    private static int[] M = {780, 230};

    private static int[][] D = {
            {250, -60},
            {220, -60}
    };

    private static double[][] P = {
            {0.8, 0.2},
            {0.8, 0.2},
            {0.9, 0.1}
    };

    private static double[] profit = new double[4];

    public static void main(String[] args){
        System.out.println("Вузол 1. Побудова великого заводу негайно.");
        printInfo(D[0][0], D[0][1], P[0][0], P[0][1]);
        System.out.println();
        System.out.println("Вузол 2. Побудова малого заводу негайно.");
        printInfo(D[1][0], D[1][1], P[0][0], P[0][1]);
        System.out.println();
        System.out.println("Вузол 3. Побудова великого заводу через 1 рiк. Ймовiрнiсть - " + P[1][0]);
        printInfo(D[0][0], D[0][1], P[2][0], P[2][1]);
        System.out.println();
        System.out.println("Вузол 4. Побудова малого заводу через 1 рiк. Ймовiрнiсть - " + P[1][0]);
        printInfo(D[1][0], D[1][1], P[2][0], P[2][1]);
        System.out.println();
        System.out.println("Вузол\tБГЕ\t\tОГО\t\tОчікувані доходи");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-8d%-8d%-10.2f%3.2f\n", (i+1), M[i%2],
                    profit[i] = i < 2 ?profit(D[i % 2][0], D[i % 2][1], P[0][0], 5):
                            P[1][i % 2] * profit(D[i % 2][0], D[i % 2][1], P[2][0], 4),
                    (profit[i] - M[i%2]));
        }
        System.out.println();
        printResult();
    }

    private static void printResult() {
        int mini=0, maxi=0;
        double min = (profit[0] - M[0]), max = min;

        for (int i = 1; i < profit.length; i++) {
            if((profit[i] - M[i%2])>max){
                max = (profit[i] - M[i%2]);
                maxi = i;
            }else if((profit[i] - M[i%2])<min){
                min = (profit[i] - M[i%2]);
                mini = i;
            }
        }

        System.out.println("Найкраще рішення - " + ((maxi+1) + max>0?("з доходом " + new DecimalFormat("#0.00").format(max)):
                ("з втратами " + new DecimalFormat("#0.00").format(-1*max))) + " тисяч $");
        System.out.println("Найгірше рішення - " + ((mini+1) + min>0?("з доходом " + new DecimalFormat("#0.00").format(min)):
                ("з втратами " + new DecimalFormat("#0.00").format(-1*min))) + " тисяч $");
    }

    private static double profit(int D1, int D2, double P, int years) {
        return (D1*P + D2*(1-P))*years;
    }

    private static void printInfo(int D1, int D2, double P1, double P2) {
        System.out.println("\t\tВеликий попит  Низький попит");
        System.out.printf("Дохiд%15d%14d\n", D1, D2);
        System.out.printf("Ймовiрнiсть%10.2f\t\t%8.2f\n", P1, P2);
    }
}
