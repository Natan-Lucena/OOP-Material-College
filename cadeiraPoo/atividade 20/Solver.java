import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Robo {
    String palavra;

    public Robo(String palavra) {
        this.palavra = palavra;
    }

    public Collection<String> palavrasValidas() {
        Set<String> result = new TreeSet<>();
        generateValidWords(result, palavra.toCharArray(), 0);
        return result;
    }

    private void generateValidWords(Set<String> result, char[] current, int index) {
    if (index == current.length) {
        result.add(new String(current));
        return;
    }

    if (current[index] == '?') {
        current[index] = 'a';
        if (index == 0 || current[index - 1] != 'a') {
            generateValidWords(result, current, index + 1);
        }
        current[index] = 'b';
        generateValidWords(result, current, index + 1);
        current[index] = '?';
    } else {
        if (index == 0 || current[index - 1] != 'a' || current[index] != 'a') {
            generateValidWords(result, current, index + 1);
        }
    }
}

}

class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Robo r = new Robo(s);
        for (String palavra : r.palavrasValidas()) {
            System.out.println(palavra);
        }
    }
}
