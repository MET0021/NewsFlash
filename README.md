Choix de l'architecture

J'ai choisi l'architecture MVVM car elle permet de séparer les responsabilités entre les différentes couches de l'application. Cette séparation facilite la lecture du code et rend le code plus maintenable et extensible. Le ViewModel permet de gérer les données de manière lifecycle-conscious, ce qui évite les fuites de mémoire et améliore la performance de l'application.
Choix techniques:
- Coroutines : Pour gérer les tâches asynchrones de manière simple et efficace.
- Retrofit : Bibliothèque puissante et facile à utiliser pour les appels réseau.
- LiveData : Pour les données observables qui respectent le cycle de vie.
- ViewModel : Pour stocker et gérer les données UI de manière lifecycle-conscious.
- Coil : Pour le chargement efficace des images.

Problèmes identifiés :
- Tests unitaires : J'ai commence l'implementation des tests mais je n'est pas bien reussi a le faire et ça m'a pris plus de temps.
