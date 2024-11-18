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

    // All Person
    public List<Person> findAllPeron(){
        return data.getPersons();
    }

    // All FireStation
    public List<FireStation> findAllFireStation(){
        return data.getFirestations();
    }

    // All MedicalRecord
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

}
