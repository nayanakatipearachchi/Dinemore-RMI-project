/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.ChefBOImpl;
import lk.ijse.dinemore.business.custom.impl.OrderBOImpl;
import lk.ijse.dinemore.business.custom.impl.ReceptionBOImpl;

/**
 *
 * @author Nayana
 */
public class BOFactory {
    public enum BOTypes{
        ORDER,CHEF,RECEPTION
    }
    
    private static BOFactory bOFactory;

    private BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes bOTypes){
        switch(bOTypes){
                case ORDER: 
                return new OrderBOImpl();
                case CHEF: 
                return new ChefBOImpl();
                case RECEPTION: 
                return new ReceptionBOImpl();
            default: return null;
        }
    }
}
