/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.dto.ChefDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.chefService;

/**
 *
 * @author Nayana
 */
public class ManageChefController {
    public static boolean addChef(ChefDTO cdto) throws Exception{
        chefService chefService = (chefService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.CHEF);
        return chefService.addChef(cdto);
    }
    
//    public static ChefDTO searchChef(String cid) throws Exception{
//        chefService chefService = (chefService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.CHEF);
//        return chefService.searchchef(cid);
//    }
    
    public static boolean removeChef(String cid) throws Exception{
        chefService chefService = (chefService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.CHEF);
        return chefService.deleteChef(cid);
    }
    
    public static boolean updateChef(ChefDTO cdto) throws Exception{
        chefService chefService = (chefService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.CHEF);
        return chefService.updateChef(cdto);
    }
    
    public static List<ChefDTO> getAllChef() throws Exception{
        chefService chefService = (chefService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.CHEF);
        return chefService.getAllChef();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
    }
    
//    public static boolean reserveChef(String cid) throws Exception{
//        chefService chefService = (chefService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.CHEF);
//        return chefService.reserve(cid);
//    }
//    
//    public static boolean releaseChef(String cid) throws Exception{
//        chefService chefService = (chefService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.CHEF);
//        return chefService.release(cid);
//    }
// 
}
