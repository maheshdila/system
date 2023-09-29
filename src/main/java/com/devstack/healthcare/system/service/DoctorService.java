package com.devstack.healthcare.system.service;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;

import java.util.List;

public interface DoctorService {
    public void createDoctor(RequestDoctorDto dto);
    public void deleteDoctor(long id);
    public ResponseDoctorDto getDoctor(long id);
    public void updateDoctor(long id, RequestDoctorDto dto);
    public List<ResponseDoctorDto> getAllDoctor(String searchText, int page, int size);





}