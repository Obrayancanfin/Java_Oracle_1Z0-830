# Exercice : Modularisation d'une Application de Bibliothèque

## Objectif
L'objectif de cet exercice est de structurer une application Java en utilisant le système de modularité introduit avec Java SE 9. Vous devrez organiser les différentes fonctionnalités d'une bibliothèque dans des modules distincts, afin de favoriser une conception claire, maintenable et évolutive.

## Contexte
Vous devez concevoir une application modulaire pour une bibliothèque. L'application permet de :

1. Gérer les livres disponibles (module **BookAPI**).
2. Gérer les prêts et retours de livres (module **Checkout**).
3. Maintenir un inventaire des livres (module **Inventory**).
4. Envoyer des notifications aux utilisateurs (modules **EmailNotification** et **NotificationService**).
5. Générer des rapports (module **Reports**).
6. Fournir un point d'entrée pour exécuter l'application (module **App**).

## Instructions

1. **Créer les modules** :
   - Chaque module doit être défini par un fichier `module-info.java`.
   - Les modules doivent exporter leurs packages ou les rendre accessibles à d'autres modules selon les besoins.

2. **Module : BookAPI**
   - Classe principale : `Book` (représente un livre avec des attributs comme le titre, l'auteur, et l'identifiant).
   - Le module doit fournir des informations sur les livres.

3. **Module : Checkout**
   - Classe principale : `CheckoutSystem` (gère les prêts et retours des livres).
   - Ce module dépend du module **BookAPI**.

4. **Module : Inventory**
   - Classe principale : `BookInventory` (gère l'ajout et la suppression de livres dans l'inventaire).
   - Ce module dépend du module **BookAPI**.

5. **Module : NotificationService**
   - Classe principale : `NotificationService` (un service générique pour envoyer des notifications).
   - Ce module sera utilisé par d'autres modules liés aux notifications.

6. **Module : EmailNotification**
   - Classe principale : `EmailNotification` (gère les notifications par email).
   - Ce module dépend du module **NotificationService**.

7. **Module : Reports**
   - Classe principale : `InventoryReport` (génère des rapports sur l'inventaire des livres).
   - Ce module dépend des modules **Inventory** et **BookAPI**.

8. **Module : App**
   - Classe principale : `LibraryApp` (point d'entrée de l'application).
   - Ce module utilise tous les autres modules pour offrir une expérience complète.

9. **Générer un fichier README** :
   - Créez un fichier `README.md` à la racine du projet.
   - Ce fichier doit inclure les commandes nécessaires pour compiler et exécuter l'application.
   - Les étapes doivent être présentées dans l'ordre correct, par exemple :
     1. Compilation des modules.
     2. Exécution de l'application principale.
   
   Exemple :
   
   ### Étapes pour exécuter l'application
   1. Compiler les modules :
      ```
      javac -d out --module-source-path src *.java
      ```
   2. Exécuter l'application principale :
      ```
      java --module-path out -m app/com.app.LibraryApp
      ```
   

## Déroulement de l'exercice

1. **Implémenter les classes et modules** :
   - Complétez les classes avec les fonctionnalités requises.
   - Définissez correctement les dépendances entre modules dans les fichiers `module-info.java`.

2. **Compiler et exécuter** :
   - Assurez-vous que l'application compile sans erreurs.
   - Testez les interactions entre modules en exécutant `LibraryApp`.

## Exemples de dépendances
Voici un exemple de déclaration des dépendances dans un fichier `module-info.java` :

```java
module checkout {
    requires bookapi;
    exports com.checkout;
}
```

## Critères de validation
- Chaque fonctionnalité est correctement encapsulée dans son module.
- Les dépendances entre modules sont définies de manière optimale.
- L'application fonctionne comme prévu.
- Un fichier `README.md` clair et complet est fourni.