CREATE TABLE credit_card (
    credit_card_id VARCHAR(50) PRIMARY KEY ,
    user_id VARCHAR(50) NOT NULL,
    nomor_kartu VARCHAR(50) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    experience_date DATE NOT NULL,
    nama_pengguna VARCHAR(255) NOT NULL
);