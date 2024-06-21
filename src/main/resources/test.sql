DROP TABLE IF EXISTS Record;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Art;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS Exam;


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
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (5, '承德避暑山庄，又称（），历经（）三代，是夏天避暑和处理政务的地方', 'A.“热河行宫”;康熙、雍正、乾隆', 'B.“盛京夏宫”;康熙、乾隆、同治', 'C.“承德行宫”;雍正、乾隆、同治', 1);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (6, '著名的卢沟桥始建于（）', 'A.隋朝', 'B.元朝', 'C.金朝', 3);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (7, '在长城上白天遇敌情举烟，称为（）', 'A.烽', 'B.燧', 'C.炬', 2);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (8, '我国最早的一部医书是（）', 'A.《伤寒论》', 'B.《黄帝内经》', 'C.《本草纲目》', 2);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (9, '玄奘墓塔位于（）省', 'A.四川省', 'B.山东省', 'C.陕西省', 3);
INSERT INTO Question (questionID, text, option1, option2, option3, answer) VALUES (10, '世界上最早、最大的百科全书是中国的（）', 'A.《四库全书》', 'B.《古今图书集成》', 'C.《永乐大典》', 3);


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



