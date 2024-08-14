package OOD;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<K, V> {

    public K k;
    public V v;
    public Pair(K k, V v){
        this.k = k;
        this.v = v;
    }

}
