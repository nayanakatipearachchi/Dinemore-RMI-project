/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository.custom.impl;

import java.util.List;
import lk.ijse.dinemore.entity.Reception;
import lk.ijse.dinemore.repository.custom.ReceptionRepository;
import org.hibernate.Session;

/**
 *
 * @author Nayana
 */
public class ReceptionRepositoryImpl  implements ReceptionRepository{
 private Session session;
    @Override
    public void setSesstion(Session session) {
         this.session = session;
    }

    @Override
    public boolean save(Reception t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public boolean delete(Reception t) throws Exception {
       session.delete(t);
        return true;
    }
    @Override
    public boolean update(Reception t) throws Exception {
       session.update(t);
        return true;
    }

    @Override
    public Reception findByID(String id) throws Exception {
         return session.get(Reception.class, id);
    }

    @Override
    public List<Reception> findAll() throws Exception {
       return session.createQuery("FROM Customer").list();
    }
    
}
