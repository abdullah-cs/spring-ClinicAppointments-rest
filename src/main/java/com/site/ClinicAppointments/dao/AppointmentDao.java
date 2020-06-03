package com.site.ClinicAppointments.dao;

import com.site.ClinicAppointments.domain.Appointment;

import java.util.List;

public interface AppointmentDao {

    boolean add(Appointment appointment);

    Appointment findById(long id);

    List<Appointment> findAll();

    boolean update(Appointment updatedAppointment);

    boolean delete(long id);
}
