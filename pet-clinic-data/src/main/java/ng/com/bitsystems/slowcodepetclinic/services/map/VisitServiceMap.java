package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Visit;
import ng.com.bitsystems.slowcodepetclinic.services.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit add(Visit visit) {
        if(visit.getPet().getId()==null || visit.getPet().getOwner() == null ||
        visit.getPet()==null || visit.getPet().getOwner().getId() ==null){
            throw new RuntimeException("Pet and owner must be defined");
        }
        else {
            return super.add(visit);
        }

    }

    @Override
    public Visit findByID(Long aLong) {
        return super.findById(aLong);
    }
}
