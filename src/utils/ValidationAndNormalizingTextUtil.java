/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Thuong
 */
public class ValidationAndNormalizingTextUtil {

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            try {
                int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
                if (ret < min || ret > max) {
                    System.err.println(errorOutOfRange);
                } else {
                    return ret;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static double getDouble(String mess, String errorNumberFormat, String errorOutOfRange, double min, double max) {
        while (true) {
            double ret = Double.parseDouble(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }
}
