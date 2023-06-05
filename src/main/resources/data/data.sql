insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('A', 'A브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('B', 'B브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('C', 'C브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('D', 'D브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('E', 'E브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('F', 'F브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('G', 'G브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('H', 'H브랜드', 0, now(), now());

insert into brand(brand_cd, brand_name, total_price, create_date, update_date)
values('I', 'I브랜드', 0, now(), now());



insert into category(category_cd, category_name, priority, create_date, update_date)
values('TOP', '상의', 1, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('OUTER', '아우터', 2, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('PANTS', '바지', 3, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('SNEAKERS', '스니커즈', 4, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('BAG', '가방', 5, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('HAT', '모자', 6, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('SOCKS', '양말', 7, now(), now());

insert into category(category_cd, category_name, priority, create_date, update_date)
values('ACCESSORIES', '액세서리', 8, now(), now());


-- A브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'A브랜드 상의',  11200, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'A브랜드 아우터',  5500, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'A브랜드 바지',  4200, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'A브랜드 스니커즈',  9000, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'A브랜드 가방',  2000, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'A브랜드 모자',  1700, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'A브랜드 양말',  1800, 10, 'SALE', 'A', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'A브랜드 액세서리',  2300, 10, 'SALE', 'A', 100, now(), 100, now(), 100);


-- B브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'B브랜드 상의',  10500, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'B브랜드 아우터',  5900, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'B브랜드 바지',  3800, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'B브랜드 스니커즈', 9100, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'B브랜드 가방',  2100, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'B브랜드 모자',  2000, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'B브랜드 양말',  2000, 10, 'SALE', 'B', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'B브랜드 액세서리',  2200, 10, 'SALE', 'B', 100, now(), 100, now(), 100);


-- C브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values( 'TOP', 'C브랜드 상의',  10000, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'C브랜드 아우터',  6200, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'C브랜드 바지',  3300, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product( category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'C브랜드 스니커즈', 9200, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'C브랜드 가방',  2200, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'C브랜드 모자',  1900, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'C브랜드 양말',  2200, 10, 'SALE', 'C', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'C브랜드 액세서리',  2100, 10, 'SALE', 'C', 100, now(), 100, now(), 100);


-- D브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'D브랜드 상의',  10100, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'D브랜드 아우터',  5100, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'D브랜드 바지',  3000, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'D브랜드 스니커즈', 9500, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product( category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'D브랜드 가방',  2500, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'D브랜드 모자',  1500, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'D브랜드 양말',  2400, 10, 'SALE', 'D', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'D브랜드 액세서리',  2000, 10, 'SALE', 'D', 100, now(), 100, now(), 100);



-- E브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'E브랜드 상의',  10700, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'E브랜드 아우터',  5000, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'E브랜드 바지',  3800, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'E브랜드 스니커즈', 9900, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'E브랜드 가방',  2300, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product( category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'E브랜드 모자',  1800, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'E브랜드 양말',  2100, 10, 'SALE', 'E', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'E브랜드 액세서리',  2100, 10, 'SALE', 'E', 100, now(), 100, now(), 100);


-- F브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'F브랜드 상의',  11200, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'F브랜드 아우터',  7200, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'F브랜드 바지',  4000, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'F브랜드 스니커즈', 9300, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'F브랜드 가방',  2100, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'F브랜드 모자',  1600, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'F브랜드 양말',  2300, 10, 'SALE', 'F', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'F브랜드 액세서리',  1900, 10, 'SALE', 'F', 100, now(), 100, now(), 100);


-- G브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'G브랜드 상의',  10500, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'G브랜드 아우터',  5800, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'G브랜드 바지',  3900, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'G브랜드 스니커즈', 9000, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'G브랜드 가방',  2200, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'G브랜드 모자',  1700, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'G브랜드 양말',  2100, 10, 'SALE', 'G', 1, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'G브랜드 액세서리',  2000, 10, 'SALE', 'G', 1, now(), 100, now(), 100);


-- H브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'H브랜드 상의',  10800, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'H브랜드 아우터',  6300, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'H브랜드 바지',  3100, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'H브랜드 스니커즈', 9700, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'H브랜드 가방',  2100, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'H브랜드 모자',  1600, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'H브랜드 양말',  2000, 10, 'SALE', 'H', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'H브랜드 액세서리',  2000, 10, 'SALE', 'H', 100, now(), 100, now(), 100);


-- I브랜드
insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('TOP', 'I브랜드 상의',  11400, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('OUTER', 'I브랜드 아우터',  6700, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('PANTS', 'I브랜드 바지',  3200, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SNEAKERS', 'I브랜드 스니커즈', 9500, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('BAG', 'I브랜드 가방',  2400, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('HAT', 'I브랜드 모자',  1700, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('SOCKS', 'I브랜드 양말',  1700, 10, 'SALE', 'I', 100, now(), 100, now(), 100);

insert into product(category_cd, name, price, count, sale_status, brand_cd, priority,
                    create_date, create_user_no, update_date, update_user_no)
values('ACCESSORIES', 'I브랜드 액세서리',  2400, 10, 'SALE', 'I', 100, now(), 100, now(), 100);