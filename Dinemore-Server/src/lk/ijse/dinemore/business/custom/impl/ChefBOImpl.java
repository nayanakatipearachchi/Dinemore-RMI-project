/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.ChefBO;
import lk.ijse.dinemore.dto.ChefDTO;
import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.ChefRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Nayana
 */
public class ChefBOImpl implements ChefBO{
 private ChefRepository chefRepository;
 
  public ChefBOImpl() {
        chefRepository = (ChefRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CHEF);
    }
    @Override
    public boolean addChef(ChefDTO ChefDTO) throws Exception {
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
            chefRepository.setSesstion(session);
            session.beginTransaction();
            Chef chef = new Chef(
                ChefDTO.getCid(),
                ChefDTO.getName(),
                ChefDTO.getAddress(),
                ChefDTO.getSalary()
            );
            boolean result = chefRepository.save(chef);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateChef(ChefDTO ChefDTO) throws Exception {
  try(Session session = HibernateUtil.getSessionFactory().openSession()){
            chefRepository.setSesstion(session);
            session.beginTransaction();
            Chef chef = new Chef(
                    ChefDTO.getCid(),
                    ChefDTO.getName(),
                    ChefDTO.getAddress(),
                    ChefDTO.getSalary()
            );
            boolean result = chefRepository.update(chef);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteChef(String cid) throws Exception {
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
            chefRepository.setSesstion(session);
            session.beginTransaction();
            Chef chef = chefRepository.findByID(cid);
            boolean result = false;
            if (chef !=null) {
                result = chefRepository.delete(chef);
            }
            session.getTransaction().commit();
            return result;
        }
    }

//    @Override
//    public List<ChefDTO> getAllChef() throws Exception {
//          try(Session session = HibernateUtil.getSessionFactory().openSession()){
//            chefRepository.setSesstion(session);
//            session.beginTransaction();
//            List<Chef> chef = chefRepository.findAll();
//            session.getTransaction().commit();
//            if (chef != null) {
//                System.out.println("Not Null");
//                List<ChefDTO> allChef=new ArrayList<>();
//             for (Chef chef:chef){ 
//                    ChefDTO chefDTO = new ChefDTO(
//                            chef.getId(),
//                            chef.getName(),
//                            chef.getAddress(),
//                            chef.getSalary()
//                    );
//                    
//                    System.out.println("Hello :"+chef.getId());
//                    allChef.add(chefDTO);
//                }
//                return allChef;
//            }else{
//                return null;
//            }
//        }
//}
    @Override
    public ChefDTO searchChef(String cid) throws Exception {
        Chef chef = chefRepository.findByID(cid);
        return new ChefDTO(
        chef.getId(),
        chef.getName(),
        chef.getAddress(),
        chef.getSalary());
    }

    @Override
    public List<ChefDTO> getAllChef() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
