package management.gymbuddy.repository;

import management.gymbuddy.entity.Customer;
import management.gymbuddy.entity.Executive;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    Optional<Customer> findById(UUID Id);
}
