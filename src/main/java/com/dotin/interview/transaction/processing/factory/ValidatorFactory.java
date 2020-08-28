package com.dotin.interview.transaction.processing.factory;

import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.response.CartToCartTransactionResponse;
import com.dotin.interview.transaction.processing.validator.CarToCartTransactionValidatorImpl;
import com.dotin.interview.transaction.processing.validator.RequestValidator;

import javax.persistence.EntityManager;

public class ValidatorFactory {

    public RequestValidator get(Class className){
     if(className == CarToCartTransactionValidatorImpl.class)
        return new CarToCartTransactionValidatorImpl();
    }
}
