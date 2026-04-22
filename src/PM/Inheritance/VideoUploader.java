package PM.Inheritance;

public class VideoUploader extends FileUploader {

    @Override
    public void upload() {
        System.out.println("VideoUploader");
    }
}
