package assignments.javaminor14.data;

import assignments.javaminor14.models.AccountHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface AccountHolderRepository extends CrudRepository<AccountHolder, Long> {
    @Override
    <S extends AccountHolder> S save(S entity);

    @Override
    AccountHolder findOne(Long primaryKey);

    @Override
    Iterable<AccountHolder> findAll();

    @Override
    Long count();

    @Override
    void delete(AccountHolder entity);

    @Override
    boolean exists(Long primaryKey);
}
