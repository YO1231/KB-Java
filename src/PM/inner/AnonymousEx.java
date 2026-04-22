package PM.inner;

import java.util.ArrayList;
import java.util.Iterator;

public class AnonymousEx extends Outer {

    ArrayList list = new ArrayList() {

        @Override
        public Iterator iterator() {
            return super.iterator();
        }
    };
    public void listAdd() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "hello^^";
    }

    public static void main(String[] args) {
        AnonymousEx a = new AnonymousEx();
        a.listAdd();
    }
}
