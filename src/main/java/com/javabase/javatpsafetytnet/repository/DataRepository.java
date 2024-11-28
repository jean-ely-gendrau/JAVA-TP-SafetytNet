package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class DataRepository {

    private Data data;

    /**
     * findAllPeron
     *
     * @return List Person
     */
    public List<Person> findAllPeron() {
        return data.getPersons();
    }

    /**
     * @return List FireStation
     */
    public List<FireStation> findAllFireStation() {
        return data.getFirestations();
    }

    /**
     * findAllMedicalRecord
     *
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAllMedicalRecord() {
        return data.getMedicalrecords();
    }

    // Getter
    public Data getData() {
        return data;
    }

    //Setter
    public void setData(Data data) {
        this.data = data;
    }

    // Method

    /**
     * addPersonToList
     *
     * @param person
     */
    public void addPersonToList(Person person) {
        data.getPersons().add(person);
    }

    /**
     * updatePersonToList
     *
     * @param person
     */
    public void updatePersonToList(Person person) {
        try {
            Person personToUpdate = data.getPersons()
                    .stream()
                    .filter(personList -> personList.getFirstName().equals(person.getFirstName())
                            && personList.getLastName().equals(person.getLastName())
                    ).toList().get(0);

            personToUpdate.setAddress(person.getAddress());
            personToUpdate.setCity(person.getCity());
            personToUpdate.setZip(person.getZip());
            personToUpdate.setPhone(person.getPhone());
            personToUpdate.setEmail(person.getEmail());

        } catch (IndexOutOfBoundsException e) {

            throw new IndexOutOfBoundsException("Not user to update person: " + person.getFirstName() + " " + person.getLastName());

        }
    }

    /**
     * deletePersonToList
     *
     * @param lastName
     * @param firstName
     * @return boolean
     */
    public void deletePersonToList(String lastName, String firstName) {
      data.setPersons(
              data.getPersons()
                .stream()
                .dropWhile(personList ->
                        Objects.equals(personList.getLastName(), lastName) && Objects.equals(personList.getFirstName(),
                                firstName)
                ).collect(Collectors.toList())
      );
    }
}
