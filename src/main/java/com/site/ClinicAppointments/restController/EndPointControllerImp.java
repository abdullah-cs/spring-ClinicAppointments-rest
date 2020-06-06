package com.site.ClinicAppointments.restController;

import com.site.ClinicAppointments.domain.Appointment;
import com.site.ClinicAppointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/appointments")
public class EndPointControllerImp implements EndPointController {

    @Autowired
    private AppointmentService service;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment add(@Valid @RequestBody Appointment appointment) {
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
    public Appointment update(@Valid @RequestBody Appointment updatedAppointment, @PathVariable long id) {
        return service.update(updatedAppointment,id);
    }

    @Override
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
