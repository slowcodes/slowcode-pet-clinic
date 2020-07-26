package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import ng.com.bitsystems.slowcodepetclinic.repositories.OwnerRepository;
import ng.com.bitsystems.slowcodepetclinic.repositories.PetRepository;
import ng.com.bitsystems.slowcodepetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner onwer;

    @BeforeEach
    void setUp() {
        //ownerSDJpaService = new OwnerSDJpaService(ownerRepository,petRepository,visitRepository);
        onwer = Owner.builder().id(7l).lastName("smith").build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(onwer);
        Owner smith = ownerSDJpaService.findByLastName("smith");
        assertEquals("smith", smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(2l).build());
        owners.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> allOwners = ownerSDJpaService.findAll();

        assertNotNull(allOwners);
        assertEquals(2, allOwners.size());

    }


    @Test
    void findByID() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(onwer));
        Owner newOwner = ownerSDJpaService.findByID(7l);
        assertNotNull(newOwner);
    }

    @Test
    void findByIDNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner newOwner = ownerSDJpaService.findByID(7l);
        assertNull(newOwner);
    }

    @Test
    void add() {
        Owner newOwner = Owner.builder().id(5l).build();
        when(ownerRepository.save(any())).thenReturn(newOwner);
        Owner anothorOwner = ownerSDJpaService.add(newOwner);
        assertNotNull(anothorOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(onwer);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(7l);
        //verify(ownerRepository).deleteById(anyLong());
    }
}