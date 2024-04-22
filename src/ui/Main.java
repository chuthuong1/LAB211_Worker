/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.WorkerController;
import entity.UpdateWorker;
import entity.Worker;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author Thuong
 */
public class Main {

    public static void main(String[] args) {
        WorkerController workercontroller = new WorkerController();
        while (true) {
            System.out.println("+++ Menu ++");
            System.out.println("+++ 1 Add worker ++");
            System.out.println("+++ 2 Up worker ++");
            System.out.println("+++ 3 Down worker ++");
            System.out.println("+++ 4 Display info update ++");
            System.out.println("+++ 5 Exit ++");
            int choice = ValidationAndNormalizingTextUtil.getInt("Enter choice: ", "Number only ", "out of ranger 1 - 5 ", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        Worker w = workercontroller.addWorker();
                        // System.out.println(String);
                        System.out.println(w);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Worker w = workercontroller.updateWorker(UpdateWorker.StatusWorker.UP);
                        // System.out.println(String);
                        System.out.println(w);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Worker w = workercontroller.updateWorker(UpdateWorker.StatusWorker.DOWN);
                        // System.out.println(String);
                        System.out.println(w);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println(workercontroller.displayHistory());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.exit(5);
                    break;
            }
        }
    }
}
