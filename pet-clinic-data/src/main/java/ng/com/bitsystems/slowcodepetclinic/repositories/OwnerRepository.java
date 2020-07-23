package ng.com.bitsystems.slowcodepetclinic.repositories;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
