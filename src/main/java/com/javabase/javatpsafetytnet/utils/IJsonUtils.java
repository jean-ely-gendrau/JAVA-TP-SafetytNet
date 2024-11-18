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
     * Data data = new Data();
     * ObjectMapper objectMapper = new ObjectMapper();
     * try {
     *  data = objectMapper.readValue(new File(path), Data.class)
     *  return data;
     * } catch (IOException e) {
     *     e.printStackTrace();
     * }
     * </pre>
     */
    void jsonFileToMap(String path) throws IOException;

}
