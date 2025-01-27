package jimenez.fernandez.manueljesus.pmdmtarea3.models;

public class TypeSlot {
    private int slot;
    private Type type;

    public TypeSlot() {}

    public TypeSlot(int slot, Type type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}










