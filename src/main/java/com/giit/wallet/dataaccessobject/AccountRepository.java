package com.giit.wallet.dataaccessobject;

import com.giit.wallet.dataobject.Account;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
	Optional<Account> getByUserName(String name);
}
