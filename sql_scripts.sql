-- 1) Создание таблиц:
-- 1.1) Таблица Tests для хранения информации о тестах
CREATE TABLE Tests (
    test_id SERIAL PRIMARY KEY,
    test_name VARCHAR(100) NOT NULL);

-- 1.2) Таблица Questions для хранения вопросов к тесту
CREATE TABLE Questions (
    question_id SERIAL PRIMARY KEY,
    test_id INTEGER REFERENCES Tests(test_id),
    question_text TEXT NOT NULL);

-- 1.3) Таблица Answers для хранения вариантов ответов на вопросы
CREATE TABLE Answers (
    answer_id SERIAL PRIMARY KEY,
    question_id INTEGER REFERENCES Questions(question_id),
    answer_text TEXT NOT NULL);

-- 1.4) Таблица Correct_Answers для хранения информации о правильных ответах
CREATE TABLE Correct_Answers (
    correct_answer_id SERIAL PRIMARY KEY,
    question_id INTEGER REFERENCES Questions(question_id),
    answer_id INTEGER REFERENCES Answers(answer_id));


-- 2) Заполнение таблиц тестовыми данными
-- 2.1) Добавление тестов
INSERT INTO Tests (test_name) VALUES ('Тест по географии');
INSERT INTO Tests (test_name) VALUES ('Тест по истории');

-- 2.2) Добавление вопросов
--      Тест по географии
INSERT INTO Questions (test_id, question_text) VALUES (1, 'Самая крупная страна в мире по территории?');
INSERT INTO Questions (test_id, question_text) VALUES (1, 'Столица Франции?');
--      Тест по истории
INSERT INTO Questions (test_id, question_text) VALUES (2, 'В каком году произошла Великая Октябрьская социалистическая революция?');
INSERT INTO Questions (test_id, question_text) VALUES (2, 'Кто был последним императором Российской империи?');

-- 2.3) Добавление вариантов ответов
--      Тест по географии. Первый вопрос
INSERT INTO Answers (question_id, answer_text) VALUES (1, 'США');
INSERT INTO Answers (question_id, answer_text) VALUES (1, 'Китай');
INSERT INTO Answers (question_id, answer_text) VALUES (1, 'Россия');
--      Тест по географии. Второй вопрос
INSERT INTO Answers (question_id, answer_text) VALUES (2, 'Москва');
INSERT INTO Answers (question_id, answer_text) VALUES (2, 'Лондон');
INSERT INTO Answers (question_id, answer_text) VALUES (2, 'Париж');
--      Тест по истории. Первый вопрос
INSERT INTO Answers (question_id, answer_text) VALUES (3, '1917');
INSERT INTO Answers (question_id, answer_text) VALUES (3, '1918');
INSERT INTO Answers (question_id, answer_text) VALUES (3, '1920');
--      Тест по истории. Второй вопрос
INSERT INTO Answers (question_id, answer_text) VALUES (4, 'Николай II');
INSERT INTO Answers (question_id, answer_text) VALUES (4, 'Александр III');
INSERT INTO Answers (question_id, answer_text) VALUES (4, 'Петр I');

-- 2.4) Добавление правильного ответа
--      Тест по географии. Первый вопрос
INSERT INTO Correct_Answers (question_id, answer_id) VALUES (1, 3);
--      Тест по географии. Второй вопрос
INSERT INTO Correct_Answers (question_id, answer_id) VALUES (2, 6);
--      Тест по истории. Первый вопрос
INSERT INTO Correct_Answers (question_id, answer_id) VALUES (3, 7);
--      Тест по истории. Второй вопрос
INSERT INTO Correct_Answers (question_id, answer_id) VALUES (4, 10);
