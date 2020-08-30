package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

public interface RequestValidationStrategy {

    void validateTransaction(DefaultRequest request);

}
