package com.camelia.camelia.controller;

import com.camelia.camelia.model.*;
import com.camelia.camelia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/camelia/prueba")

public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Payment_methodRepository payment_methodRepository;

    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping(path = "/user/all")
    public @ResponseBody
    Iterable<User> getallusers(){
       return userRepository.findAll();
    }

        @GetMapping(path = "/category/all")
    public @ResponseBody
    Iterable<Category> getallcategories(){
        return categoryRepository.findAll();}

    @GetMapping(path = "/provider/all")
    public @ResponseBody
    Iterable<Provider> getallproviders(){
        return providerRepository.findAll();}

    @GetMapping(path = "/product/all")
    public @ResponseBody
    Iterable<Product> getallproducts(){
        return productRepository.findAll();
    }

    @GetMapping(path = "/payment_method/all")
    public @ResponseBody
    Iterable<Payment_method> getallpayment_method(){ return payment_methodRepository.findAll();}

    @GetMapping(path = "/customer/all")
    public @ResponseBody
    Iterable<Customer> getallcustomer(){ return customerRepository.findAll();}

    @GetMapping(path = "/sales/all")
    public @ResponseBody
    Iterable<Sales> getallsales(){ return salesRepository.findAll();}

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    Optional<User> getUserById (@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @GetMapping(path = "/provider/{id}")
    public @ResponseBody
    Optional<Provider> getProviderById (@PathVariable("id") int id){
        return providerRepository.findById(id);
    }

    @GetMapping(path = "/product/{id}")
    public @ResponseBody
    Optional<Product> getProductById (@PathVariable("id") int id){
        return productRepository.findById(id);
    }

    @GetMapping(path = "/category/{id}")
    public @ResponseBody
    Optional<Category> getCategoryById (@PathVariable("id") int id){
        return categoryRepository.findById(id);
    }

    @GetMapping(path = "/customer/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerById (@PathVariable("id") int id){
        return customerRepository.findById(id);
    }

    @GetMapping(path = "/provider/name/like/{name}")
    public @ResponseBody
    Iterable<Provider> getprovidersByNameLike (@PathVariable("name") String name){
        return providerRepository.getProviderByNameLike(name);
    }

    @GetMapping(path = "/product/name/like/{name}")
    public @ResponseBody
    Iterable<Product> getproductsByNameLike (@PathVariable("name") String name){
        return productRepository.getProductsByNameLike(name);
    }

    @GetMapping(path = "/provider/tradename/like/{tradename}")
    public @ResponseBody
    Iterable<Provider> getprovidersByTradenameLike (@PathVariable("tradename") String tradename){
        return providerRepository.getProviderByTradenameLike(tradename);
    }



}
