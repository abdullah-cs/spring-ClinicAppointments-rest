package com.site.ClinicAppointments.service;

import com.site.ClinicAppointments.domain.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment add(Appointment appointment);

    Appointment findById(long id);

    List<Appointment> findAll();

    Appointment update(Appointment updatedAppointment);

    boolean delete(long id);

}
