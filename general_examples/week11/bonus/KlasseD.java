package bonus;

// Ausser der "extends" Klausel, veraendern Sie diese Datei nicht!

public class KlasseD extends KlasseC /* Wenn noetig, dann fuegen Sie hier eine "extends" Klausel hinzu */ {
    int foo() {
        int y = super.foo();
        x = y+1;
        return x;
    }
}