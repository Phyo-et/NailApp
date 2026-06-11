DROP TABLE IF EXISTS `staffs`;

CREATE TABLE `staffs` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'name',
  `phone` VARCHAR(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci UNIQUE COMMENT 'phone',
  `role` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci UNIQUE COMMENT 'role'
  `experience_years`INT DEFAULT NULL COMMENT 'experience_year',
  `created_at` DATETIME DEFAULT NULL,
  `updated_at` DATETIME DEFAULT NULL,
  `del_flg` TINYINT(1) NOT NULL COMMENT 'del_flg',
  PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='staffs';