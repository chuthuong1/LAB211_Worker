/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Worker;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author Thuong
 */
public class WorkerInputer {

    private Worker worker;

    public WorkerInputer() {
        worker = new Worker();
    }

    public Worker inputWorker() {
        worker.setCode(ValidationAndNormalizingTextUtil.getStringByRegex("Enter code: ", "Erro format", "[A-Za-z]+"));
        worker.setName(ValidationAndNormalizingTextUtil.getStringByRegex("Enter Name: ", "Erro format", "[A-Za-z]+"));
        worker.setAge(ValidationAndNormalizingTextUtil.getInt("Enter Age: ", "number only", "Out off ranger", 1, Integer.MAX_VALUE));
        worker.setSalary(ValidationAndNormalizingTextUtil.getDouble("Salary: ", "erro fomat", "out of ranger", 0, Double.MAX_VALUE));
        worker.setWorkLocation(ValidationAndNormalizingTextUtil.getStringByRegex("Enter WorkerLocation: ", "Erro format", "[A-Za-z]+"));
        return worker;
    }
}
