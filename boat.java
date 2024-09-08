class boat {
    private int capacity;
    private boolean isFinalStop;

    public boat(int capacity, boolean isFinalStop) {
        this.capacity = capacity;
        this.isFinalStop = isFinalStop;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFinalStop() {
        return isFinalStop;
    }
}