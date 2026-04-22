package PM.Interfaces.solid;

import AM.designPattern.templateMethod.AbstractDisplay;
import AM.designPattern.templateMethod.StringDisplay;

public class StringDisplayMain {
    public static void main(String[] args) {
        AbstractDisplay d = new StringDisplay("Hello");
        d.display();
    }
}
