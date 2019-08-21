/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.ReceptionService;

/**
 *
 * @author Nayana
 */
public class ManageReceptionController {
    public static boolean addReception(ReceptionDTO cdto) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.addReceptin(cdto);
    }
    
    public static ReceptionDTO searchReception(String Rid) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.searchReception(Rid);
    }
    
    public static boolean removeReception(String Rid) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.deleteReception(Rid);
    }
    
//    public static boolean updateReception(ReceptionDTO receptiondto) throws Exception{
//        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
//                        .getService(ServiceFactory.ServiceType.RECEPTION);
//        return receptionService.updateReception(receptiondto);
//    }
    
    public static List<ReceptionDTO> getAllReception() throws Exception{
        ReceptionService ReceptionService = (ReceptionService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.RECEPTION);
        return ReceptionService.getAllReception();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
    }
    
//    public static boolean reserveReception(String RID) throws Exception{
//        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.RECEPTION);
//        return receptionService.reserve(RID);
//    }
//    
//    public static boolean releaseReception(String RID) throws Exception{
//        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.RECEPTION);
//        return ReceptionService.release(RID);
//    }
}

    

