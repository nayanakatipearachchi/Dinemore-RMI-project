/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.OrderService;

/**
 *
 * @author Nayana
 */
public class OrderController {
    public static boolean addCustomer(OrderDTO cdto) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.addOrder(cdto);
    }
    
    public static OrderDTO searchCustomer(String cid) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.searchOrder(cid);
    }
    
    public static boolean removeCustomer(String cid) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.deleteOrder(cid);
    }
    
    public static boolean updateCustomer(OrderDTO cdto) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.updateOrder(cdto);
    }
    
    public static List<OrderDTO> getAllCustomers() throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.getAllOrder();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    }
    
    public static boolean reserveCustomer(String customerID) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.reserve(customerID);
    }
    
    public static boolean releaseCustomer(String customerID) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDER);
        return orderService.release(customerID);
    }

    
}
