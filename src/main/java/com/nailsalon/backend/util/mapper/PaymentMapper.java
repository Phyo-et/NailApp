package com.nailsalon.backend.util.mapper;


import com.nailsalon.backend.domain.Appointment;
import com.nailsalon.backend.domain.Payment;
import com.nailsalon.backend.dto.PaymentDTO;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring",
        uses = {AppointmentMapper.class})
public interface PaymentMapper {

    @Mapping(target = "appointmentId",source = "appointment")
    PaymentDTO toDTO(Payment payment);

    @Mapping(target = "appointment" ,source = "appointmentId")
    Payment toEntity(PaymentDTO dto);

    default Appointment mapAppointment(int id){
        Appointment appointment = new Appointment();
        appointment.setId(id);
        if(appointment.getDelflag()==1){
            throw new ResourceNotFoundException("Appointment not found");
        }
        return appointment;
    }

    default int mapAppointment(Appointment appointment){
        return appointment != null ? appointment.getId() :0;
    }

}
