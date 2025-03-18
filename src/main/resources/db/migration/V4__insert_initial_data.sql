LOAD DATA INFILE '/var/lib/mysql-files//orders_bulk.csv'
    INTO TABLE Orders
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (order_id, created_at, updated_at, order_code, total_price, discount_price, is_cancelled, delivery_id, guest_id, user_id, order_status, @payment_method)
    SET payment_method = TRIM(BOTH '\r' FROM @payment_method);

LOAD DATA INFILE '/var/lib/mysql-files/OrderItemDetail_bulk.csv'
    INTO TABLE OrderItemDetail
    FIELDS TERMINATED BY ',' ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (orderitemdetail_id, name, quantity, price, created_at, updated_at,
     discount_price, coupon_applied, additional_price, additional,
     order_id, product_id, option_id, @item_status)
    SET item_status = TRIM(BOTH '\r' FROM @item_status);


LOAD DATA INFILE '/var/lib/mysql-files/OrderItemDetail_History_bulk.csv'
    INTO TABLE OrderItemDetail_History
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (history_id, orderitemdetail_id, old_price, new_price, old_quantity, new_quantity,
     change_reason, changed_at, changed_by, @item_history_status)
    SET item_history_status = TRIM(BOTH '\r' FROM @item_history_status);



LOAD DATA INFILE '/var/lib/mysql-files/OrderStatus_bulk.csv'
    INTO TABLE OrderStatus
    FIELDS TERMINATED BY ',' ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (orderstatus_id, order_id, payment_status, updated_at, @orderstatus_status)
    SET orderstatus_status = TRIM(BOTH '\r' FROM @orderstatus_status);
