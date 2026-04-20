package PM.day0420;

public abstract class FileUploader {
    public void connect() {
        System.out.println("서버에 연결합니다.");
    }

    public abstract void upload();
}
