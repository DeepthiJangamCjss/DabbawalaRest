package com.example.DabhaWala.service;

import com.example.DabhaWala.entity.Customer;
import com.example.DabhaWala.models.CustomerModel;
import com.example.DabhaWala.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer customerModelToEntity(CustomerModel customerModel){
        if(customerModel==null){
            return null;
        }
        Customer customer=new Customer();
        customer.setUsername(customerModel.getUsername());
        customer.setPassword(customerModel.getPassword());
        customer.setCustomerId(customerModel.getCustomerId());
        customer.setName(customerModel.getName());
        customer.setAge(customerModel.getAge());
        customer.setEmail(customerModel.getEmail());
        customer.setAccountBalance(customerModel.getAccountBalance());
        customer.setMembershipType(customerModel.getMembershipType());
        customer.setOrderList(customerModel.getOrderList());
        return customer;
    }
    public CustomerModel customerEntityToModel(Customer customer) {
        if(customer==null){
            return null;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setUsername(customer.getUsername());
        customerModel.setPassword(customer.getPassword());
        customerModel.setCustomerId(customer.getCustomerId());
        customerModel.setName(customer.getName());
        customerModel.setAge(customer.getAge());
        customerModel.setEmail(customer.getEmail());
        customerModel.setAccountBalance(customer.getAccountBalance());
        customerModel.setMembershipType(customer.getMembershipType());
        customerModel.setOrderList(customer.getOrderList());
        return customerModel;
    }

    public String addCustomer(CustomerModel customerModel) {
        Customer customerFound = customerRepo.findByUsername(customerModel.getUsername());
        if(customerFound!=null){
            return "User with this username Already Exists. Try with other username";
        }
        Customer customer=customerModelToEntity(customerModel);
        customerRepo.save(customer);
        return "Customer added Successfully";
    }

    public CustomerModel getCustomerDetails(int customerId) {
        boolean customerFound= customerRepo.existsById(customerId);
        if(customerFound){
            Customer customer= customerRepo.getReferenceById(customerId);
            return customerEntityToModel(customer);
        }
        return null;
    }
}
