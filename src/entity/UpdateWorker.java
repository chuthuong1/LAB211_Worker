/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Thuong
 */
public class UpdateWorker {

    private Worker worker;
    private double salaryUpdate;
    private LocalDate date;
    private StatusWorker statusWorker;

    public enum StatusWorker {
        UP,
        DOWN;

        public String getStatusWorker() {
            switch (this) {
                case UP:
                    return "UP";
                case DOWN:
                    return "DOWN";
            }
            throw new IllegalArgumentException("Invalid status: " + this);
        }
    }

    public UpdateWorker() {
    }

    public UpdateWorker(Worker worker, double salaryUpdate, LocalDate date, StatusWorker statusWorker) {
        this.worker = worker;
        this.salaryUpdate = salaryUpdate;
        this.date = date;
        this.statusWorker = statusWorker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public double getSalaryUpdate() {
        return salaryUpdate;
    }

    public void setSalaryUpdate(double salaryUpdate) {
        this.salaryUpdate = salaryUpdate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatusWorker getStatusWorker() {
        return statusWorker;
    }

    public void setStatusWorker(StatusWorker statusWorker) {
        this.statusWorker = statusWorker;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20d %-20.0f %-20s %-20s", worker.getCode(), worker.getName(), worker.getAge(), salaryUpdate, date, statusWorker);
    }

}
