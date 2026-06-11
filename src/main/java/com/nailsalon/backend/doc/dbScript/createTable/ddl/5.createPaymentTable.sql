
DROP TABLE IF EXISTS `payments`;

CREATE TABLE `payments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `appointment_id` BIGINT DEFAULT NULL COMMENT 'appointment_id',-- foreign key by appointments
  `amount` DOUBLE NOT NULL COMMENT 'amount',
  `payment_method` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'payment_method',
  `payment_status` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'payment_status',
  `paid_at` DATETIME DEFAULT NULL,
  `created_at` DATETIME DEFAULT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  `del_flg` TINYINT(1) NOT NULL COMMENT 'del_flg',
  CONSTRAINT 'fk_payment_appointment' FOREIGN KEY ('appointment_id') REFERENCES 'appointments'('id'),


  PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='payments';

