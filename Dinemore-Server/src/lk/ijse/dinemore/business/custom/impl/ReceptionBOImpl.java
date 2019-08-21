/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.ReceptionBO;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.entity.Reception;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.ReceptionRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Nayana
 */
public class ReceptionBOImpl implements ReceptionBO{
      private ReceptionRepository receptionRepository;

    public ReceptionBOImpl() {
        receptionRepository = (ReceptionRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RECEPTION);
    }

    @Override
    public boolean addReception(ReceptionDTO ReceptionDTO) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = new Reception(
                ReceptionDTO.getRid(),
                ReceptionDTO.getName(),
                ReceptionDTO.getAddress(),
                ReceptionDTO.getSalary()
            );
            boolean result = receptionRepository.save(reception);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateReception(ReceptionDTO ReceptionDTO) throws Exception {
          try(Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = new Reception(
                    ReceptionDTO.getRid(),
                    ReceptionDTO.getName(),
                    ReceptionDTO.getAddress(),
                    ReceptionDTO.getSalary()
            );
            boolean result = receptionRepository.update(reception);
            session.getTransaction().commit();
            return result;
        }
    
    }

    @Override
    public boolean deleteReception(String Rid) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = receptionRepository.findByID(Rid);
            boolean result = false;
            if (reception !=null) {
                result = receptionRepository.delete(reception);
            }
            session.getTransaction().commit();
            return result;
        }
    }

//    @Override
//    public List<ReceptionDTO> getAllReception() throws Exception {
//         try(Session session = HibernateUtil.getSessionFactory().openSession()){
//            receptionRepository.setSesstion(session);
//            session.beginTransaction();
//            List<Reception> reception = receptionRepository.findAll();
//            session.getTransaction().commit();
//            if (reception!= null) {
//                System.out.println("Not Null");
//                List<ReceptionDTO> alReception=new ArrayList<>();
//                for (Reception reception : reception) {
//                    ReceptionDTO ReceptionDTO = new ReceptionDTO(
//                            reception.getId(),
//                            reception.getName(),
//                            reception.getAddress(),
//                            reception.getSalary()
//                    );
//                    
//                    System.out.println("Hello :"+reception.getId());
//                    alReception.add(ReceptionDTO);
//                }
//                return alReception;
//            }else{
//                return null;
//            }
//        }
//    }

    @Override
    public ReceptionDTO searchReception(String Rid) throws Exception {
        Reception reception = receptionRepository.findByID(Rid);
        return new ReceptionDTO(
        reception.getId(),
        reception.getName(),
        reception.getAddress(),
         reception.getSalary());
    }

    @Override
    public List<ReceptionDTO> getAllReception() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   