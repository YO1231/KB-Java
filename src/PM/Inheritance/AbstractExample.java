package PM.Inheritance;

public class AbstractExample {
    public static void startUpload(FileUploader imageUploader) {
        imageUploader.upload();
    }

    public static void main(String[] args) {
        AbstractExample.startUpload(new ImageUploader());
        AbstractExample.startUpload(new VideoUploader());
    }
}
