
DROP TABLE IF EXISTS reviews ;

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    appointment_id INT NOT NULL,
    rating INT,
    comment VARCHAR(255),
	created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
    delflag TINYINT ,

    -- Foreign Keys
    CONSTRAINT fk_review_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id)
        ON DELETE CASCADE,
        
        CONSTRAINT fk_review_appointment
        FOREIGN KEY (appointment_id) REFERENCES appointments(id)
        ON DELETE CASCADE
        
        );