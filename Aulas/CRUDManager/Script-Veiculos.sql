CREATE TABLE Vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    yearOfManufacture INT NOT NULL,
    color VARCHAR(255) NOT NULL,
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES companies(id)
);