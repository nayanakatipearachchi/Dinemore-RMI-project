/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom;

import java.util.List;
import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.dto.OrderDTO;

/**
 *
 * @author Nayana
 */
public interface OrderBO extends SuperBO{
    public boolean addOrder(OrderDTO orderDTO) throws  Exception;
    
    public boolean updateOrder(OrderDTO orderDTO) throws  Exception;
    
    public boolean deleteOrder(String reception_id) throws Exception;
    
    public List<OrderDTO> getAllOrder() throws Exception;
    
    public OrderDTO searchOrder(String reception_id) throws Exception;
}
