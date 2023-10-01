package com.devstack.healthcare.system.api;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")

public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public String createDoctor(@RequestBody RequestDoctorDto doctorDto){
        doctorService.createDoctor(doctorDto);
        return doctorDto.getName();
    }

    @GetMapping("/{id}")
    public String findDoctor(@PathVariable long id){
        if(doctorService.getDoctor(id)!=null){
            return doctorService.getDoctor(id).toString();
        }
        else{
            return "doctor not found";
        }
    }

    @PutMapping(params = "id")
    public String updateDoctor(@RequestParam long id,
                               @RequestBody RequestDoctorDto doctorDto)
    {
        doctorService.updateDoctor(id, doctorDto);
        return doctorDto.toString();
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return id+" deleteDoctor";
    }
    @GetMapping(path="/list", params = {"searchText","page","size"})
    public String findAllDoctor(@RequestParam String searchText,
                                @RequestParam int page,
                                @RequestParam int size){


        return "findAllDoctor";
    }

}
