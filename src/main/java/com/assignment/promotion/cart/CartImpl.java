package com.assignment.promotion.cart;

import com.assignment.promotion.product.Product;
import com.assignment.promotion.promotion.Promotion;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class CartImpl implements Cart{
    private final List<Product> products;
    private final List<Promotion> promotions;
    private final int promotionNumber= Integer.parseInt(System.getProperty("promotionNumber"));
    CartImpl(List<Product> productsSet, List<Promotion> promotionSet){
        this.products = productsSet;
        this.promotions = promotionSet;
        if(promotionSet.size()>promotionNumber)
            throw new RuntimeException("Please apply only %S promotion"+promotionNumber);
    }


    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public List<Promotion> getPromotion() {
        return promotions;
    }

    @Override
    public double getCheckoutPrice() {
      double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
      List<String> productNameList = products.stream().map(Product::getName).collect(Collectors.toList());

      List<Promotion> promotionApplicable = promotions.stream().filter(prom -> {
                  if (prom.isActive())
                    return  matchList (productNameList, prom.getProductsName());
                  return false;
              }
        ).collect(Collectors.toList());

      double promotionDiscounted = promotionApplicable.stream().mapToDouble(Promotion::getPromotionPrice).sum();
      return totalAmount-promotionDiscounted;
    }

    boolean matchList(List<String> product, List<String> promotion){
        int count=0;
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(product);

        for(String promotionProduct: promotion){
            for(String productItem: blockingQueue){
                if(promotionProduct.equalsIgnoreCase(productItem)) {
                    count++;
                    blockingQueue.remove(productItem);
                    break;
                }
            }
            if(count == promotion.size())
                return true;
        }

        return false;
    }

}
