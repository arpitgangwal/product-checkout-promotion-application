package com.assignment.promotion.cart;

import com.assignment.promotion.product.Product;
import com.assignment.promotion.promotion.Promotion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class CartImpl implements Cart{
    private List<Product> products;
    private Set<Promotion> promotions;
    private int promotionNumber= Integer.parseInt(System.getProperty("promotionNumber"));
    CartImpl(List<Product> productsSet, Set<Promotion> promotionSet){
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
    public Set<Promotion> getPromotion() {
        return promotions;
    }

    @Override
    public double getCheckoutPrice() {
      double totalAmount = products.stream().collect(Collectors.summingDouble(p ->p.getPrice()));
      List<String> productNameList = products.stream().map(p->p.getName()).collect(Collectors.toList());

      List<Promotion> promotionApplicable = promotions.stream().filter(prom -> {
                  if (prom.isActive())
                    return  matchList (productNameList, prom.getProductsName());
                  return false;
              }
        ).collect(Collectors.toList());

      double promotionDiscounted = promotionApplicable.stream().collect(Collectors.summingDouble(p->p.getPromotionPrice()));
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
