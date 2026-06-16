package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Payment;
import com.nailsalon.backend.dto.PaymentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-15T13:50:20+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDTO toDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setAppointmentId( mapAppointment( payment.getAppointment() ) );
        if ( payment.getPaymentmethod() != null ) {
            paymentDTO.setPaymentmethod( payment.getPaymentmethod().name() );
        }
        if ( payment.getPaymentStatus() != null ) {
            paymentDTO.setPaymentStatus( payment.getPaymentStatus().name() );
        }
        paymentDTO.setPaidAt( payment.getPaidAt() );

        return paymentDTO;
    }

    @Override
    public Payment toEntity(PaymentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setAppointment( mapAppointment( dto.getAppointmentId() ) );
        if ( dto.getPaymentmethod() != null ) {
            payment.setPaymentmethod( Enum.valueOf( Payment.PaymentMethod.class, dto.getPaymentmethod() ) );
        }
        if ( dto.getPaymentStatus() != null ) {
            payment.setPaymentStatus( Enum.valueOf( Payment.PaymentStatus.class, dto.getPaymentStatus() ) );
        }
        payment.setPaidAt( dto.getPaidAt() );

        return payment;
    }
}
