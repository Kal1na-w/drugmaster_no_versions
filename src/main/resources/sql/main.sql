CREATE TABLE drug
(
    id   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE symptom
(
    id   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE symptom_to_drug
(
    symptom_id BIGINT UNSIGNED,
    drug_id    BIGINT UNSIGNED,
    PRIMARY KEY (symptom_id, drug_id)
);

ALTER TABLE symptom_to_drug
    ADD FOREIGN KEY (symptom_id) REFERENCES symptom (id),
    ADD FOREIGN KEY (drug_id) REFERENCES drug (id);

ALTER TABLE drug
    ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

CREATE TABLE user_credentials
(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

ALTER TABLE user_credentials
    ADD CONSTRAINT uniq_username UNIQUE (username);