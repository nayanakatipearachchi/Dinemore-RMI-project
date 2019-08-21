/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.OrderBO;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.entity.Orders;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.OrderRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Nayana
 */
public class OrderBOImpl implements OrderBO {

    private OrderRepository orderRepository;

    public OrderBOImpl() {
        orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDER);
    }

    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getReception_id(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCus_name(),
                    orderDTO.getTp_no(),
                    orderDTO.getQty(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getReception_id(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCus_name(),
                    orderDTO.getTp_no(),
                    orderDTO.getQty(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.update(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            List<Orders> orders = orderRepository.findAll();
            session.getTransaction().commit();
            if (orders != null) {
                System.out.println("Not Null");
                List<OrderDTO> alOrders = new ArrayList<>();
                for (Orders order : orders) {
                    OrderDTO orderDTO = new OrderDTO(
                            order.getReception_id(),
                            order.getDate(),
                            order.getTime(),
                            order.getCus_name(),
                            order.getTp_no(),
                            order.getQty(),
                            order.getStatus()
                    );

                    System.out.println("Hello :" + order.getReception_id());
                    alOrders.add(orderDTO);
                }
                return alOrders;
            } else {
                return null;
            }
        }
    }

    @Override
    public OrderDTO searchOrder(String reception_id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOrder(String reception_id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
