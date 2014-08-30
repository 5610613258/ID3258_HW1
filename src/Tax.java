/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import java.util.Scanner;

public class Tax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // เรียกใช้ object รับค่า
        int[] IncomeRange = new int[4]; // ตัวแปรเก็บเงินเดือน
        int[] TaxRate = new int[4];// ตัวแปรเก็บค่าอัตราภาษี
        int sum = 0; // เก็บค่า Total Tax 
        for (int x = 0, y = 1; x < 4; x++, y++) {
            System.out.print("Please enter income and  tax rate  in tax bracket " + y + ": ");
            IncomeRange[x] = sc.nextInt();// รับค่าเงินเดือนขั้นต่ำ
            TaxRate[x] = sc.nextInt();// รับค่าอัตราภาษีตามเงินเดือน
        }
        System.out.print("Please enter tax rate if income > " + IncomeRange[3] + " : ");
        int MaxTaxRate = sc.nextInt(); // รับค่าอัตราภาษีสูงสุด
        System.out.print("Please enter income: ");
        int Income = sc.nextInt();//รับค่า รายได้ต่อปี
        int temp = Income; // เก็บค่ารายได้ต่อปีเพื่อนำไปคำนวน

        // ประมวลผล และ แสดงผล
        for (int x = 0; x < 4; x++) {
            if (x == 0 && TaxRate[x] == 0) {
                System.out.print("0 - " + IncomeRange[x]);
                System.out.print(" you pay ");
                System.out.println((IncomeRange[x] * (TaxRate[x] / 100)) + " baht");
                sum += IncomeRange[x] * (TaxRate[x] / 100.00);
                temp -= IncomeRange[x];
            } else if (x == 0 && TaxRate[x] != 0) {
                System.out.print("0 - " + IncomeRange[x]);
                System.out.printf(" you pay %d x %.2f", IncomeRange[x], (TaxRate[x] / 100.00));
                System.out.print(" = ");
                System.out.printf("%.0f baht\n", (IncomeRange[x] * (TaxRate[x] / 100.00)));
                sum += IncomeRange[x] * (TaxRate[x] / 100.00);
                temp -= IncomeRange[x];
            } else {
                if (Income > IncomeRange[x]) {
                    System.out.print((IncomeRange[x - 1] + 1) + " - " + IncomeRange[x]);
                    System.out.printf(" you pay %d x %.2f", (IncomeRange[x] - IncomeRange[x - 1]), (TaxRate[x] / 100.00));
                    System.out.print(" = ");
                    System.out.printf("%.0f baht\n", ((IncomeRange[x] - IncomeRange[x - 1]) * (TaxRate[x] / 100.00)));
                    sum += (IncomeRange[x] - IncomeRange[x - 1]) * (TaxRate[x] / 100.00);
                    temp -= IncomeRange[x] - IncomeRange[x - 1];
                } else {
                    System.out.print((IncomeRange[x - 1] + 1) + " - " + Income);
                    System.out.printf(" you pay %d x %.2f", (Income - IncomeRange[x - 1]), (TaxRate[x] / 100.00));
                    System.out.print(" = ");
                    System.out.printf("%.0f baht\n", ((Income - IncomeRange[x - 1]) * (TaxRate[x] / 100.00)));
                    sum += (Income - IncomeRange[x - 1]) * (TaxRate[x] / 100.00);
                    temp -= Income - IncomeRange[x - 1];
                }

            }
        }
        if (Income > IncomeRange[3]) {
            System.out.print((IncomeRange[3] + 1) + " - " + Income);
            System.out.printf(" you pay %d x %.2f", temp, (MaxTaxRate / 100.00));
            System.out.print(" = ");
            System.out.printf("%.0f baht\n", temp * (MaxTaxRate / 100.00));
            sum += temp * (MaxTaxRate / 100.00);
        }
        System.out.println("Total Tax : " + sum + " baht");
    }
}
