package com.dotin.interview.transaction.processing.builder;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.response.Response;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
public class ResponseBuilder implements Builder {
    Response response;
    public ResponseBuilder() {
        reset();
    }

    @Override
    public void setCardNumber(String cardNumber) {
        response.setCardNumber(cardNumber);
    }

    @Override
    public void setFollowUpCode(String followUpCode) {
        response.setFollowUpCode(followUpCode);
    }

    @Override
    public void setResponseCode(String responseCode) {
        response.setResponseCode(responseCode);
    }

    @Override
    public void setHolding(long holding) {
        response.setHolding(holding);
    }

    @Override
    public void setTransactions(List<Transaction> transactions) {
        response.setTransactions(transactions);
    }

    @Override
    public void setDestinationCardNumber(String destinationCardNumber) {
        response.setDestinationCardNumber(destinationCardNumber);
    }

    @Override
    public void reset() {
        this.response = new Response();
    }

    @Override
    public Response getResult() {
        return response;
    }
}
