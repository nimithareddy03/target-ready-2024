package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;

import java.util.List;

public interface CustomerDao {
    public Customer save(Customer customer) throws DaoException;

    public Customer getById(int id) throws DaoException;

    public void update(Customer customer) throws DaoException;

    public Customer deleteById(int id) throws DaoException;

    public List<Customer> getAll() throws DaoException;

    public Customer getByEmail(String email) throws DaoException;

    public Customer getByPhone(String phone) throws DaoException;

    public List<Customer> getByCity(String city) throws DaoException;
}