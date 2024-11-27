package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataRepository {

    private Data data;

    /**
     * findAllPeron
     *
     * @return List Person
     */
    public List<Person> findAllPeron(){
        return data.getPersons();
    }

    /**
     *
     * @return List FireStation
     */
    public List<FireStation> findAllFireStation(){
        return data.getFirestations();
    }

    /**
     * findAllMedicalRecord
     *
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAllMedicalRecord(){
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
    public void addPersonToList(Person person){
        data.getPersons().add(person);
    }

}
