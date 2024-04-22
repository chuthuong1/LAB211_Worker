/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.UpdateWorker;
import entity.Worker;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Thuong
 */
public class WorkerManager {

    private UpdateWorker updateWorker;
    private ArrayList<Worker> worker;
    private ArrayList<UpdateWorker> updateWorkers;

    public WorkerManager() {
        updateWorker = new UpdateWorker();
        worker = new ArrayList<>();
        updateWorkers = new ArrayList<>();
    }

    private int findIdWorker(String code) {
        for (int i = 0; i < worker.size(); i++) {
            if (worker.get(i).getCode().contains(code)) {
                return i;
            }
        }
        return -1;
    }

    public Worker getWorkerById(String code) {
        int index = findIdWorker(code);
        if (index != -1) {
            return worker.get(index);
        }
        return null;
    }

    public boolean addWorker(Worker w) throws Exception {
        if (getWorkerById(w.getCode()) == null) {
            return worker.add(w);
        }
        throw new Exception("Da ton tai");
    }

    public void disPlayWorker() {
        for (Worker worker1 : worker) {
            System.out.println(worker1);
        }
    }

    public Worker updateWorker(String code, double money, UpdateWorker.StatusWorker statusWorker) throws Exception {
        Worker w = getWorkerById(code);
        if (w == null) {
            throw new Exception("Id not found! ");
        }
        double update = 0;
        switch (statusWorker) {
            case UP:
                update = w.getSalary() + money;
                break;
            case DOWN:
                if (money > w.getSalary() + money) {
                    throw new Exception("ko duoc lown hon luong hien tai");
                }
                update = w.getSalary() - money;
                break;
        }
        w.setSalary(update);
        updateWorker.setSalaryUpdate(update);
        updateWorker.setStatusWorker(statusWorker);
        updateWorker.setDate(LocalDate.now());
        updateWorkers.add(new UpdateWorker(w, updateWorker.getSalaryUpdate(), updateWorker.getDate(), updateWorker.getStatusWorker()));
        return w;
    }

    @Override
    public String toString() {
        String listUpdate = "";
        for (UpdateWorker worker1 : updateWorkers) {
            return listUpdate += worker1;
        }
        return listUpdate;
    }
}
