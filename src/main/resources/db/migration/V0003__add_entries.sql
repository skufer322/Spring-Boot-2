BEGIN TRANSACTION;
INSERT INTO spring_modules (name, props) VALUES ('Spring Spring Spring', '123abc');
UPDATE spring_modules SET props='123' WHERE id=1;
UPDATE spring_modules SET props='234' WHERE id=2;
UPDATE spring_modules SET props='567' WHERE id=5;
UPDATE spring_modules SET props='678' WHERE id=6;
COMMIT TRANSACTION;