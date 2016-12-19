# MowItNow
## Prérequis
Cette application a été développée en Java 8, par conséquent, une JDK compatible version 8 est nécessaire. Pour lancer l'application, vous pouvez lancer la commande suivante: ```java -jar mow-<version>.jar <pathToInputFile>```. Toutes les librairies nécessaires pour le bon fonctionnement de l'application sont incluses dans le fichier JAR.
```
## Format du fichier d'entrée
5 5 # Dimensions de la pelouse
1 2 N # Position intial de la tendeuse et son orientation (N, S, E, W)
ADGAADAD " Actions a réaliser (A avancer, D tourner à droite, G tourner à gauche)
```

Tous les paramètres sur la même ligne doivent être séparés par des espaces. On peut rajouter autant de tendeuses que l'on veut
```
5 5 # Dimensions de la pelouse
1 2 N # Position intial de la tendeuse 1
ADGAADAD # Actions a réaliser par la tendeuse 1
3 3 E # Position intial de la tendeuse 2
AADAADADDA # Actions a réaliser par la tendeuse 2
```

