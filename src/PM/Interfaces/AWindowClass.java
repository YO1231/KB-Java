package PM.Interfaces;

public class AWindowClass {

    public AWindowClass() {
        new AbstractWindowClass(){
            @Override
            public void mouseClicked() {
                super.mouseClicked();
            }
        };
    }

}
