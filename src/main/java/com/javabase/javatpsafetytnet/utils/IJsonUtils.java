package com.javabase.javatpsafetytnet.utils;

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
     *  // Set Mapped Data to model with your controller to separating preoccupation Logic and Data
     *  controller.setData(objectMapper.readValue(new File(path), Data.class)):
     * } catch (IOException e) {
     *     e.printStackTrace();
     * }
     * </pre>
     */
    void jsonFileToMap(String path) throws IOException;

}
