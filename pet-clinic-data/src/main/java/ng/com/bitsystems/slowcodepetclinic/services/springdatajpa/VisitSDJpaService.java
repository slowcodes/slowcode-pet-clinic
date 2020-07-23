package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Visit;
import ng.com.bitsystems.slowcodepetclinic.repositories.VisitRepository;
import ng.com.bitsystems.slowcodepetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Profile("springdatajpa")
@Service
public class VisitSDJpaService implements VisitService {
    private VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findByID(Long aLong) {
        Optional<Visit> visit= visitRepository.findById(aLong);
        if(visit.isPresent()){
            return visit.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Visit add(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
