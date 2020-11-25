### 用户表
```
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) NOT NULL COMMENT '用户uuid',
  `phone` varchar(64) DEFAULT NULL COMMENT '用户手机号',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `password` varchar(255) DEFAULT NULL,
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '0未删除 1删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_phone` (`phone`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';
```

### 商品表
```
CREATE TABLE `t_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品标题',
  `description` text COMMENT '商品描述',
  `category_id` int(11) NOT NULL COMMENT '关联三级分类id',
  `cost_price` decimal(9, 2) NOT NULL COMMENT '成本价',
  `market_price` decimal(9, 2) NOT NULL COMMENT '市场价格',
  `sale` int(11) NOT NULL DEFAULT '0' COMMENT '销售量',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存量', 
  `img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '主图Url',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '商品状态,0-商品入库,1-上架,2-下架',
  `keywords` varchar(255) DEFAULT '' COMMENT '商品关键字',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '0未删除 1删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';
```

### 分类表
```
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
  `category_level` tinyint(4) NOT NULL COMMENT '分类级别, 1,2,3代表一、二、三级类目',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父类型id',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '0未删除 1删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_category_level_parent_id` (`category_level`, `parent_id`),
  KEY `idx_created_at` (`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品分类表';
```


### 订单表
```
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `amount_total` decimal(20,2) DEFAULT NULL COMMENT '商品总价',
  `discounted` decimal(20,2) DEFAULT NULL COMMENT '优惠价格',
  `logistics_fee` decimal(20,2) DEFAULT NULL COMMENT '总运费',
  `real_amount` decimal(20,2) DEFAULT NULL COMMENT '最终价格',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0-新建订单(待支付)  1-支付成功(商家处理中) 2-支付失败(待支付) 3-商家拒绝 4-订单已取消（用户自行取消）5-订单超时未支付取消 6-待收货  7-退款中（全额退款）8-退款完成 9-订单关闭 10-订单完成',
  `submit_time` timestamp NULL DEFAULT NULL COMMENT '提交订单时间',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付完成时间',
  `confirm_time` timestamp NULL DEFAULT NULL COMMENT '确认收货时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '用户备注',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '0未删除 1删除',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_order_no` (`order_no`),
  KEY `idx_uuid` (`uuid`),
  KEY `idx_created_at` (`created_at`),
  KEY `idx_delete` (`deleted`),
  KEY `idx_uuid_status` (`uuid`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';
```