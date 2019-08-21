/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom;

import java.util.List;
import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.dto.ReceptionDTO;

/**
 *
 * @author Nayana
 */
public interface ReceptionBO extends SuperBO{
  public boolean addReception(ReceptionDTO ReceptionDTO) throws  Exception;
    
    public boolean updateReception(ReceptionDTO ReceptionDTO) throws  Exception;
    
    public boolean deleteReception(String Rid) throws Exception;
    
    public List<ReceptionDTO> getAllReception() throws Exception;
    
    public ReceptionDTO searchReception(String Rid) throws Exception;   
    
}
