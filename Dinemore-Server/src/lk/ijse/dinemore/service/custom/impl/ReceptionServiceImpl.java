/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.ReceptionBO;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;
import lk.ijse.dinemore.service.custom.ReceptionService;

/**
 *
 * @author Nayana
 */
public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService,Subject{
    private ReceptionBO receptionBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<ReceptionService> cusResBook = new ReservationImpl<>();
    
    public ReceptionServiceImpl() throws Exception{
        receptionBO = (ReceptionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTION);
    }
    @Override
    public boolean addReceptin(ReceptionDTO receptionDTO) throws Exception {
        boolean addReception = receptionBO.addReception(receptionDTO);
        notifyObservers();
        return addReception;
    }

    @Override
    public boolean deleteReception(String Rid) throws Exception {
         boolean deleteReception = receptionBO.deleteReception(Rid);
        notifyObservers();
        return deleteReception;
    }


    @Override
    public ReceptionDTO searchReception(String Rid) throws Exception {
     return receptionBO.searchReception(Rid);
    }


   

    @Override
    public List<ReceptionDTO> getAllReception() throws Exception {
        return receptionBO.getAllReception();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
          return cusResBook.reserve(id, this);
    }


    @Override
    public boolean release(Object id) throws Exception {
         return cusResBook.relese(id);
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
//     new  Thread(()->{
//            for (Observer observer : alObservers) {
//                try {
//                    observer.updateObservers();
//                } catch (Exception ex) {
//                    Logger.getLogger(ReceptionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }).start();
    }

    @Override
    public boolean updateReceptin(ReceptionDTO receptionDTO) throws Exception {
        boolean updateReception = receptionBO.updateReception(receptionDTO);
        notifyObservers();
        return updateReception;
    }
}
