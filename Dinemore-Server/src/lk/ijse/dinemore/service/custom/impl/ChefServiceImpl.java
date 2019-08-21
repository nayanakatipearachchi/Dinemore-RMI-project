/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.ChefBO;
import lk.ijse.dinemore.dto.ChefDTO;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;
import lk.ijse.dinemore.service.custom.ReceptionService;
import lk.ijse.dinemore.service.custom.chefService;

/**
 *
 * @author Nayana
 */
public class ChefServiceImpl  extends UnicastRemoteObject implements chefService,Subject{
    private ChefBO chefBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<chefService> cusResBook = new ReservationImpl<>();


   public ChefServiceImpl() throws Exception{
        chefBO = (ChefBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CHEF);
    }

    @Override
    public boolean addChef(ChefDTO ChefDTO) throws Exception {
         boolean addchef = chefBO.addChef(ChefDTO);
        notifyObservers();
        return addchef;
    }

    @Override
    public boolean deleteChef(String cid) throws Exception {
        boolean deleteChef = chefBO.deleteChef(cid);
        notifyObservers();
        return deleteChef;
    
    }
   

    @Override
    public boolean updateChef(ChefDTO ChefDTO) throws Exception {
     boolean updateChef = chefBO.updateChef(ChefDTO);
        notifyObservers();
        return updateChef;
    }

    @Override
    public List<ChefDTO> getAllChef() throws Exception {
       return chefBO.getAllChef();
    }

    @Override
    public boolean reserve(String chefID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
      alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
 }
//
//    @Override
//    public ChefDTO searchChef(String cid) throws Exception {
//        return chefBO.searchChef(cid);
    

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this);
    }
    @Override
    public boolean release(Object id) throws Exception {
         return cusResBook.relese(id);
    }

    @Override
    public ChefDTO searchCustomer(String cid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

