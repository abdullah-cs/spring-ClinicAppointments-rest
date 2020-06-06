package com.site.ClinicAppointments.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" , message = "Name must be between 3 to 30 characters")
    private String fullName;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(?i)(male|female)$" , message = "Gender can be male or female")
    private String gender;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^(05|5|96605|9665)[0-9]{8}$" , message = "phone Number must be in a saudi number format")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "The string has to be a well-formed email address")
    private String email;

    @NotNull(message = "Date is mandatory")
    @Future(message = "Date must be in the future")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date appointmentDate;

    @NotBlank(message = "Address is mandatory")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,50}$" , message = "Address must be between 3 to 50 characters")
    private String address;

    @NotBlank(message = "Doctor is mandatory")
    private String doctor;


    public Appointment() {
    }

    public Appointment(String fullName, String gender, String phoneNumber, String email, Date appointmentDate, String address, String doctor) {
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.appointmentDate = appointmentDate;
        this.address = address;
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date date) {
        this.appointmentDate = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", date=" + appointmentDate +
                ", address='" + address + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
