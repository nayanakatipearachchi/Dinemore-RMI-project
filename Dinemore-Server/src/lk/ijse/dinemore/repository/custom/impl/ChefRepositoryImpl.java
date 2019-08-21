/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository.custom.impl;

import java.util.List;
import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.repository.custom.ChefRepository;
import org.hibernate.Session;

/**
 *
 * @author Nayana
 */
public class ChefRepositoryImpl implements ChefRepository{
 private Session session;
    @Override
    public void setSesstion(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Chef t) throws Exception {
        return (session.save(t) != null);
    }
    @Override
    public boolean delete(Chef t) throws Exception {
         session.delete(t);
        return true;
    }

    @Override
    public boolean update(Chef t) throws Exception {
         session.update(t);
        return true;
    }

    @Override
    public Chef findByID(String id) throws Exception {
       return session.get(Chef.class, id);
    }
    @Override
    public List<Chef> findAll() throws Exception {
       return session.createQuery("FROM Chef").list();
    }
    }


