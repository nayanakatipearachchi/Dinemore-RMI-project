/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Nayana
 */
public interface SuperRepository <T,ID>{
    public void setSesstion(Session session);
  
    public boolean save(T t) throws Exception;
    
    public boolean delete(T t) throws Exception;
    
    public boolean update(T t) throws Exception;
    
    public T findByID(ID id) throws Exception;
    
    public List<T> findAll() throws Exception;
    
}
