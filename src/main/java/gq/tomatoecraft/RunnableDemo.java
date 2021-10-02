package gq.tomatoecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunnableDemo implements Runnable{
    private Thread t;
    private String cmd;
    public RunnableDemo(String cmd){
        this.cmd = cmd;
        start();
    }
    
    public void start(){
        //Initialize the thread
        if(this.t == null){
            this.t = new Thread(this);
            this.t.start();
        }
    }

    public void run(){
        try{
            Runtime run = Runtime.getRuntime();
            //Executes the process
            Process process = run.exec(this.cmd);
            process.waitFor();

            //The output reader of the program
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
            System.out.println("Thread interrupted");
        }
        catch(IOException e){
            System.out.println(e.getLocalizedMessage());
            System.out.println("IOException occured");
        }
    }
    
}