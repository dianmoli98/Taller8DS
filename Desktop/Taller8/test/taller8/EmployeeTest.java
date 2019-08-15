/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller8;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CltControl
 */
public class EmployeeTest {
    
    /**
     * Debe retornar la rmu completa al ser empleado Worker y Currency es USD
     */
    @Test
    public void bonusWorkerUSD() {
        float salario = 400;
        Employee e = new Employee(salario, "USD", 0.5F , EmployeeType.Worker);
        assertEquals(386* 100,(int) e.CalculateYearBonus() *100 );
    }
    
     /**
     * Debe retornar salario + (bonusPercentage * 0.35F) 
     * al ser empleado Supervisor y Currency es USD
     */
    @Test
    public void bonusSupUSD() {
        float salario = 400.0F;
        Employee e = new Employee(salario, "USD", 0.5F , EmployeeType.Supervisor);
        assertEquals((int)(salario + 386*0.5 )* 100,(int) e.CalculateYearBonus()* 100);
    }
    
     /**
     * Debe retornar la rmu completa al ser empleado Worker y Currency es UK
     */
    @Test
    public void bonusManagerUSD() {
        Employee e = new Employee(400, "USD", 0.5F , EmployeeType.Manager);
        assertEquals((int)(400 + 386 )* 100,(int) e.CalculateYearBonus()* 100);
    }
    
     /**
     * Debe retornar la rmu completa al ser empleado Worker y Currency es UK
     */
    @Test
    public void bonusWorker() {
        Employee e = new Employee(400, "UK", 0.5F , EmployeeType.Worker);
        assertEquals(386 * 100,(int) e.CalculateYearBonus()* 100);
    }
    
     /**
     * Debe retornar salario + (bonusPercentage * 0.35F) 
     * al ser empleado Supervisor y Currency es UK entonces salario se
     * reduce 5%
     */
    @Test
    public void bonusSup() {
        Employee e = new Employee(400, "UK", 0.5F , EmployeeType.Supervisor);
        assertEquals((int)(400*0.95 + 386*0.5 )* 100,(int) e.CalculateYearBonus()* 100);
    }
    
     /**
     * Debe retornar salario + (salario + rmu) 
     * al ser empleado Supervisor y Currency es UK entonces salario se
     * reduce 5%
     */
    @Test
    public void bonusManager() {
        Employee e = new Employee(400, "UK", 0.5F , EmployeeType.Manager);
        assertEquals((int)(400*0.95 + 386 )* 100,(int) e.CalculateYearBonus()* 100);
    }
    
    /**
     * Si el mes es impar se entrega el decimo con el salario y si es par solo el salario, validando 
     * que la moneda es USD 
     */
    @Test
    public void csWorkerUSD(){
        float salario = 400;
        Employee e = new Employee(salario, "USD", 0.5F , EmployeeType.Worker);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
         
         if(month%2 == 0)
            assertEquals((int)salario* 100,(int) e.cs()* 100);
        else{
            assertEquals((int)(salario+ 360.0/12*2)* 100,(int) e.cs()* 100);
        }
       
    }
    
    /**
     * Si el mes es impar se entrega el decimo con el salario y un bono.
     * Si es par solo el salario + bono *0.7F, validando 
     * que la moneda es USD 
     */
    @Test
    public void csManagerUSD(){
        float salario = 400;
        float bono = 0.5F ;
        
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         int month = localDate.getMonthValue();
        
        Employee e = new Employee(salario, "USD", bono , EmployeeType.Supervisor);
        
        float valor = (salario + bono * 0.70F);
        if(month%2 == 0)
            assertEquals((int)valor* 100,(int) e.cs()* 100);
        else{
            assertEquals((int)(valor+ 360.0/12*2)* 100,(int) e.cs()* 100);
        }
    }
    
    /**
     * Si el mes es impar se entrega el decimo con el salario y un bono.
     * Si es par solo el salario + bono *0.35F, validando 
     * que la moneda es USD 
     */
    @Test
    public void csSupUSD(){
        float salario = 400;
        float bono = 0.5F ;
        
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         int month = localDate.getMonthValue();
        
        Employee e = new Employee(salario, "USD", bono , EmployeeType.Supervisor);
        
        float valor = (salario + bono * 0.35F);
        if(month%2 == 0)
            assertEquals((int)valor* 100,(int) e.cs()* 100);
        else{
            assertEquals((int)(valor+ 360.0/12*2)* 100,(int) e.cs()* 100);
        }
    }
    
    
}
