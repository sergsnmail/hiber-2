package com.sergsnmail.hiber2.service;

import com.sergsnmail.hiber2.entity.Customer;
import com.sergsnmail.hiber2.entity.Product;
import com.sergsnmail.hiber2.repository.CustomerRepo;
import com.sergsnmail.hiber2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommonService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    /**
     * Метод возвращает список купленых продуктов по id покупателя
     * @param id идентификатор покупателя
     * @return
     */
    public List<Product> getCustomerProduct(Long id){
       return customerRepo.get(Customer.class, id).getProducts();
    }

    /**
     * Метод возвращает всех покупателей продукта с указаным id
     * @param id идентификатор продукта
     * @return
     */
    public List<Customer> getProductOrderedCustomer(Long id){
        return productRepo.get(Product.class, id).getCustomers();
    }

}
