package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.Data;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    private Data data;

    // Getter
    public Data getData() {
        return data;
    }

    //Setter
    public void setData(Data data) {
        this.data = data;
    }

}
