package Seminar2.server.repository;

public interface IRepo {
    void saveInLog(String text);
    String readLog();
    String getHistory();
}
