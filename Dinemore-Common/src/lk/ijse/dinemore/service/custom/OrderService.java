/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author Nayana
 */
public interface OrderService extends SuperService{
    public boolean addOrder(OrderDTO orderDTO) throws Exception;
    
    public boolean deleteOrder(String reception_id) throws Exception;
    
    public OrderDTO searchOrder(String reception_id) throws Exception;
    
    public boolean updateOrder(OrderDTO orderDTO) throws Exception;
    
    public List<OrderDTO> getAllOrder() throws Exception;
}
