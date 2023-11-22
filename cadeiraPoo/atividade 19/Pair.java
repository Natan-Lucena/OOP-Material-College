public final class Pair {
    private final int first;
    private final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Pair aux = (Pair) obj;
        return (this.getFirst()== aux.getFirst()&&(this.getSecond()==aux.getSecond()));
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return first ^ second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}