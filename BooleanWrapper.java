public class BooleanWrapper {
    private boolean value;

    BooleanWrapper(boolean value) {
        this.value = value;
    }


    public void set(boolean value) {
        this.value = value;
    }
    public boolean get() {
        return value;
    }
}

