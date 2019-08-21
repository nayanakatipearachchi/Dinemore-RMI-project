/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.ChefDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author Nayana
 */
public interface chefService extends SuperService{
     public boolean addChef(ChefDTO ChefDTO) throws Exception;
    
    public boolean deleteChef(String cid) throws Exception;
    
    public ChefDTO searchCustomer(String cid) throws Exception;
    
    public boolean updateChef(ChefDTO ChefDTO) throws Exception;
    
    public List<ChefDTO> getAllChef() throws Exception;

    public boolean reserve(String chefID);

    
}
