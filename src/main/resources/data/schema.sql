
DROP TABLE IF EXISTS brand CASCADE;
CREATE TABLE brand
(
    brand_cd                    varchar(30) not null                            comment '브랜드 코드',
    brand_name                  varchar(50) not null                            comment '브랜드 이름',
    total_price                 int not null                                    comment '총 가격',
    create_date                 timestamp not null default current_timestamp    comment '생성 일시',
    update_date                 timestamp not null default current_timestamp    comment '변경 일시',
    PRIMARY KEY (brand_cd)
) COMMENT '브랜드';

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category
(
    category_cd                    varchar(30) not null                            comment '브랜드 코드',
    category_name                  varchar(50) not null                            comment '브랜드 이름',
    priority                    int not null                                    comment '노출 우선순위',
    create_date                 timestamp not null default current_timestamp    comment '생성 일시',
    update_date                 timestamp not null default current_timestamp    comment '변경 일시',
    PRIMARY KEY (category_cd)
) COMMENT '카테고리';

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    product_no                      bigint auto_increment                           comment '상품번호',
    category_cd              varchar(30) not null                            comment '카테고리 타입',
    name                    varchar(100) not null                           comment '이름',
    price                   int not null                                    comment '가격',
    count                   int not null                                    comment '수량',
    sale_status             varchar(30) not null                            comment '판매 상태',
    brand_cd                    varchar(30) not null                            comment '브랜드 코드',
    priority                    int not null                                    comment '노출 우선순위',
    create_date                 timestamp not null default current_timestamp    comment '생성 일시',
    create_user_no              bigint not null                                 comment '생성 유저',
    update_date                 timestamp not null default current_timestamp    comment '변경 일시',
    update_user_no              bigint not null                                 comment '변경 유저',
    PRIMARY KEY (product_no)
) COMMENT '상품';

CREATE INDEX idx_product_01 ON product (brand_cd);

CREATE INDEX idx_product_02 ON product (brand_cd, category_cd);

CREATE INDEX idx_product_03 ON product (category_cd, price, priority);