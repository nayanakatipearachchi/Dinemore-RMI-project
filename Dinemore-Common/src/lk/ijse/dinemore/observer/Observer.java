/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.observer;

import java.rmi.Remote;

/**
 *
 * @author Nayana
 */
public interface Observer extends Remote{
    public void updateObserver()throws Exception;
}
