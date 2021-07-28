package example;

import java.io.*;
import java.util.ArrayList;

public class App extends Thread {

  private char message;

  public App(char greeting){ this.message = greeting; }

  @Override
  public void run()
  {
    try{
      Thread.sleep(500);
    } catch(Exception e) {}

    StringBuffer sb = new StringBuffer();
    sb.append("Current Thread: ");
    sb.append(Thread.currentThread().getName());
    sb.append(" message: ");
    sb.append(this.message);
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    ArrayList<App> th = new ArrayList<App>();
    char[] greeting = {'H','e','l','l','o',' ','W','o','r','l','d'};
    for (char x : greeting) {
      App app = new App(x);
      th.add(app);
    }

    for (App appThread : th) {
      appThread.start();
      try{
        appThread.join();
      } catch (Exception e) {}
    }
  }
}
