/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.dto;

/**
 *
 * @author Nayana
 */
public class ReceptionDTO {
    private String Rid;
    private String name;
    private String address;
    private double salary;
    
    public ReceptionDTO(){
        
    }

    public ReceptionDTO(String Rid, String name, String address, double salary) {
        this.Rid = Rid;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String Rid) {
        this.Rid = Rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
