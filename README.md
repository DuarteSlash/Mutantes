# Mutantes

Este programa se realiza para la validación de si una persona con su adn es mutante o no.

Se debe ejecutar el archivo Main que se encuentra en src\main\java\co\com\ml\domain\MutantMain.java

Se debe incorporar la cadena de ADN a validar:

Para Validar Horizontal
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

Para Validar Vertical
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CGCCTA","TCACTG"};

Para Validar Transversal
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAAG","CGCCTA","TCACTG"};

El programa retorna un mensaje :
La persona es un Mutante

O 
La persona no es un Mutante

Se crea API para Nivel 2 y nivel 3 con base de datos de MongoDB

