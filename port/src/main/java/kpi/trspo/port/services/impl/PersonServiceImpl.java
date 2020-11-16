package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.PersonService;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;
import kpi.trspo.port.services.repository.PersonRepository;
import kpi.trspo.port.services.repository.PersonRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(UUID personId) throws NotFoundException {
        Optional<Person> cargoTypeMaybe = personRepository.findById(personId);
        if(cargoTypeMaybe.isPresent()){
            return cargoTypeMaybe.get();
        }
        else
            throw new NotFoundException("No person with such an Id: " + personId);
    }

    @Override
    public Person create(Person personObject) {
        return personRepository.save(personObject);
    }

    @Override
    public Person update(UUID personId, Person personDetails) throws NotFoundException {
        Person oldPerson = getById(personId);
        oldPerson.setName(personDetails.getName());
        oldPerson.setSurname(personDetails.getSurname());
        oldPerson.setDateOfBirth(personDetails.getDateOfBirth());
        oldPerson.setRole(personDetails.getRole());
        return personRepository.save(oldPerson);
    }

    @Override
    public void delete(UUID personId) throws NotFoundException{
        personRepository.delete(getById(personId));
    }
}
