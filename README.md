

## RayBan Point of Sale Management System

![System Diagram](system_diagram.png)

## Database

The management applications each have their own database:

- Sales Management Application: G_Vente
- Inventory Management Application: G_Stock

We will use G_Vente for our application because this is only the sales management part. The proposed structure for the management databases (subject to modification) consists of the following tables:

### G_Vente Database:

- Articles_Prix (codeArt: int, nomArt: varchar(20), descArt: varchar(200), prixArt: int(11))
- Commandes (codeCmd: int, client: varchar(20), codeArt: int, qteCmd: int, dateCmd: date)
- Users (codeUser: int, login: varchar(20), pass: varchar(20))

### G_Stock Database:

- Articles_Stock (codeArt: int, qteArt: int, nomArt: varchar(20), descArt: varchar(200), prixArt: int(11))
- Articles_Approvisionnement (codeArt: int, qteCommandé: int, datePrevueLivraison: Date)

## Technical and Functional Requirements

The main objectives of the project for each management application are as follows:

### Sales Management Application (Struts, Hibernate, JQuery, Spring*):

- Create one or more pages to display information about all the articles in stock in the form of a table with the following columns:
  - Article Code (retrieved by Hibernate from G_Stock)
  - Article Name (retrieved by Hibernate from G_Vente)
  - Article Price (retrieved by Hibernate from G_Vente)
  - Existing Quantity (retrieved by Hibernate from G_Stock)

- Create a page or multiple pages to add an order by article and enable the following actions:
  - Display the invoice for the order in PDF format
  - Subtract the ordered quantity from the "Articles_Stock" table (via Hibernate from G_Stock)
  - Add a new order line to the "Commandes" table (via Hibernate from G_Vente)

- Create pages to create and modify user account passwords.

*Note: The technologies/frameworks mentioned here, such as Struts, Hibernate, JQuery, and Spring, will be used in the implementation of the Sales Management Application.*
  ![UseCaseJ2EE](https://github.com/ISMAILIZakariae/RayBan-Point-of-Sale-System-J2EE-Spring-Struts/assets/110783459/9a74874c-ae5b-4939-9f56-8d7b157d9eb8)![ClassJ2EE](https://github.com/ISMAILIZakariae/RayBan-Point-of-Sale-System-J2EE-Spring-Struts/assets/110783459/3ec41398-5083-4989-b5a5-fbce3412b4b8)
![SeqJ2EE](https://github.com/ISMAILIZakariae/RayBan-Point-of-Sale-System-J2EE-Spring-Struts/assets/110783459/d012af96-dc75-4709-ba05-ac82ed7f7c18)
