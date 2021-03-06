package com.site.ClinicAppointments.service;

import com.site.ClinicAppointments.dao.AppointmentDao;
import com.site.ClinicAppointments.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao dao;

    @Override
    public Appointment add(Appointment appointment) {
        return dao.add(appointment);
    }

    @Override
    public Appointment findById(long id) {
        return dao.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return dao.findAll();
    }

    @Override
    public Appointment update(Appointment updatedAppointment, long id) {
        return dao.update(updatedAppointment, id);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }
}
