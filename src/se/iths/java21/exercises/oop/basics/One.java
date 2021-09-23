package se.iths.java21.exercises.oop.basics;

public class One {
    private boolean predator;
    private boolean mammal;
    private boolean landWalker;

    public One(boolean predator, boolean mammal, boolean landWalker) {
        this.predator = predator;
        this.mammal = mammal;
        this.landWalker = landWalker;

    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public boolean isMammal() {
        return mammal;
    }

    public void setMammal(boolean mammal) {
        this.mammal = mammal;
    }

    public boolean isLandWalker() {
        return landWalker;
    }

    public void setLandWalker(boolean landWalker) {
        this.landWalker = landWalker;
    }
}
