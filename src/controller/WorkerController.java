/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import bo.WorkerInputer;
import bo.WorkerManager;
import entity.Worker;
import entity.UpdateWorker;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author Thuong
 */
public class WorkerController {
    private WorkerInputer workerinputer;
    private WorkerManager workerManager;
    
    public WorkerController(){
        workerManager = new WorkerManager();
    }
    public Worker addWorker(){
        workerinputer = new WorkerInputer();
        Worker w = workerinputer.inputWorker();
        if(workerManager.addWorker(w)){
            return w;
        }
       return null;
    }
    
    public void displayWorker(){
        workerManager.disPlayWorker();
    }
    public  Worker updateWorker(UpdateWorker.StatusWorker statusWorker) throws Exception{
        String code = ValidationAndNormalizingTextUtil.getStringByRegex("Enter code: ", "Enter code again", "[A-Za-z]+");
        double money = ValidationAndNormalizingTextUtil.getFloat("Enter salảy: ", "Enter number", "Out of ranger", 0, Float.MAX_EXPONENT);
        return workerManager.updateWorker(code, money, statusWorker);
        
    }
    public String displayHistory(){
        return workerManager.toString();
    }
}
