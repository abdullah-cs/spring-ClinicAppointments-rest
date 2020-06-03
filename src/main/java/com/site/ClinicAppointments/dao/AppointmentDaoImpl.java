package com.site.ClinicAppointments.dao;

import com.site.ClinicAppointments.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentDaoImpl implements AppointmentDao{


    @Autowired
    private AppointmentRepository repository;

    @Override
    public boolean add(Appointment appointment) {
        if (!repository.existsById(appointment.getId())) {
            repository.save(appointment);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Appointment findById(long id) {
        Optional<Appointment> result = repository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Appointment> findAll() {
        Iterable<Appointment> result = repository.findAll();
        List<Appointment> appointments = new ArrayList<>();
        for (Appointment appointment : result) {
            appointments.add(appointment);
        }

        return appointments;
    }

    @Override
    public boolean update(Appointment updatedAppointment) {

        if (repository.existsById(updatedAppointment.getId())) {
            repository.save(updatedAppointment);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
