package com.targetindia.miniproject.dao;


import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.utils.JpaUtil;
import com.targetindia.miniproject.utils.Printer;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class JpaCustomerDao implements CustomerDao {
    @Override
    public Customer save(Customer customer) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                em.persist(customer);
                tx.commit();
                return customer;
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(int id) throws DaoException {
        Customer customer = null;
        try (EntityManager cm = JpaUtil.createEntityManager();) {
            customer = cm.find(Customer.class, id); // SQL SELECT is created and executed by the JPA provider
        }
        return customer;
    }

    @Override
    public void update(Customer customer) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                em.persist(customer);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        Customer customer = getById(id);
        try (var em = JpaUtil.createEntityManager()) {
            em.remove(customer);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            return em.createQuery("from Customer", Customer.class)
                    .getResultList();
        } catch (Exception e) {
            log.warn("error while calling JpaCustomerDao.getAll()", e);
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        Customer customer = null;
        try (EntityManager cm = JpaUtil.createEntityManager();) {
            customer = cm.find(Customer.class, email); // SQL SELECT is created and executed by the JPA provider
        }
        return customer;
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        Customer customer = null;
        try (EntityManager cm = JpaUtil.createEntityManager();) {
            customer = cm.find(Customer.class, phone); // SQL SELECT is created and executed by the JPA provider
        }
        return customer;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        List<Customer> customer = null;
        try (EntityManager cm = JpaUtil.createEntityManager();) {
            customer = Collections.singletonList(cm.find(Customer.class, city)); // SQL SELECT is created and executed by the JPA provider
        }
        return customer;
    }
}