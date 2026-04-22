package PM.inner;

public class CollectionMain {
    private int x;

    public CollectionMain() {
        new CollectionEx() {

            @Override
            public void add() {
                x=100;
            }

            @Override
            public void remove() {

            }

            @Override
            public void empty() {

            }
        };
    }

    public static void main(String[] args) {
        CollectionMain c = new CollectionMain();
    }
}
