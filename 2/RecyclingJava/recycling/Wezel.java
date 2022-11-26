package recycling;
import java.util.HashMap;
import java.util.TreeMap;
public class Wezel{ 
    @Deprecated
    @Override
    protected void finalize () throws Throwable {
        System.out.println("Finalizowanie␣obiektu"); 
        super.finalize ();
    }
    
    HashMap<Wezel, Boolean> polaczenia1 = new HashMap <Wezel, Boolean>();
    TreeMap<Integer, Wezel> polaczenia2 = new TreeMap <Integer, Wezel>();
    Integer i=0;
    void dodajPolaczenie(Wezel w){
        i=i+1;
        polaczenia1.put(w,true);
        polaczenia2.put(i, w);
    }
    public static void main( String [ ] args ) {
        Wezel w1 = new Wezel();
        Wezel w2 = new Wezel();
        w1.dodajPolaczenie(w2);
        w2.dodajPolaczenie(w1);
        System.out.println(w1.polaczenia1);
        System.out.println(w2.polaczenia1);
        System.out.println(w1.polaczenia2);
        System.out.println(w2.polaczenia2);
    }
}