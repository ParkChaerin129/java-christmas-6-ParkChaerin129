package christmas;

import christmas.controller.PlayEvent;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        AppConfig appConfig = new AppConfig();

        PlayEvent playEvent = appConfig.playEvent();
        playEvent.playEvent();

    }
}
