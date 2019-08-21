/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom;

import java.util.List;
import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.dto.ChefDTO;

/**
 *
 * @author Nayana
 */
public interface ChefBO  extends SuperBO{
    public boolean addChef(ChefDTO ChefDTO) throws  Exception;
    
    public boolean updateChef(ChefDTO ChefDTO) throws  Exception;
    
    public boolean deleteChef(String cid) throws Exception;
    
    public List<ChefDTO> getAllChef() throws Exception;
    
    public ChefDTO searchChef(String cid) throws Exception;
}
