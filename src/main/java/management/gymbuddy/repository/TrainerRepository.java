package management.gymbuddy.repository;

import management.gymbuddy.entity.Customer;
import management.gymbuddy.entity.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrainerRepository extends CrudRepository<Trainer, UUID> {

}
