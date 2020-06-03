package com.site.ClinicAppointments.service;

import com.site.ClinicAppointments.dao.AppointmentDao;
import com.site.ClinicAppointments.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Appointment update(Appointment updatedAppointment) {
        return dao.update(updatedAppointment);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }
}
