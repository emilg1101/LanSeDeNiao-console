package emilg1101.application;

public interface Application {
    void init(Application application);
    void start();
    void close();
    void onException(Exception e);
}
