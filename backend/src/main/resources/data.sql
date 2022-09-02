INSERT INTO subjects (id, label) VALUES (1, 'Culture and Organization');
INSERT INTO subjects (id, label) VALUES (2, 'Design and Architecture');
INSERT INTO subjects (id, label) VALUES (3, 'Build and Deploy');
INSERT INTO subjects (id, label) VALUES (4, 'Testing and Verification');
INSERT INTO subjects (id, label) VALUES (5, 'Information and Reporting');
INSERT INTO subjects (id, label) VALUES (6, 'Security and Risk');

INSERT INTO questions (id, label, subject_id) VALUES (1, 'What''s your name?', 1);
INSERT INTO questions (id, label, subject_id) VALUES (2, 'How old are you?', 1);
INSERT INTO questions (id, label, subject_id) VALUES (3, 'Do you like this example?', 2);
INSERT INTO questions (id, label, subject_id) VALUES (4, 'Any suggestions?', 2);
INSERT INTO questions (id, label, subject_id) VALUES (5, 'What is your quest?', 3);
INSERT INTO questions (id, label, subject_id) VALUES (6, 'What is your favorite color?', 4);
INSERT INTO questions (id, label, subject_id) VALUES (7, 'What is the airspeed velocity of an unladen sparrow?', 5);
INSERT INTO questions (id, label, subject_id) VALUES (8, 'Do you mean, an African or European swallow?', 6);

INSERT INTO users (id, name) VALUES (1, 'demo');

INSERT INTO user_responses (content, question_id, user_id) VALUES ('Joe', 1, 1);
INSERT INTO user_responses (content, question_id, user_id) VALUES ('25', 2, 1);
