package com.dotin.interview.transaction.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotin.interview.transaction.processing.model.User;

public interface UserRepsoitory extends JpaRepository<User, Long> {

}
