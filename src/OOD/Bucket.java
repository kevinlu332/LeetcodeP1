package OOD;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bucket<Pair> {
    public List<Pair> list;
    public Bucket(){
        list = new ArrayList<>();
    }
}
