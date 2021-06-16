package com.camelia.camelia.controller;
import com.camelia.camelia.model.*;
import com.camelia.camelia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private CustomerRepository customerRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SaleRepository saleRepository;

    //////////////////////        READ        //////////////////////

    @GetMapping(path = "/sale/all")
    public @ResponseBody
    Iterable<Sale> getallsale() {
        return saleRepository.findAll();
    }

    @GetMapping(path = "/user/all")
    public @ResponseBody
    Iterable<User> getallusers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/category/all")
    public @ResponseBody
    Iterable<Category> getallcategories() {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/provider/all")
    public @ResponseBody
    Iterable<Provider> getallproviders() {
        return providerRepository.findAll();
    }

    @GetMapping(path = "/product/all")
    public @ResponseBody
    Iterable<Product> getallproducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/payment_method/all")
    public @ResponseBody
    Iterable<Payment_method> getallpayment_method() {
        return payment_methodRepository.findAll();
    }

    @GetMapping(path = "/customer/all")
    public @ResponseBody
    Iterable<Customer> getallcustomer() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/invoice/all")
    public @ResponseBody
    Iterable<Invoice> getallinvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    ResponseEntity<UserResponse> getUserById(@PathVariable("id") int id_user) {
        UserResponse response = new UserResponse();
        try {
            response.setUser(userRepository.findById(id_user).get());
            response.setMessage("Usuario encontrado");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setUser(userRepository.findById(1).get());
            response.setMessage("Usuario no encontrado:" + " " + response.getMessage() + " " + response.getClass());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/provider/{id}")
    public @ResponseBody
    Optional<Provider> getProviderById(@PathVariable("id") int id) {
        return providerRepository.findById(id);
    }

    @GetMapping(path = "/product/{id}")
    public @ResponseBody
    Optional<Product> getProductById(@PathVariable("id") int id) {
        return productRepository.findById(id);
    }

    @GetMapping(path = "/category/{id}")
    public @ResponseBody
    Optional<Category> getCategoryById(@PathVariable("id") int id) {
        return categoryRepository.findById(id);
    }

    @GetMapping(path = "/customer/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerById(@PathVariable("id") int id) {
        return customerRepository.findById(id);
    }

    @GetMapping(path = "/payment_method/{id}")
    public @ResponseBody
    Optional<Payment_method> getPaymentMethodById(@PathVariable("id") int id) {
        return payment_methodRepository.findById(id);
    }

    @GetMapping(path = "/invoice/{id}")
    public @ResponseBody
    Optional<Invoice> getInvoicesById(@PathVariable("id") int id) {
        return invoiceRepository.findById(id);
    }

    @GetMapping(path = "/sale/{id}")
    public @ResponseBody
    Optional<Sale> getSalesById(@PathVariable("id") int id) {
        return saleRepository.findById(id);
    }

    //////////////////////        CUSTOM QUERIES        //////////////////////

    @GetMapping(path = "/provider/nameortradename/like/{tradename}{name}")
    public @ResponseBody
    Iterable<Provider> getProviderByNameOrTradenameLike(@PathVariable("tradename") String tradename, @PathVariable("name") String name) {
        return providerRepository.getProviderByNameOrTradenameLike(tradename, name);
    }

    @GetMapping(path = "/product/name/like/{name}")
    public @ResponseBody
    Iterable<Product> getProductsByNameLike(@PathVariable("name") String name) {
        return productRepository.getProductsByNameLike(name);
    }

    @GetMapping(path = "/customer/name/like/{name}")
    public @ResponseBody
    Iterable<Customer> getCustomersByNameLike(@PathVariable("name") String name) {
        return customerRepository.getCustomersByNameLike(name);
    }

    //////////////////////        DELETE        //////////////////////
    @DeleteMapping(path = "/category/delete/{id_category}")
    public @ResponseBody
    Iterable<Category> deleteCategoryById(@PathVariable("id_category") int id_category) {
        categoryRepository.deleteById(id_category);
        return categoryRepository.findAll();
    }

    @DeleteMapping(path = "/provider/delete/{id_provider}")
    public @ResponseBody
    Iterable<Provider> deleteProviderById(@PathVariable("id_provider") int id_provider) {
        providerRepository.deleteById(id_provider);
        return providerRepository.findAll();
    }

    ///////////// borrado de producto solo por usuario admin
    @DeleteMapping(path = "/loggeduser/{id_loggeduser}/product/delete/{id_product}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteProductByLoggedUser(@PathVariable("id_product") int id_product, @PathVariable("id_loggeduser") int id_loggeduser) {
        GeneralResponse response = new GeneralResponse();
        try {
            User loggeduser = userRepository.findById(id_loggeduser).get();
            if (loggeduser.getId_user_role().getId_user_role() ==1) {
               productRepository.deleteById(id_product);
               response.setCode(HttpStatus.OK.value());
               response.setMessage("El producto fue eliminado correctamente");
                return ResponseEntity.ok(response);
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("El usuario no tiene autorización para eliminar productos, consulte con el adminsitrador");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage(HttpStatus.CONFLICT.getReasonPhrase()+ " - "+e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @DeleteMapping(path = "/customer/delete/{id_customer}")
    public @ResponseBody
    Iterable<Customer> deleteCustomerById(@PathVariable("id_customer") int id_customer) {
        customerRepository.deleteById(id_customer);
        return customerRepository.findAll();
    }

    //////////////////////        UPDATE        //////////////////////

    @PutMapping(path = "category/update/{id_category}")
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return categoryRepository.save(updatedCategory);
    }

    @PutMapping(path = "customer/update/{id_customer}")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
        return customerRepository.save(updatedCustomer);
    }
    // restringir acceso
    @PutMapping(path = "product/update/{id_product}")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    @PutMapping(path = "provider/update/{id_provider}")
    public Provider updateProvider(@RequestBody Provider updatedProvider) {
        return providerRepository.save(updatedProvider);
    }

    @PutMapping(path = "user/update/{id_user}")
    public User updateUser(@RequestBody User updatedUser) {
        return userRepository.save(updatedUser);
    }

    //////////////////////        CREATE        //////////////////////

    @PostMapping(path = "/category/create", consumes = "application/json", produces = "application/json")
    public Category createCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    @PostMapping(path = "/customer/create", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @PostMapping(path = "/payment_method/create", consumes = "application/json", produces = "application/json")
    public Payment_method createPaymentMethod(@RequestBody Payment_method newPaymentMethod) {
        return payment_methodRepository.save(newPaymentMethod);
    }

    @PostMapping(path = "/user/create", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
/*
    @PostMapping(path = "/invoice/create", consumes = "application/json", produces = "application/json")
    public Invoice createInvoice(@RequestBody Invoice newInvoice) {
        Invoice newInvoice = new Invoice();
        Sale newSale = new Sale();
        newInvoice.setId_payment_method(newInvoice.getId_payment_method());
        newInvoice.setId_user(newInvoice.getId_user());
        newInvoice.setSales(newSale.setId_product(newSale.getId_product());

        newSale.setQuantity(newSale.getQuantity());
        newSale.setTotal(newSale.getQuantity() * newSale.getId_product);

        newInvoice.setSales(newSale.setTo););
        return invoiceRepository.save(newInvoice);
    }
    */
    @PostMapping(path = "/product/create", consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @PostMapping(path = "/user/newUser", consumes = "application/json", produces = "application/json")
    public String newUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setLast_name(user.getLast_name());
        newUser.setUser(user.getUser());
        newUser.setPassword(user.getPassword());
        if (newUser.getPassword().length() > 6) {
          userRepository.save(newUser);
          return "Se ha creado un nuevo usuario";
        } else {
            return "La contraseña debe tener al menos 6 caracteres";
        }
        }
    }
