package PM.base.module;

public class StringEx {
    private char[] value;

    public StringEx() {
    }


    public StringEx(char[] value) {
        this.value = value;
    }

    public char charAt(int index) {
        if (index < 0 || index > value.length - 1) {
            throw new StringIndexOutOfBoundsException();
        }
        return value[index];
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj instanceof String) {
            char[] temp = ((String)(obj)).toCharArray();
            if(temp.length!=value.length) return false;
            for (int i = 0; i < this.value.length; i++) {
                if(value[i] != temp[i]) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StringEx str1 = new StringEx("abc".toCharArray());
        StringEx str2 = new StringEx("def".toCharArray());
        System.out.println(str1.equals("ab"));
//        System.out.println(str2.charAt(-1));
    }

}
