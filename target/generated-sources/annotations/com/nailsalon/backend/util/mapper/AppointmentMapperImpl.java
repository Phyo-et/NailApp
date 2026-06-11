package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Appointment;
import com.nailsalon.backend.dto.AppointmentDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-08T15:25:45+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDTO toDTO(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setCustomerId( mapCustomer( appointment.getCustomer() ) );
        appointmentDTO.setStaffId( mapStaff( appointment.getStaff() ) );
        if ( appointment.getAppointmentDate() != null ) {
            appointmentDTO.setAppointmentDate( DateTimeFormatter.ISO_LOCAL_DATE.format( appointment.getAppointmentDate() ) );
        }
        if ( appointment.getStartTime() != null ) {
            appointmentDTO.setStartTime( DateTimeFormatter.ISO_LOCAL_TIME.format( appointment.getStartTime() ) );
        }
        if ( appointment.getEndTime() != null ) {
            appointmentDTO.setEndTime( DateTimeFormatter.ISO_LOCAL_TIME.format( appointment.getEndTime() ) );
        }
        if ( appointment.getStatus() != null ) {
            appointmentDTO.setStatus( appointment.getStatus().name() );
        }
        appointmentDTO.setNotes( appointment.getNotes() );

        return appointmentDTO;
    }

    @Override
    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setCustomer( mapCustomer( appointmentDTO.getCustomerId() ) );
        appointment.setStaff( mapStaff( appointmentDTO.getStaffId() ) );
        if ( appointmentDTO.getAppointmentDate() != null ) {
            appointment.setAppointmentDate( LocalDate.parse( appointmentDTO.getAppointmentDate() ) );
        }
        if ( appointmentDTO.getStartTime() != null ) {
            appointment.setStartTime( LocalTime.parse( appointmentDTO.getStartTime() ) );
        }
        if ( appointmentDTO.getEndTime() != null ) {
            appointment.setEndTime( LocalTime.parse( appointmentDTO.getEndTime() ) );
        }
        if ( appointmentDTO.getStatus() != null ) {
            appointment.setStatus( Enum.valueOf( Appointment.Status.class, appointmentDTO.getStatus() ) );
        }
        appointment.setNotes( appointmentDTO.getNotes() );

        return appointment;
    }
}
