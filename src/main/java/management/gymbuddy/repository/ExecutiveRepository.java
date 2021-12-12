package management.gymbuddy.repository;


import management.gymbuddy.entity.Executive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExecutiveRepository extends CrudRepository<Executive, UUID> {
}
