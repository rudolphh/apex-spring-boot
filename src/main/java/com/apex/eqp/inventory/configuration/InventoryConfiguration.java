package com.apex.eqp.inventory.configuration;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.repositories.InventoryRepository;
import com.apex.eqp.inventory.repositories.RecalledProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InventoryConfiguration {

    @Bean
    public CommandLineRunner inventoryCommandLineRunner(InventoryRepository inventoryRepository){

        return args -> {
            Product prod1 = new Product(0, "white bread", 2.99, 50);
            Product prod2 = new Product(0, "clamato original", 4.99, 30);
            Product prod3 = new Product(0, "chicken thigh", 4.20, 25);
            inventoryRepository.saveAll(List.of(prod1, prod2, prod3));
        };
    }

    @Bean
    public CommandLineRunner recalledCommandLineRunner(RecalledProductRepository recalledProductRepository){

        return args -> {
            RecalledProduct prod1 = new RecalledProduct(0, "white bread");
            recalledProductRepository.saveAll(List.of(prod1));
        };
    }
}
