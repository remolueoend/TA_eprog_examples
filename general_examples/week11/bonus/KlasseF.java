package bonus;

// Ausser der "extends" Klausel, veraendern Sie diese Datei nicht!

public class KlasseF extends KlasseB /* Wenn noetig, dann fuegen Sie hier eine "extends" Klausel hinzu */ {
    int foo() {
        int y = super.foo();
        x = y+1;
        return x;
    }
}