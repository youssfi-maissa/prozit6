package main;

import zoo.*;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Parc Animalier", "Tunis");

        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tigre = new Animal("Félidé", "Tigre", 4, true);
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tigre);

        Dolphin dolphin = new Dolphin("Mammifère", "Flipper", 3, true, "Océan", 25.5f);
        Penguin penguin = new Penguin("Oiseau", "Pingouin", 2, false, "Bassin", 10f);
        myZoo.addAnimal(dolphin);
        myZoo.addAnimal(penguin);

        myZoo.addAquaticAnimal(dolphin);
        myZoo.addAquaticAnimal(penguin);

        System.out.println("Tous les animaux :");
        myZoo.displayAnimals();

        System.out.println("\nAnimaux aquatiques :");
        myZoo.displayAquaticAnimals();

        System.out.println("\nTest swim pour tous les aquatiques :");
        myZoo.swimAllAquatics();

        System.out.println("\nProfondeur max des pingouins : " + myZoo.maxPenguinSwimmingDepth());
        myZoo.displayNumberOfAquaticsByType();
    }
}
