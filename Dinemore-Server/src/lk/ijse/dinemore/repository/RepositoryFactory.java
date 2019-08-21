/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository;

import lk.ijse.dinemore.repository.custom.impl.ChefRepositoryImpl;
import lk.ijse.dinemore.repository.custom.impl.OrderRepositoryImpl;
import lk.ijse.dinemore.repository.custom.impl.ReceptionRepositoryImpl;

/**
 *
 * @author Nayana
 */
public class RepositoryFactory  {
    public enum RepositoryTypes{
        ORDER,CHEF,RECEPTION
    }
    
    public static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        
       switch(repositoryTypes){
              case ORDER :
               return new OrderRepositoryImpl();
                case RECEPTION :
               return new ReceptionRepositoryImpl();
                case CHEF :
               return new ChefRepositoryImpl();
           default:
               return null;
       }
    }
}
