import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TesteRelation {
    public static void main(String[] args) {
        Relation r = new Relation();
        Scanner sc = new Scanner(System.in);

        label:
        while(true){
            String line = sc.nextLine();
            System.out.println("$"+line);
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "end":
                    break label;
                case "createRelation":
                    Set<Integer> domain = new HashSet<>();
                    for (int i = 1; i < ui.length; i++) {
                        domain.add(Integer.parseInt(ui[i]));
                    }
                    r = new Relation(domain);
                    break;
                case "addPair": {
                    int a = Integer.parseInt(ui[1]);
                    int b = Integer.parseInt(ui[2]);
                    try {
                        r.addPair(a, b);
                    } catch (InvalidPairException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case "hasPair": {
                    int a = Integer.parseInt(ui[1]);
                    int b = Integer.parseInt(ui[2]);
                    System.out.println(r.hasPair(a, b));
                    break;
                }
                case "isReflexive":
                    System.out.println(r.isReflexive());
                    break;
                case "checkReflexive":
                    r.checkReflexive();
                    break;
                case "isSymmetric":
                    System.out.println(r.isSymmetric());
                    break;
                case "checkSymmetric":
                    r.checkSymmetric();
                    break;
                case "isTransitive":
                    System.out.println(r.isTransitive());
                    break;
                case "checkTransitive":
                    r.checkTransitive();
                    break;
                case "show":
                    System.out.println(r);
                    break;
                default:
                    System.out.println("fail: comando invalido");
            }
        }
        sc.close();
    }
}