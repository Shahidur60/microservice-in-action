CREATE TABLE PERSON (
                        person_Id BIGINT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(128) NOT NULL,
                        major VARCHAR(128),
                        department VARCHAR(128) NOT NULL,
                        DOB VARCHAR(128) NOT NULL,
                        phone VARCHAR(128),
                        email VARCHAR(128),
                         PRIMARY KEY (person_Id)
);
CREATE TABLE ORGANIZATION (
                        org_Id  BIGINT  NOT NULL AUTO_INCREMENT,
                        name VARCHAR(128) NOT NULL,
                        category VARCHAR(128),
                        establishment_Date VARCHAR(128),
                        PRIMARY KEY (org_Id)
);
CREATE TABLE MEMBERS (
                              person_Id BIGINT NOT NULL,
                              org_Id  BIGINT  NOT NULL,
                              PRIMARY KEY (person_Id,org_Id),
                              CONSTRAINT `fk_person` FOREIGN KEY (person_Id) REFERENCES PERSON (person_Id),
                              CONSTRAINT `fk_org` FOREIGN KEY (org_Id) REFERENCES ORGANIZATION (org_Id)
)
