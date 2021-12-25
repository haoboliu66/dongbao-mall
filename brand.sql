CREATE TABLE `brand` (
`brand_id` bigint(11) NOT NULL,
`brand_chinese_name` varchar(255) NULL,
`brand_english_name` varchar(255) NULL,
`brand_alias` varchar(255) NULL,
`logo` varchar(255) NULL,
`brand_introduction` varchar(255) NULL,
`brand_authorization` varchar(255) NULL,
`registration_location` varchar(255) NULL,
`gmt_created` datetime(6) NULL,
`gmt_modified` datetime(6) NULL,
PRIMARY KEY (`brand_id`) 
);
