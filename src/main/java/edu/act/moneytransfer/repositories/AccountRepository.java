package edu.act.moneytransfer.repositories;

import edu.act.moneytransfer.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> { }
