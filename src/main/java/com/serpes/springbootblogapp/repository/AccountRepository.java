package com.serpes.springbootblogapp.repository;

import com.serpes.springbootblogapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
