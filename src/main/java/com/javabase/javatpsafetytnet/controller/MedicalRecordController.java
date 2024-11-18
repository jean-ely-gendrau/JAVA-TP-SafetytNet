package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import com.javabase.javatpsafetytnet.service.dto.ChildAlertDTO;
import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalRecordController {

    /**
     *  Declare wired service
     */
    private final MedicalRecordService medicalRecordService;

    private Mapper mapper;
    /**
     * Constructor
     * Wire Service
     *
     * @param medicalRecordService
     */
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    /**
     * childAlert
     * <p>
     *
     * </p>
     * @param address
     * @return
     */
    @GetMapping("/childAlert")
    public List<ChildAlertDTO> childAlert(@RequestParam(name = "address") String address){
        return medicalRecordService.getAllChildrenByAddress(address);
    }
}