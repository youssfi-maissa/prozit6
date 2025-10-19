package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private String city;
    private final int MAX_CAGES = 25;
    private List<Animal> animals = new ArrayList<>();

    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int nbrAquaticAnimals = 0;

    public Zoo() {}

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Le nom du Zoo ne peut pas être vide");
        this.name = name;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public boolean addAnimal(Animal animal) {
        if(isZooFull() || animals.contains(animal)) return false;
        animals.add(animal);
        return true;
    }

    public boolean removeAnimal(Animal animal) { return animals.remove(animal); }

    public void displayAnimals() {
        for(Animal a : animals) System.out.println(a);
    }

    public int searchAnimal(Animal animal) {
        for(int i=0; i<animals.size(); i++) {
            if(animals.get(i).getName().equals(animal.getName())) return i;
        }
        return -1;
    }

    public boolean isZooFull() { return animals.size() >= MAX_CAGES; }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return z1.animals.size() >= z2.animals.size() ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Animaux=" + animals.size() + "]";
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if(nbrAquaticAnimals >= aquaticAnimals.length) return;
        aquaticAnimals[nbrAquaticAnimals++] = aquatic;
    }

    public void displayAquaticAnimals() {
        for(int i=0; i<nbrAquaticAnimals; i++) System.out.println(aquaticAnimals[i]);
    }

    public void swimAllAquatics() {
        for(int i=0; i<nbrAquaticAnimals; i++) aquaticAnimals[i].swim();
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0f;
        for(int i=0; i<nbrAquaticAnimals; i++) {
            if(aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if(p.getSwimmingDepth() > maxDepth) maxDepth = p.getSwimmingDepth();
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphins = 0, penguins = 0;
        for(int i=0; i<nbrAquaticAnimals; i++) {
            if(aquaticAnimals[i] instanceof Dolphin) dolphins++;
            if(aquaticAnimals[i] instanceof Penguin) penguins++;
        }
        System.out.println("Dolphins: " + dolphins + ", Penguins: " + penguins);
    }
}
