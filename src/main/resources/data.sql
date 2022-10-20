DELETE FROM product_types;
DELETE FROM transaction_concepts;

INSERT INTO product_types VALUES (1,'Savings Account'),(2,'Loan');

INSERT INTO transaction_concepts 
VALUES (1000,'eng','Payment debit'),
(1000,'esp','Debito de Transferencia'),
(1001,'eng','Loan debit'),
(1001,'esp','Débito de Préstamo'),
(5000,'eng','Loan credit'),
(5000,'esp','Crédito de Préstamo'),
(5001,'eng','Payment credit'),
(5001,'esp','Crédito de Transferencia'),
(5002,'eng','Welcome credit'),
(5002,'esp','Crédito de Bienvenida');