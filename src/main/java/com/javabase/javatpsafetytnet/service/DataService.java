package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.Data;
import org.springframework.stereotype.Service;

@Service
public class DataService {

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
