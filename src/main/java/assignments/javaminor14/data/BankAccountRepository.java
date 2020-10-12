package assignments.javaminor14.data;

import assignments.javaminor14.models.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    @Override
    <S extends BankAccount> S save(S entity);

    @Override
    BankAccount findOne(Long primaryKey);

    @Override
    Iterable<BankAccount> findAll();

    @Override
    Long count();

    @Override
    void delete(BankAccount entity);

    @Override
    boolean exists(Long primaryKey);
}
