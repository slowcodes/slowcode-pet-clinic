package ng.com.bitsystems.slowcodepetclinic.repositories;

import ng.com.bitsystems.slowcodepetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
