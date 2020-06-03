package com.site.ClinicAppointments.restController;

import com.site.ClinicAppointments.domain.Appointment;
import com.site.ClinicAppointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/appointments")
public class EndPointControllerImp implements EndPointController {

    @Autowired
    private AppointmentService service;

    @Override
    @PostMapping
    public Appointment add(@RequestBody Appointment appointment) {
        return service.add(appointment);
    }

    @Override
    @GetMapping("/{id}")
    public Appointment findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping
    public List<Appointment> findAll() {
        return service.findAll();
    }

    @Override
    @PutMapping("/{id}")
    public Appointment update(@RequestBody Appointment updatedAppointment, @PathVariable long id) {
        return service.update(updatedAppointment,id);
    }

    @Override
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }
}
