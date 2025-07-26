package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entidades.Category;
import com.example.demo.entidades.Client;
import com.example.demo.entidades.OrderItem;
import com.example.demo.entidades.Orders;
import com.example.demo.entidades.Payment;
import com.example.demo.entidades.Product;
import com.example.demo.enums.OrderStatus;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.OrderItemRepositoy;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ProductRepository;

@Configuration
@Profile("test")
public class Test_config implements CommandLineRunner {

    // Injeção dos repositorios JPA.
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired 
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderItemRepositoy orderItemRepositoy;

    @Override
    public void run(String... args) throws Exception {
        // Categorys
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Smartphones");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        // Products.
        Product prod1 = new Product(0, "Playstation 5", "Sony Video-Game", 100.00, null);
        Product prod2 = new Product(0, "Headset Gamer HyperX Cloud Stinger", "Drivers 50mm, P3, black", 184.99, null);
        productRepository.saveAll(Arrays.asList(prod1,prod2));

        prod1.getCategory().add(cat1);
        prod2.getCategory().add(cat1);

        productRepository.saveAll(Arrays.asList(prod1,prod2));

        // Clients.
        Client cli1 = new Client(null, "João Carlos", "joao@gmail.com", "1145786-4444", "12345");
        Client cli2 = new Client(null, "Larissa", "larissa@gmail.com", "1178945-1234", "54321");
        clientRepository.saveAll(Arrays.asList(cli1,cli2));

        // Orders.
        Orders ord1 = new Orders(null, Instant.parse("2025-07-18T16:08:40Z"), OrderStatus.WAITING_PAYMENT,cli1);
        Orders ord2 = new Orders(null, Instant.parse("2025-07-18T15:58:45Z"), OrderStatus.PAID,cli2);
        ordersRepository.saveAll(Arrays.asList(ord1,ord2));


        // OrderItem.
        OrderItem oi1 = new OrderItem(ord1, prod1, 1, prod1.getPrice());
        OrderItem oi2 = new OrderItem(ord2, prod2, 2, prod2.getPrice());
        orderItemRepositoy.saveAll(Arrays.asList(oi1,oi2));

        Payment pay1 = new Payment(null, Instant.parse("2025-07-18T16:08:40Z"), ord1);
        ord1.setPayment(pay1);
        ordersRepository.save(ord1);
        
    }
}
