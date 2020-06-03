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
    public Appointment add(Appointment appointment) {

        return repository.save(appointment);

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
    public Appointment update(Appointment updatedAppointment , long id) {

        if(repository.existsById(id)){
            Appointment appointment = findById(id);
            appointment.setFullName(updatedAppointment.getFullName());
            appointment.setGender(updatedAppointment.getGender());
            appointment.setPhoneNumber(updatedAppointment.getPhoneNumber());
            appointment.setEmail(updatedAppointment.getEmail());
            appointment.setDate(updatedAppointment.getDate());
            appointment.setAddress(updatedAppointment.getAddress());
            appointment.setDoctor(updatedAppointment.getDoctor());
            return repository.save(appointment);
        }
        else{
            return null;
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
