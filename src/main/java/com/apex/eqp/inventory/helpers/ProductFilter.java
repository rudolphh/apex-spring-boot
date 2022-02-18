package com.apex.eqp.inventory.helpers;

import com.apex.eqp.inventory.entities.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    private final List<String> recalledProducts;

    public ProductFilter(List<String> recalledProducts) {
        if (recalledProducts == null) recalledProducts = new ArrayList<>();

        this.recalledProducts = recalledProducts;
    }

    public List<Product> removeRecalled(Collection<Product> allProduct) {
        return allProduct.stream().filter(this::filterByName).collect(Collectors.toList());
    }

    private boolean filterByName(Product product) {
        return !(recalledProducts.contains(product.getName()));
    }
}
