ALTER TABLE t_sincro_item
ALTER COLUMN ds_category TYPE VARCHAR(255) USING ds_category::TEXT;

ALTER TABLE t_sincro_item
ALTER COLUMN ds_location TYPE VARCHAR(255) USING ds_location::TEXT;

ALTER TABLE t_sincro_item
ALTER COLUMN ds_depreciationMethod TYPE VARCHAR(255) USING ds_depreciationMethod::TEXT;
