DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Art;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS Exam;
DROP TABLE IF EXISTS Record;

CREATE TABLE IF NOT EXISTS User (
                                    userID INT(11) NOT NULL AUTO_INCREMENT,
                                    username VARCHAR(50) NOT NULL,
                                    password VARCHAR(50) NOT NULL,
                                    email VARCHAR(50) NOT NULL,
                                    phone VARCHAR(20) NOT NULL,
                                    image VARCHAR(2000) DEFAULT NULL,
                                    PRIMARY KEY (UserID)
);

INSERT INTO User (userID, username, password, email, phone) VALUES
    (1, 'zhang', '12345678', 'zhang@fudan.edu.cn', '13666666666');


CREATE TABLE IF NOT EXISTS Art (
                                    artID INT(11) NOT NULL AUTO_INCREMENT,
                                    artName VARCHAR(100) NOT NULL,
                                    description VARCHAR(5000) NOT NULL,
                                    PRIMARY KEY (artID)
);

INSERT INTO Art (artID, artName, description) VALUES (1, '铜马', '铜马体态矫健，四肢修长，肌肉线条流畅而富有张力，仿佛随时准备奔驰于辽阔的天地之间。马首微昂，双眼炯炯有神，透露出一种不可一世的威严与力量。马鬃与马尾飘逸，更增添了几分灵动与飘逸。

作为出土文物，这匹铜马见证了东周时期的文化繁荣与技艺高峰。这匹铜马不仅展现了古代工匠精湛的铸造技艺，更是天马神韵的生动再现。');

INSERT INTO Art (artID, artName, description) VALUES (2, '觥', '觥是古代盛酒器，一般作椭圆或长方形体，或仿动物形体。这种铜器有兽头形盖，器型似，前部有宽口流，后部常有鋬，器底置圈足、三足或多足，以圈足为多见');


CREATE TABLE IF NOT EXISTS Question (
                                    questionID INT(11) NOT NULL AUTO_INCREMENT,
                                    text VARCHAR(100) NOT NULL,     /*题目内容*/
                                    option1 VARCHAR(100) NOT NULL,   /*代表选项1内容*/
                                    option2 VARCHAR(100) NOT NULL,   /*代表选项2内容*/
                                    option3 VARCHAR(100) NOT NULL,   /*代表选项3内容*/
                                    answer INT(10) NOT NULL,  /*代表答案*/
                                    CHECK (answer IN (1, 2, 3)),   /*约束*/
                                    PRIMARY KEY (questionID)
);
/* 题目参考链接：https://www.ihzw.com.cn/JiaoYuXinWen/35589_2.html*/
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (1, '万年的稻作文化系统位于（）省。', 'A.江西', 'B.云南', 'C.浙江', 1);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (2, '高句丽古墓群属于哪个国家的世界文化遗产', 'A.韩国', 'B.朝鲜', 'C.中国', 2);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (3, '耳杯这种形制的玛瑙器出现于什么时代', 'A.汉代', 'B.三国', 'C.魏晋', 1);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (4, '号称“青铜之冠”，体现中国古代铜器制造最高制造水平的是', 'A.铜车马', 'B.青铜剑', 'C.寺工铜矛', 1);

CREATE TABLE IF NOT EXISTS Exam (
                                    examID INT(11) NOT NULL AUTO_INCREMENT,
                                    questions VARCHAR(100) NOT NULL,     /*代表题目id集合，以"-"间隔*/
                                    options VARCHAR(100) DEFAULT NULL,   /*代表用户所选题目选项*/
                                    answers VARCHAR(100) NOT NULL,   /*代表题目答案*/
                                    score INT(10) DEFAULT 0,  /*代表得分*/
                                    PRIMARY KEY (examID)
);

INSERT INTO Exam (examID, questions, options, answers, score) VALUES (1, '1-2', '1-2', '1-1', 1);

CREATE TABLE IF NOT EXISTS Record (
                                      recordID INT(11) NOT NULL AUTO_INCREMENT,
                                      userID INT(11) NOT NULL,
                                      examID INT(11) NOT NULL,
                                      joinDate DATETIME,
                                      score INT(10) DEFAULT 0,     /*答题得分*/
                                      FOREIGN KEY (examID) REFERENCES Exam(examID),
                                      FOREIGN KEY (userID) REFERENCES User(userID),
                                      PRIMARY KEY (recordID)
);

INSERT INTO Record (recordID, userID, examID, joinDate, score) VALUES (1, 1, 1, '2024-06-16 22:55:10', 1);



