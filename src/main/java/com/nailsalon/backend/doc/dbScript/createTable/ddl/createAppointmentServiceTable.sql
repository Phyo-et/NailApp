

DROP TABLE IF EXISTS appointment_services ;

CREATE TABLE appointment_services (
    id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL,
    service_id INT,
    price DOUBLE,
	created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
    delflag TINYINT ,

    -- Foreign Keys
    CONSTRAINT fk_appointmentService_appointment
        FOREIGN KEY (appointment_id) REFERENCES appointments(id)
        ON DELETE CASCADE,
        
      CONSTRAINT fk_appointment_service_service
        FOREIGN KEY (service_id)
        REFERENCES services(id)
        ON DELETE CASCADE
);