package PM.avg.day0421.sec09.sec06.exam01;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();

        class OkListener implements Button.ClickListener {

            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }

        btnOk.setClickListener(new OkListener());
        btnOk.click();
    }
}
