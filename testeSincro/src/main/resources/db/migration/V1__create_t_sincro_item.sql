DROP TABLE IF EXISTS t_sincro_item CASCADE;
DROP SEQUENCE IF EXISTS seq_sincro_item;

CREATE SEQUENCE IF NOT EXISTS SEQ_SINCRO_ITEM
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS T_SINCRO_ITEM(
    id BIGINT NOT NULL DEFAULT nextval('SEQ_SINCRO_ITEM'),
    ds_name VARCHAR(255) NOT NULL,
    ds_sku VARCHAR(255),
    ds_description TEXT,

    ds_category VARCHAR(255),
    ds_location VARCHAR(255),

    dt_date DATE,

    ds_depreciationMethod VARCHAR(255),

    vl_deprecitionRate NUMERIC(10, 2),
    vl_residualValue NUMERIC(10,2),

    vl_quantity INTEGER NOT NULL,
    vl_minimiumStock INTEGER NOT NULL,
    vl_unitPrice NUMERIC(12,2) NOT NULL,

    CONSTRAINT PK_T_SINCRO_ITEM PRIMARY KEY (id)

);

ALTER SEQUENCE SEQ_SINCRO_ITEM
OWNED BY T_SINCRO_ITEM.id_name;