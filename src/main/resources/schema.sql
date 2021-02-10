DROP TABLE IF EXISTS winkelgebieden;
DROP TABLE IF EXISTS sectoren;
DROP TABLE IF EXISTS restaurants;

CREATE TABLE winkelgebieden (
    id BIGINT PRIMARY KEY NOT NULL,
    naam VARCHAR(100),
    subcentrum VARCHAR(100)
);

CREATE TABLE sectoren (
    id BIGINT PRIMARY KEY NOT NULL,
    code VARCHAR(25),
    naam VARCHAR(50)
);

CREATE TABLE restaurants (
    id BIGINT PRIMARY KEY NOT NULL,
    naam VARCHAR(50),
    creatie_datum DATE,
    check_datum DATE,
    keten BOOLEAN,
    keten_naam VARCHAR(50),

    straat VARCHAR(100),
    huis_nummer VARCHAR(10),
    postcode VARCHAR(10),
    gemeente VARCHAR(50),
    deelgemeente VARCHAR(50),

    breedtegraad VARCHAR(25),
    lengtegraad VARCHAR(25),

    sector_id BIGINT,
    winkelgebied_id BIGINT,

    FOREIGN KEY (sector_id) REFERENCES sectoren(id),
    FOREIGN KEY (winkelgebied_id) REFERENCES winkelgebieden(id)
);