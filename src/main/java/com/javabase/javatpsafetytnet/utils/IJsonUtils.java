package com.javabase.javatpsafetytnet.utils;

import com.javabase.javatpsafetytnet.model.Data;

import java.io.IOException;

public interface IJsonUtils{

    /**
     * jsonFileToMap
     *
     * @param path
     * @throws IOException
     *
     * @implSpec
     * The default implementation, for this {@code jsonFileToMap}:
     * <pre> {@code
     * ObjectMapper objectMapper = new ObjectMapper();
     * try {
     *  // Set Mapped Data to model with your service to separating preoccupation Logic and Data
     *  service.setData(objectMapper.readValue(new File(path), Data.class)):
     * } catch (IOException e) {
     *     e.printStackTrace();
     * }
     * </pre>
     */
    void jsonFileToMap(String path) throws IOException;

}
