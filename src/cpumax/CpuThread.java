package cpumax;

public class CpuThread
{
  private volatile boolean isRunning;
  
  public void start()
  {
    isRunning = true;
    thread.setPriority(Thread.MIN_PRIORITY);
    thread.start();
  }
  
  public void stop() {
    isRunning = false;
  }
  
  private void run()
  {
    while (isRunning) {
      // Busy wait
    }
  }
  
  
  private Thread thread = new Thread(new Runnable()
  { 
    @Override
    public void run()
    {
      CpuThread.this.run();
    }
  });
}
