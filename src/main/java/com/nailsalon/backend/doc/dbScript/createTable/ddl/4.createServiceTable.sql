-- Table structure for table `services`
DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'name',
  `description` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'description',
  `price` DOUBLE NOT NULL COMMENT 'price',
  `duration_minute` INT NOT NULL COMMENT 'duration_minute',
  `created_at` DATETIME DEFAULT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  `del_flg` TINYINT(1) NOT NULL COMMENT 'del_flg',
  PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='services';