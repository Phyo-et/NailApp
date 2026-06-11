DROP TABLE IF EXISTS `appointments`;

CREATE TABLE `appointments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_id` BIGINT DEFAULT NULL COMMENT 'customer_id',-- foreign key by customers
  `staff_id` BIGINT DEFAULT NULL COMMENT 'staff_id',-- foreign key by staffs
  `appointment_date` DATE NOT NULL COMMENT 'appointment_date',
  `start_time` TIME NOT NULL  COMMENT 'start_time',
  `end_time` TIME NOT NULL  COMMENT 'end_time',
  `status` ENUM('BOOKED', 'COMPLETED', 'CANCELLED') DEFAULT 'BOOKED',
  `notes` TEXT,
  `created_at` DATETIME DEFAULT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  `del_flg` TINYINT(1) NOT NULL COMMENT 'del_flg',
  CONSTRAINT 'fk_appointment_customer' FOREIGN KEY ('customer_id') REFERENCES 'customers'('id'),
  CONSTRAINT 'fk_appointment_staff' FOREIGN KEY ('staff_id') REFERENCES 'staffs'('id')

  PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='appointments';
