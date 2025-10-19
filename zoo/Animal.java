package zoo;

public class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;

    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        setName(name);
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public String getName() { return name; }
    public void setName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Le nom de l'animal ne peut pas être vide");
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if(age < 0) throw new IllegalArgumentException("L'âge ne peut pas être négatif");
        this.age = age;
    }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean mammal) { isMammal = mammal; }

    @Override
    public String toString() {
        return "Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }
}
