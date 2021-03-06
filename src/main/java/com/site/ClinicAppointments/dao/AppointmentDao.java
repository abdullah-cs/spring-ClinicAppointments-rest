package com.site.ClinicAppointments.dao;

import com.site.ClinicAppointments.domain.Appointment;

import java.util.List;

public interface AppointmentDao {

    Appointment add(Appointment appointment);

    Appointment findById(long id);

    List<Appointment> findAll();

    Appointment update(Appointment updatedAppointment , long id);

    boolean delete(long id);
}
