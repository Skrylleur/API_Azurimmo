# 🏡 AzurImmo – API Spring Boot

Bienvenue dans le dépôt de l'API **AzurImmo**, une application backend développée avec **Spring Boot** pour la gestion locative d'un parc immobilier.

Ce projet sert de fondation pour deux interfaces clientes :
- une application **web** (Next.js)
- une application **mobile** (Kotlin)

---

## 🚀 Objectifs

- Fournir une **API RESTful complète** pour gérer bâtiments, appartements, contrats, paiements, locataires, garants et interventions
- Permettre un **suivi clair et structuré** de chaque entité immobilière
- Offrir une base **solide, évolutive et sécurisable** pour des clients web et mobile

---

## 🛠 Stack technique

- **Java 17**
- **Spring Boot 3**
  - Spring Web (REST)
  - Spring Data JPA (Hibernate)
- **Base de données** : PostgreSQL (ou H2 pour les tests)
- **ORM** : JPA/Hibernate
- **Build tool** : Maven
- **IDE** : Visual Studio Code

---

## 📚 Fonctionnalités principales

| Entité       | CRUD | Relations clés |
|--------------|------|----------------|
| Bâtiment     | ✅   | Appartements   |
| Appartement  | ✅   | Bâtiment       |
| Contrat      | ✅   | Appartement, Locataire, Paiements, Garants |
| Paiement     | ✅   | Contrat        |
| Locataire    | ✅   | Contrat        |
| Garant       | ✅   | Contrat        |
| Intervention | ✅   | Appartement    |

---

## 🔁 Endpoints principaux

| Ressource           | Méthode | Endpoint                          |
|---------------------|---------|-----------------------------------|
| Bâtiments           | GET     | `/batiments`                      |
| Appartements        | GET     | `/appartements`                   |
| Contrats            | GET     | `/contrats`                       |
| Paiements           | GET     | `/paiements`                      |
| Locataires          | GET     | `/locataires`                     |
| Garants             | GET     | `/garants`                        |
| Interventions       | GET     | `/interventions`                 |
| Apparts par Bâtiment| GET     | `/appartements/batiment/{id}`     |
| Contrats par Appart | GET     | `/contrats/appartement/{id}`      |
| Paiements par Contrat | GET   | `/paiements/contrat/{id}`         |

⚠️ L’authentification n’est pas encore activée (prévue avec **Spring Security + JWT**).

---

## 🧪 Lancement local

### Prérequis

- Java 17+
- Maven
- PostgreSQL ou base H2 intégrée

### Démarrage

```bash
# Cloner le repo
git clone https://github.com/Skrylleur/azurimmo-api.git
cd azurimmo-api

# Lancer l'application
./mvnw spring-boot:run