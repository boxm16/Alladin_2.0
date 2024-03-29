/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CustomerDao;
import Models.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Michail Sitmalidis
 */
public class CustomerController {

    CustomerDao customerDao;

    public CustomerController() {
        customerDao = new CustomerDao();
    }

    public Customer getCustomerById(int id) {

        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    public ArrayList<Customer> getCustomerByLastName(String lastName) {
        ArrayList<Customer> customers = customerDao.getCustomersByLastName(lastName);
        return customers;
    }

    public ArrayList<Customer> getCustomerByLandLineNumber(String landLine) {
        ArrayList<Customer> customers = customerDao.getCustomerByLandLineNumber(landLine);
        return customers;
    }

    public ArrayList<Customer> getCustomerByMobileNumber(String mobile) {
        ArrayList<Customer> customers = customerDao.getCustomerByMobileNumber(mobile);
        return customers;
    }

    public void saveNewCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    public boolean checkCustomerById(int id) {
        Customer customer = getCustomerById(id);
        if (customer == null) {
            JOptionPane.showMessageDialog(null,
                    "ΔΕΝ ΥΠΑΡΧΕΙ ΠΕΛΑΤΗΣ ΜΕ ΑΥΤΟ ΤΟΝ ΚΩΔΙΚΟ",
                    "ΛΑΘΟΣ ΚΩΔΙΚΟΣ ΠΕΛΑΤΗ",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Customer> getReadyToGoCustomers() {
        return customerDao.getReadyToGoCustomers();
    }

}
