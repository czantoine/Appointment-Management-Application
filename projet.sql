#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: patient
#------------------------------------------------------------

CREATE TABLE patient(
        id_patient           Int  Auto_increment  NOT NULL ,
        Nom                  Varchar (50) NOT NULL ,
        Prenom               Varchar (50) NOT NULL ,
        Nd_Prenom            Varchar (50) NOT NULL ,
        Classification       Varchar (50) NOT NULL ,
        Connaissance         Varchar (50) NOT NULL ,
        Sexe                 Varchar (50) NOT NULL ,
        Profession_actuelle  Varchar (50) NOT NULL ,
        Profession_anterieur Varchar (50) NOT NULL
	,CONSTRAINT patient_PK PRIMARY KEY (id_patient)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: rdv
#------------------------------------------------------------

CREATE TABLE rdv(
        id_RDV                  Int  Auto_increment  NOT NULL ,
        Date                    Date NOT NULL ,
        Heure                   Time NOT NULL ,
        Prix                    Int NOT NULL ,
        Reglement               Varchar (50) NOT NULL ,
        id_patient              Int NOT NULL ,
        id_patient_prise_de_rdv Int NOT NULL
	,CONSTRAINT rdv_PK PRIMARY KEY (id_RDV)

	,CONSTRAINT rdv_patient_FK FOREIGN KEY (id_patient_prise_de_rdv) REFERENCES patient(id_patient)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Historique
#------------------------------------------------------------

CREATE TABLE Historique(
        id_historique Int  Auto_increment  NOT NULL ,
        Anxiete       Int NOT NULL ,
        Mots_clef     Varchar (200) NOT NULL ,
        Postures      Varchar (200) NOT NULL ,
        Comportement  Varchar (200) NOT NULL ,
        id_patient    Int  Auto_increment  NOT NULL
	,CONSTRAINT Historique_PK PRIMARY KEY (id_historique)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: psy
#------------------------------------------------------------

CREATE TABLE psy(
        id_spy        Int  Auto_increment  NOT NULL ,
        Nom           Varchar (50) NOT NULL ,
        Prenom        Varchar (50) NOT NULL ,
        Num_phone     Int NOT NULL ,
        id_patient    Int NOT NULL ,
        id_historique Int NOT NULL
	,CONSTRAINT psy_PK PRIMARY KEY (id_spy)

	,CONSTRAINT psy_patient_FK FOREIGN KEY (id_patient) REFERENCES patient(id_patient)
	,CONSTRAINT psy_Historique0_FK FOREIGN KEY (id_historique) REFERENCES Historique(id_historique)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ajout du RDV en historique
#------------------------------------------------------------

CREATE TABLE Ajout_du_RDV_en_historique(
        id_historique Int NOT NULL ,
        id_RDV        Int NOT NULL
	,CONSTRAINT Ajout_du_RDV_en_historique_PK PRIMARY KEY (id_historique,id_RDV)

	,CONSTRAINT Ajout_du_RDV_en_historique_Historique_FK FOREIGN KEY (id_historique) REFERENCES Historique(id_historique)
	,CONSTRAINT Ajout_du_RDV_en_historique_rdv0_FK FOREIGN KEY (id_RDV) REFERENCES rdv(id_RDV)
)ENGINE=InnoDB;

