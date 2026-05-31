/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Ruell
 */
public class Transaction {
    private LocalDateTime transacDate;
    private String historyType;
    private String accName;
    private String accNumber;
    private String transacInfo;
    private String altAccName;
    private double transacAmount;
    private String refNumber;
   
    
    public Transaction(String refNumber, String accName, String accNumber, String transacInfo,
            String altAccName, LocalDateTime transacDate, String historyType,
            double transacAmount){
    this.transacDate = transacDate;
    this.historyType = historyType;
    this.accName = accName;
    this.accNumber = accNumber;
    this.transacInfo = transacInfo;
    this.altAccName = altAccName;
    this.transacAmount = transacAmount;
    this.refNumber = refNumber;
}
    //SET
    
    public void setTransacDate(LocalDateTime transacDate){
        this.transacDate = transacDate;
    }
    public void setHistoryType(String historyType){
        this.historyType = historyType;
    }
    public void setAccName(String accName){
        this.accName = accName;
    }
    public void setAccNumber(String accNumber){
        this.accNumber = accNumber;
    }
    public void setAltAccName(String altAccName){
        this.altAccName = altAccName;
    }
    public void setTransacInfo(String transacInfo){
        this.transacInfo= transacInfo;
    }
    public void setTransacAmount(double transacAmount){
        this.transacAmount = transacAmount;
    }
    public void setRefNumber(String refNumber){
        this.refNumber = refNumber;
    }
    
    
    //Get
    public LocalDateTime getTransacDate(){
        return transacDate;
    }
    public String getHistoryType(){
        return historyType;
    }
    public String getAccName(){
        return accName;
    }
    public String getAccNumber(){
        return accNumber;
    }
    public String getAltAccName(){
        return altAccName;
    }
    public String getTransacInfo(){
        return transacInfo;
    }
    public double getTransacAmount(){
        return transacAmount;
    }
    public String getRefNumber(){
        return refNumber;
    }
    
  
}
