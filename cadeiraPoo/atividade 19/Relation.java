import java.util.*;

public class Relation {
    private final Set<Integer> domain;
    private final Set<Pair> pairs;

    public Relation(){
        domain = new HashSet<>();
        pairs = new HashSet<>();
    }

    public Relation(Set<Integer> A){
        domain = new HashSet<>(A);
        pairs = new HashSet<>();
    }

    public void addPair(int a, int b) throws InvalidPairException {
        if(!domain.contains(a)){
            throw new InvalidPairException(a + " is not in domain");
        }
        else if(!domain.contains(b)){
            throw new InvalidPairException(b + " is not in domain");
        }
        else{
            pairs.add(new Pair(a,b));
        }
    }

    public boolean hasPair(int a, int b){
        return pairs.contains(new Pair(a,b));
    }

    public boolean isReflexive(){
        for(int dom : domain){
            if(!hasPair(dom,dom)){
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric(){
        for(int x : domain){
            for(int y : domain){
                if((hasPair(x,y) && !hasPair(y,x)) || (!hasPair(x,y) && hasPair(y,x))){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTransitive(){
        for(int x : domain){
            for(int y : domain){
                for(int z : domain){
                    if (hasPair(x, y) && hasPair(y, z) && !hasPair(x, z)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void checkReflexive(){
        for(int x : domain){
            System.out.println("hasPair("+x+","+x+") = "+hasPair(x,x));
            if(!hasPair(x,x)){
                break;
            }
        }
        System.out.println(isReflexive() ? "Relation is reflexive" : "Relation is not reflexive");
    }

    public void checkSymmetric(){
        label:
        for(int x : domain){
            for(int y : domain){
                System.out.println("hasPair("+x+","+y+") = "+hasPair(x,y)+", hasPair("+y+","+x+") = "+hasPair(y,x));
                if((hasPair(x,y) && !hasPair(y,x)) || (!hasPair(x,y) && hasPair(y,x))){
                    break label;
                }
            }
        }
        System.out.println(isSymmetric() ? "Relation is symmetric" : "Relation is not symmetric");
    }

    public void checkTransitive(){
        label:
        for(int x :domain){
            for(int y :domain){
                for(int z :domain){
                    System.out.println("hasPair("+x+","+y+") = "+hasPair(x,y)+", hasPair("+y+","+z+") = "+hasPair(y,z)+", hasPair("+x+","+z+") = "+hasPair(x,z));
                    if (hasPair(x, y) && hasPair(y, z) && !hasPair(x, z)){
                        break label;
                    }
                }
            }
        }
        System.out.println(isTransitive() ? "Relation is transitive" : "Relation is not transitive");
    }

    @Override
    public String toString() {
        Iterator<Pair> pairIterator = pairs.iterator();
        StringBuilder sb = new StringBuilder("domain : ");
        sb.append(domain).append(", pairs : {");
        while(pairIterator.hasNext()){
            sb.append(pairIterator.next()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append('}');
        return sb.toString();
    }
}