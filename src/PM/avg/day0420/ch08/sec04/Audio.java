package PM.avg.day0420.ch08.sec04;

public class Audio implements RemoteControl {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        if (volume > MAX_VOLUME) this.volume = RemoteControl.MAX_VOLUME;
        else if (volume < MIN_VOLUME) this.volume = RemoteControl.MIN_VOLUME;

        System.out.println("현재 Audio 볼륨: " + this.volume);
    }
}
