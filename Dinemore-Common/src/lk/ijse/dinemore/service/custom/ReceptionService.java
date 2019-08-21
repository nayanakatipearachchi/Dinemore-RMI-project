/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author Nayana
 */
public interface ReceptionService  extends SuperService{
    public boolean addReceptin(ReceptionDTO ReceptionDTO) throws Exception;
    
    public boolean deleteReception(String Rid) throws Exception;
    
    public ReceptionDTO searchReception(String Rid) throws Exception;
    
    public boolean updateReceptin(ReceptionDTO ReceptionDTO) throws Exception;
    
    public List<ReceptionDTO> getAllReception() throws Exception;
}
