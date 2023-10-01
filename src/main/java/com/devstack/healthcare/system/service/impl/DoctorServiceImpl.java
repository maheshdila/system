package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.Entity.Doctor;
import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.repo.DoctorRepo;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //this is a must
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {
        UUID uuid = UUID.randomUUID();
        long docId = uuid.getMostSignificantBits();

        Doctor doctor = new Doctor(
                docId, dto.getName(), dto.getAddress(), dto.getContact(), dto.getSalary()
        );
        doctorRepo.save(doctor);
    }

    @Override
    public void deleteDoctor(long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        System.out.println(doctor.toString());
        //doctor.
        doctorRepo.delete(doctor.get());



    }

    @Override
    public ResponseDoctorDto getDoctor(long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        if(doctor.isPresent()) {
            ResponseDoctorDto responseDoctorDto = new ResponseDoctorDto();
            responseDoctorDto.setId(id);
            responseDoctorDto.setName(doctor.get().getName());
            responseDoctorDto.setAddress(doctor.get().getAddress());
            responseDoctorDto.setContact(doctor.get().getContact());
            responseDoctorDto.setSalary(doctor.get().getSalary());

            return responseDoctorDto;
        }
        else return null;
    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto dto) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        if (doctor.isPresent()){
            /*doctor.get().setName(dto.getName());*/

            Doctor doctor1 = doctor.get();
            doctor1.setName(dto.getName());
            doctor1.setAddress(dto.getAddress());
            doctor1.setContact(dto.getContact());
            doctor1.setSalary(dto.getSalary());
            doctorRepo.save(doctor1);

        }


    }

    @Override
    public List<ResponseDoctorDto> getAllDoctor(String searchText, int page, int size) {
        return null;
    }
}
