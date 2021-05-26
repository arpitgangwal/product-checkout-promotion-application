package com.assignment.promotion.promotion;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class AbstractPromotion implements Promotion {

   Date date;
    AbstractPromotion(Date date){
        this.date = date;
    }

    public boolean isActive() {
        return true;
    }

}
