CREATE DATABASE web;

CREATE SEQUENCE personalinfopksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE publishedpksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE academicpksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE acceptedpksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE bookpksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE complementarypksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE experiencepksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE loginpksequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE TABLE academic (
    generallevel character varying(100) NOT NULL,
    generaltype character varying(50) NOT NULL,
    generalinstitute character varying(30) NOT NULL,
    generalcourse character varying(40) NOT NULL,
    generalstatus character varying(100) NOT NULL,
    periodstartdate character varying(20) NOT NULL,
    periodenddate character varying(20) NOT NULL,
    scholarshippresence character varying(20) NOT NULL,
    scholarshipagency character varying(30) NOT NULL,
    miscinfo character varying(300) NOT NULL,
    id integer DEFAULT nextval('academicpksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

CREATE TABLE accepted (
    generaltitle character varying(40) NOT NULL,
    generallanguage character varying(100) NOT NULL,
    generalyear character varying(4) NOT NULL,
    detailedtitle character varying(40) NOT NULL,
    detailedissn character varying(40) NOT NULL,
    otherinfo character varying(300) NOT NULL,
    id integer DEFAULT nextval('acceptedpksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

CREATE TABLE book (
    booktype character varying(100) NOT NULL,
    bookissn character varying(40) NOT NULL,
    id integer DEFAULT nextval('bookpksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

CREATE TABLE complementary (
    generallevel character varying(100) NOT NULL,
    generalinstitution character varying(40) NOT NULL,
    generalcourse character varying(40) NOT NULL,
    generalstatus character varying(100) NOT NULL,
    generaltime character varying(2) NOT NULL,
    periodbegin character varying(4) NOT NULL,
    periodend character varying(4) NOT NULL,
    scholarshippresence character varying(10) NOT NULL,
    scholarshipagency character varying(40) NOT NULL,
    id integer DEFAULT nextval('complementarypksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

CREATE TABLE experience (
    profinstitution character varying(40) NOT NULL,
    bondtype character varying(40) NOT NULL,
    bondemployment character varying(100) NOT NULL,
    bondfunctional character varying(40) NOT NULL,
    bondtime character varying(2) NOT NULL,
    bondexclusive character varying(100) NOT NULL,
    periodmonth character varying(2) NOT NULL,
    periodfinished character varying(10) NOT NULL,
    periodyear character varying(4) NOT NULL,
    otherinfo character varying(300) NOT NULL,
    id integer DEFAULT nextval('experiencepksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

CREATE TABLE login (
    email character varying(100) NOT NULL,
    password character varying(30) NOT NULL,
    id integer DEFAULT nextval('loginpksequence'::regclass) NOT NULL,
    enabled boolean DEFAULT true NOT NULL
);

CREATE TABLE personalinfo (
    generalname character varying(30) NOT NULL,
    generalcitationname character varying(20) NOT NULL,
    generalcountry character varying(100) NOT NULL,
    generalcpf character varying(20) NOT NULL,
    generalsex character varying(20) NOT NULL,
    idnumber character varying(20) NOT NULL,
    idemissioner character varying(20) NOT NULL,
    idstate character varying(100) NOT NULL,
    idemissiondate character varying(20) NOT NULL,
    birthcountry character varying(100) NOT NULL,
    birthstate character varying(2) NOT NULL,
    birthcity character varying(40) NOT NULL,
    birthdate character varying(20) NOT NULL,
    passportnumber character varying(20) NOT NULL,
    passportvaliditydate character varying(20) NOT NULL,
    passportemissiondate character varying(20) NOT NULL,
    passportcountry character varying(100) NOT NULL,
    filiationfathername character varying(30) NOT NULL,
    filiationmothername character varying(30) NOT NULL,
    addressstreet character varying(50) NOT NULL,
    addresszipcode character varying(30) NOT NULL,
    addresscity character varying(40) NOT NULL,
    addresscountry character varying(100) NOT NULL,
    addressdistrict character varying(40) NOT NULL,
    addressstate character varying(2) NOT NULL,
    addressphone character varying(30) NOT NULL,
    professionaladdresscompany character varying(40) NOT NULL,
    professionaladdressunit character varying(30) NOT NULL,
    professionaladdressstreet character varying(50) NOT NULL,
    professionaladdresszipcode character varying(30) NOT NULL,
    professionaladdresscity character varying(40) NOT NULL,
    professionaladdresscountry character varying(100) NOT NULL,
    professionaladdressdistrict character varying(40) NOT NULL,
    professionaladdressstate character varying(2) NOT NULL,
    professionaladdressphone character varying(30) NOT NULL,
    miscemail character varying(100) NOT NULL,
    loginid integer NOT NULL,
    id integer NOT NULL
);

CREATE TABLE published (
    completename character varying(40) NOT NULL,
    id integer DEFAULT nextval('publishedpksequence'::regclass) NOT NULL,
    loginid integer NOT NULL
);

ALTER TABLE ONLY academic
    ADD CONSTRAINT academicpk PRIMARY KEY (id);

ALTER TABLE ONLY accepted
    ADD CONSTRAINT acceptedpk PRIMARY KEY (id);

ALTER TABLE ONLY book
    ADD CONSTRAINT bookpk PRIMARY KEY (id);

ALTER TABLE ONLY complementary
    ADD CONSTRAINT complementarypk PRIMARY KEY (id);

ALTER TABLE ONLY experience
    ADD CONSTRAINT experiencepk PRIMARY KEY (id);

ALTER TABLE ONLY login
    ADD CONSTRAINT loginpk PRIMARY KEY (id);

ALTER TABLE ONLY personalinfo
    ADD CONSTRAINT personalinfopk PRIMARY KEY (id);

ALTER TABLE ONLY published
    ADD CONSTRAINT publishedpk PRIMARY KEY (id);

ALTER TABLE ONLY academic
    ADD CONSTRAINT academicfk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY accepted
    ADD CONSTRAINT acceptedfk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY book
    ADD CONSTRAINT bookfk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY complementary
    ADD CONSTRAINT complementaryfk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY experience
    ADD CONSTRAINT experiencefk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY personalinfo
    ADD CONSTRAINT personalinfofk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY published
    ADD CONSTRAINT publishedfk FOREIGN KEY (loginid) REFERENCES login(id) ON UPDATE CASCADE ON DELETE CASCADE;
    
INSERT INTO login (email, password, enabled) VALUES('admin@admin.com', '123456', true);
INSERT INTO login (email, password, enabled) VALUES('user@user.com', '654321', true);
