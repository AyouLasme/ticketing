# Projet Sir Ticket Github

##### AUTORS
* Ayou Lasme
* Mamba Fofana
  <br/>

### Table of contents
[Introduction](##INTRODUCTION)
1. [Prérequis](##PREREQUIS)
2. [Installation](##INSTALLATION)
3. [Utilisation](##UTILISATION)
4. [Fonctionnalités]()
5. [Test](TEST AVEC POSTMAN)

[Conclusion](##Conclusion)

### INTRODUCTION
***
* <b>Objectif du projet:<b/>
    * Ce projet a pour objectif de permettre de découvrir les mécanismes de JPA (Java Persistence API), en développant un gestionnaire de tickets similaire à ceux utilisés sur des plateformes comme GitHub. Les aspects clés incluent la compréhension des mécanismes de JPA, 
      la modélisation du modèle métier, la création de classes entités, et l'utilisation de requêtes pour interagir avec la base de données.
  
* <b>Vue d'ensemble du projet :<b/>
    * L'application développée est un gestionnaire de tickets informatiques qui permettra aux utilisateurs de créer, visualiser, mettre à jour et fermer des tickets de support technique. Le système offre également la possibilité d'attribuer des tags aux tickets.

### PREREQUIS
***
Cette application est une API développée lors des TP2-4 et TP5 du laboratoire des systèmes d'information distribués.
Suivez [ce lien](https://docs.google.com/document/d/1H3YU4agteIqMysxSWKxEWEqjpQs0kIVQa3gQQG27CXc/edit) pour voir la déclaration du laboratoire TP5. Ce TP5 est basé sur le TP2-4 dont l'énoncé est [ici](https://docs.google.com/document/d/1IfN_LvfZCZJIu4aNO3_2zpZqAsjObqWRd8Bs4sYtN1I/edit).
  <br> TP2-4 et TP5 peuvent être trouvés dans cette application. Et voici la composition de l'application en détail :
* <b>TP2-4<b/>
    * Mise en place du mapping relationnel avec JPA et Hibernate, connexion à la base de données,
    * Ecriture de DAO (Data Access Objects) qui sont des classes de services permettant de peupler la base de données et également de faire des requêtes sur la base de données.<br><br>

* TP5 (API REST) <br>
    * Faire du TP2-4 un backend (créer une API pour l'application Frontend qui sera développée dans TP6 et TP7)
    * Mettre en place l'API REST
    * Configurer la documentation de l'API à l'aide d'OpenAPI et de Swagger UI.<br><br>

* Logiciel necessaires
  * Java (version 8 ou supérieure)
  * JPA : [here](https://www.baeldung.com/learn-jpa-hibernate)
  * Hibernate : [here](https://hibernate.org/)
  * MySQL : [here](https://www.mysql.com/), or Xampp : [here](https://www.apachefriends.org/fr/index.html)
  * API REST :  [here](https://www.restapitutorial.com/)
  * OpenAPI : [here](https://www.openapis.org/)
  * Swagger: [here](https://swagger.io/docs/specification/about/)
  * Postman : [here](https://www.postman.com/)
  * Maven (pour la gestion des dépendances)<br><br>
  
* Organisation
  * Le projet utilise un template disponible sur GitHub [tpjpa2023](https://github.com/barais/tpjpa2023).
  * Un compte GitLab avec un jeton d'accès personnel pour l'API [tp Sir 2024](https://gitlab.istic.univ-rennes1.fr/alasme/tp1_ticket_sir.git) disponible sur la branche master.<br>
NB:  Les étapes d'importation du projet dans Eclipse ou IntelliJ sont détaillées dans la section "Démarrage de la base de données".

### INSTALLATION
***

Exigences :
- IntelliJ IDEA or Eclipse IDE
- Apache Maven
- MySQL

Ensuite suivez ces étapes pour le lancement de l'API:

1. Vous devez d’abord avoir [Apache Maven](https://maven.apache.org/) installé sur votre ordinateur. Si vous n'avez pas Apache Maven, vous pouvez l'obtenir [ici](https://maven.apache.org/).


2. Clonez le projet sur la branche master ou téléchargez-le depuis le référentiel GitLab ou en faisant "git clone https://gitlab.istic.univ-rennes1.fr/alasme/tp1_ticket_sir.git"


3. Importez le projet dans votre IDE (IntelliJ IDEA ou Eclipse IDE) en tant que projet Maven. Cela peut prendre quelques minutes pendant que Maven télécharge toutes les dépendances du projet.


4. Pour que l'application fonctionne correctement, MySQL doit être installé sur votre ordinateur. Si vous n'avez pas MySQL, vous pouvez l'obtenir [ici](https://www.apachefriends.org/fr/index.html) (xampp). Dans les instructions suivantes, nous supposons que MySQL est bien installé sur votre ordinateur.


5. Afin de ne pas vous obliger à modifier quoi que ce soit dans le code source de l'application, créez un nouvel utilisateur nommé « root» pour MySQL (ou PhpMyAdmin si vous utilisez Xammp) et donnez-lui « » comme mot de passe. Créez ensuite une nouvelle base de données nommée « gestion_ticket_git» pour le nouvel utilisateur que vous venez de créer et donnez-lui tous les droits sur cette base de données.


6. Pour tester l'application, nous vous aiderons en remplissant rapidement la base de données. Il y a à la racine du projet un fichier nommé "gestion_ticket_git.sql" Importez le contenu de ce fichier dans la base de données.


7. Vous pouvez ignorer les étapes 5 et 6. Vous suivrez cette étape uniquement si vous n'avez pas suivi les étapes 5 et 6. Modifiez donc ce fichier `src/main/resources/META-INF/persistence.xml` en changeant le nom de la base de données , le nom d'utilisateur et le mot de passe de l'utilisateur. N'oubliez pas de remplacer la ligne 8 `<property name="hibernate.hbm2ddl.auto" value="update"/>` par `<property name="hibernate.hbm2ddl.auto" value="create"/>` .


8. Exécutez ce fichier : `src/main/java/jpa/JpaTest.java. Ensuite, l'API s'exécute sur le port 8080.


9. Exécutez ce fichier : `src/main/java/jpa/RestServer.java pour lancer le serveur web


10. Ouvrez cette URL (`http://localhost:8000/api/`) dans votre navigateur Web ou cliquez sur [ici](http://localhost:8000/api) pour voir la documentation de l'API, comment l'utiliser.


### UTILISATION

Ouvrez votre navigateur et accédez à l'URL suivante : http://localhost:8000

### FONCTIONNALITES
***

1. Création de Ticket
    * Les utilisateurs peuvent créer de nouveaux tickets en spécifiant les détails pertinents.

2. Visualisation des Tickets
    * Consultez la liste des tickets existants avec leurs informations associées.

3. Mise à Jour et Fermeture des Tickets
    * Mettez à jour l'état et les détails des tickets. Marquez les tickets comme résolus ou fermés.uez les tickets comme résolus ou fermés.
4. Affectation des tickets
   * Un utilisateur peut affecter un ticket à un ou plusieurs utilisateurs


### TEST AVEC POSTMAN
***

1. Prérequis: Assurez-vous d'avoir Postman installé sur votre machine.
2. Execution des tests
   * Ouvrez Postman et importez le fichier de collection de tests (si vous en avez un) ou créez une nouvelle requête pour chaque fonctionnalité testée.
3. Exemple de requette
   * Création d'un Ticket
     * Méthode : POST
       * Endpoint : http://localhost:8000/tickets
         * Corps de la Requête :<br>
           {<br>
               "libelle": "Creation de la page d'acceuil",<br>
               "creerPar": {<br>
                   "id":"0ac18c8c-8e07-1683-818e-076694260000",<br>
                   "nom": "Mia",<br>
                   "prenom": "Kayla",<br>
                   "email": "Mia@GMAIL.COM"<br>
               }<br>
           }
         * Réponse Attendue : Statut 201 Created
            

### CONCLUSION
***

Ce projet de gestionnaire de tickets avec JPA a permis d'explorer et d'appliquer les concepts fondamentaux de Java Persistence API. La modélisation du modèle métier, la création d'entités, l'association entre elles, ainsi que l'utilisation de requêtes pour interagir avec la base de données ont été des aspects clés du développement.

Les instructions détaillées fournies dans ce README ont guidé l'installation, la configuration et l'utilisation de l'application. Les tests effectués à l'aide de Postman ont validé le bon fonctionnement des fonctionnalités clés, garantissant ainsi la robustesse de l'application.

Ce projet a été une opportunité d'approfondir la compréhension de JPA et de mettre en pratique les compétences acquises dans le cadre du cours. En cas de questions ou d'améliorations, n'hésitez pas à explorer davantage le code source et à solliciter des retours pour une évolution continue.


***
* Nous avons réutilisé du code de notre professeur de [cet dépot](https://github.com/barais/tpjpa2020).
* Merci [Mr Olivier Barais](https://github.com/barais).