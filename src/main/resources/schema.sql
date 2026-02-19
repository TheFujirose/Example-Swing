CREATE TABLE student (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100),
                         email VARCHAR(100),
                         course VARCHAR(100),
                        level VARCHAR(100) default 'college'
);
CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(100),
                        instructor VARCHAR(100)
);