
CREATE TABLE `front_end_category_mapping` (
`category_id` bigint(20) NOT NULL,
`front_category_id` bigint(20) NOT NULL,
PRIMARY KEY (`category_id`, `front_category_id`)
);

CREATE TABLE `commodity_category` (
`category_id` bigint(20) NOT NULL,
`category_name` varchar(128) NULL,
`category_description` varchar(255) NULL,
`is_leaf` tinyint(1) UNSIGNED NULL,
`parent_id` int(11) NULL,
`is_deleted` tinyint(1) UNSIGNED NULL,
`gmd_created` datetime(6) NULL,
`gmt_modified` datetime(6) NULL,
PRIMARY KEY (`category_id`)
);

CREATE TABLE `front_category` (
`front_category_id` bigint(20) NOT NULL,
`front_category_name` varchar(128) NULL,
`front_category_description` varchar(255) NULL,
`front_is_leaf` tinyint(1) UNSIGNED NULL,
`front_parent_id` int(11) NULL,
`front_is_deleted` tinyint(1) UNSIGNED NULL,
`gmd_created` datetime(6) NULL,
`gmt_modified` datetime(6) NULL,
PRIMARY KEY (`front_category_id`)
);

ALTER TABLE `front_end_category_mapping` ADD CONSTRAINT fk_back_category_id FOREIGN KEY (`category_id`) REFERENCES `commodity_category` (`category_id`);
ALTER TABLE `front_end_category_mapping` ADD CONSTRAINT fk_front_category_id FOREIGN KEY (`front_category_id`) REFERENCES `front_category` (`front_category_id`);
