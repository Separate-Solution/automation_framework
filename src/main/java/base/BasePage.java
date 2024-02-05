package base;

public class BasePage {
    protected void wait(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds*1000);
        }catch (InterruptedException interruptedException){
            System.out.println(interruptedException.getMessage());
        }
    }
}
