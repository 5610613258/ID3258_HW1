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
        int sum = 0;
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

        if (Income > IncomeRange[0]) {
            System.out.println("0 - 150000 you pay 0 baht");
            temp -= 150000;
        } else {
            System.out.print("0 - " + Income);
            System.out.println(" you pay 0 baht");
            System.out.println("Total Tax : " + sum + " baht");
            System.exit(0);
        }

        if (Income > IncomeRange[1]) {
            System.out.print("150001 – 300000 you pay ");
            System.out.print("150000 x 0.05 = ");
            System.out.println(150000 * TaxRate[1] / 100 + " baht");
            sum += (150000 * TaxRate[1] / 100);
            temp -= 150000;
        } else {
            System.out.print("150001 - " + Income + " you pay ");
            System.out.print(temp + " x 0.05 = ");
            System.out.print(temp * TaxRate[1] / 100);
            System.out.println(" baht");
            sum += (temp * TaxRate[1] / 100);
            System.out.println("Total Tax : " + sum + " baht");
            System.exit(0);
        }

        if (Income > IncomeRange[2]) {
            System.out.print("300001 – 500000 you pay ");
            System.out.print("200000 x 0.10 = ");
            System.out.println(200000 * TaxRate[2] / 100 + " baht");
            sum += (200000 * TaxRate[2] / 100);
            temp -= 200000;
        } else {
            System.out.print("300001 - " + Income + " you pay ");
            System.out.print(temp + " x 0.10 = ");
            System.out.print(temp * TaxRate[2] / 100);
            System.out.println(" baht");
            sum += (temp * TaxRate[2] / 100);
            System.out.println("Total Tax : " + sum + " baht");
            System.exit(0);
        }

        if (Income >= IncomeRange[3]) {
            System.out.print("500001 – 750000 you pay ");
            System.out.print("200000 x 0.10 = ");
            System.out.println(250000 * TaxRate[3] / 100 + " baht");
            sum += (250000 * TaxRate[3] / 100);
            temp -= 250000;
        } else {
            System.out.print("500001 - " + Income + " you pay ");
            System.out.print(temp + " x 0.15 = ");
            System.out.print(temp * TaxRate[3] / 100);
            System.out.println(" baht");
            sum += (temp * TaxRate[3] / 100);
            System.out.println("Total Tax : " + sum + " baht");
            System.exit(0);
        }

        if (Income > 750000) {
            System.out.print("750001 - " + Income + " you pay ");
            System.out.print(temp + " x 0.20 = ");
            System.out.print(temp * MaxTaxRate / 100);
            System.out.println(" baht");
            sum += (temp * MaxTaxRate / 100);
            System.out.println("Total Tax : "+ sum +" baht");
            System.exit(0);
        }
        
    }

}
