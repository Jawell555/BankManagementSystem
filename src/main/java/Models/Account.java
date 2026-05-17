/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Ruell
 */
public class Account {

        String accName;
        String accNo;
        double accBal;
        String accType;
        
        //Get
        public String getName(){
            return accName;
        }
        public String getAccNo(){
            return accNo;
        }
        public double getAccBal(){
            return accBal;
        }
        public String getAccType(){
            return accType;
        }
        
        //Set
        
        //Account(accName, accNo, accBal, accType)
        public void setName(String accName){
            this.accName = accName;
        }
        public void setAccNo(String accNo){
            this.accNo = accNo;
        }
        public void setAccBal(double accBal){
            this.accBal =  accBal;
        }
        public void setAccType(String accType){
            this.accType = accType;
        }
}
