package com.site.ClinicAppointments.service;

import com.site.ClinicAppointments.domain.Appointment;

import java.util.List;

public interface AppointmentService {

    boolean add(Appointment appointment);

    Appointment findById(long id);

    List<Appointment> findAll();

    boolean update(Appointment updatedAppointment);

    boolean delete(long id);

}
