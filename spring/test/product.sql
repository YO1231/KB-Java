DROP DATABASE IF EXISTS test_db;
CREATE DATABASE test_db;

USE test_db;
DROP TABLE IF EXISTS product_image;
DROP TABLE IF EXISTS product;
CREATE TABLE product (
     no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,          -- 상품 번호
     category ENUM('의류', '가전', 'IT 기기', '가구'),      -- 상품 카테고리
     title VARCHAR(128) NOT NULL,                         -- 상품 명
     description VARCHAR(1000),                           -- 상품 설명
     price INT,                                           -- 가격
     reg_date		DATETIME DEFAULT CURRENT_TIMESTAMP,   -- 등록일
     update_date	DATETIME DEFAULT CURRENT_TIMESTAMP    -- 수정일
);

INSERT INTO product(no, category, title, description, price)
VALUES(1, '의류', '썬캡', '예시마켓 쉐이든 국내제작 99.9% UV자외선차단 20cm 롱챙 썬캡', 20000);
INSERT INTO product(no, category, title, description, price)
VALUES(2, 'IT 기기', '갤럭시탭 A7', '삼성전자 갤럭시탭 A7 10.4 SM-T500 ( AKG 이어폰+C타입충전기 증정 )', 148000);
INSERT INTO product(no, category, title, description, price)
VALUES(3, '가전', 'UHD 스마트 사이니지 TV', '삼성전자 UHD 스마트 사이니지 TV BED-H UHD 4K LED 에너지효율 1등급', 415000);
INSERT INTO product(no, category, title, description, price)
VALUES(4, '의류', '폴로티셔츠', '남성 폴로 티셔츠 패션 캐주얼 루즈핏 냉감 여름 필수 골프웨어', 20000);
INSERT INTO product(no, category, title, description, price)
VALUES(5, '가전', '43인치 FHD TV', '위드라이프 43인치 FHD TV 대기업정품패널 에너지1등급 고화질티비', 219000);
INSERT INTO product(no, category, title, description, price)
VALUES(6, '가구', '컴퓨터 책상', '편안홈 다기능 철제 책상 오피스데스크 컴퓨터책상 업그레이드 타공보드', 63900);

CREATE TABLE product_image (
       no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,   -- 이미지 번호
       product_no INT NOT NULL,                      -- 상품 번호
       file_name VARCHAR(128),                       -- 원본 파일명
       upload_name VARCHAR(128),                     -- 업로드된 서버에서의 파일명
       size int,                                     -- 파일의 크기
       content_type VARCHAR(50),                     -- 컨텐트 타입(파일 타입)
       reg_date		DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 등록일
       CONSTRAINT FOREIGN KEY (product_no) REFERENCES product(no) -- 외래키 제약조건
           ON DELETE CASCADE
);

INSERT INTO product_image(product_no, file_name, upload_name, size, content_type)
VALUES(1, 'cap1.png','cap1.png', 520285, 'image/png');
INSERT INTO product_image(product_no, file_name, upload_name, size, content_type)
VALUES(1, 'cap2.png','cap1.png', 461812, 'image/png');

INSERT INTO product_image(product_no, file_name, upload_name, size, content_type)
VALUES(4, 'tshirt1.jpg', 'tshirt1.jpg', 127849, 'image/jpeg');
INSERT INTO product_image(product_no, file_name, upload_name,size, content_type)
VALUES(4, 'tshirt2.jpg', 'tshirt2.jpg', 145556, 'image/jpeg');
INSERT INTO product_image(product_no, file_name, upload_name,size, content_type)
VALUES(4, 'tshirt3.jpg', 'tshirt3.jpg', 126834, 'image/jpeg');
INSERT INTO product_image(product_no, file_name, upload_name,size, content_type)
VALUES(4, 'tshirt4.jpg', 'tshirt4.jpg', 108459, 'image/jpeg');


GRANT ALL PRIVILEGES ON test_db.* TO 'scoula'@'%';