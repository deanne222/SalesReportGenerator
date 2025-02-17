import java.util.Scanner;

public class SalesReportGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Enter a positive number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        double total = 0, highSales = -1;
        String highProduct = "";
        String[] pNames = new String[n];
        double[] pSales = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of product #" + (i + 1) + ": ");
            pNames[i] = sc.nextLine();

            double sales = -1;
            while (sales < 0) {
                System.out.print("Enter sales for " + pNames[i] + ": ");
                try {
                    sales = Double.parseDouble(sc.nextLine());
                    if (sales < 0) {
                        System.out.println("Sales cannot be negative.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                }
            }

            pSales[i] = sales;
            total += sales;

            if (sales > highSales) {
                highSales = sales;
                highProduct = pNames[i];
            }
        }

        double avg = total / n;

        System.out.println("\nSales Report:");
        System.out.println("Total sales: $" + total);
        System.out.println("Average sales: $" + avg);
        System.out.println("Highest-selling product: " + highProduct + " with sales of $" + highSales);

        double sum = 0;
        for (double s : pSales) {
            sum += s;
        }
        System.out.println("\nTotal sales using for-each loop: $" + sum);
    }
}
