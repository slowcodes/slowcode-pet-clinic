package ng.com.bitsystems.slowcodepetclinic.services;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String name);
    Owner findById(Long id);
    Set<Owner> findAll();
    Owner add();
}
