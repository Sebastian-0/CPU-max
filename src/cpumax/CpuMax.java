package cpumax;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class CpuMax extends JFrame
{
  private List<CpuThread> threads;
  
  public CpuMax() 
  {
    super ("CPU test");
    
    startThreads();
    
    JLabel label = new JLabel("Performing intensity tests, close to stop");
    label.setBorder(new EmptyBorder(20, 20, 20, 20));
    getContentPane().add(label);
    
    pack();
    
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  private void startThreads()
  {
    threads = new ArrayList<CpuThread>();
        
    int amountOfCores = Runtime.getRuntime().availableProcessors();
    for (int i = 0; i < amountOfCores; i++)
    {
      CpuThread thread = new CpuThread();
      thread.start();
      threads.add(thread);
    }
  }
  
  
  @Override
  public void dispose()
  {
    super.dispose();
    for (CpuThread cpuThread : threads)
    {
      cpuThread.stop();
    }
  }
  
  
  public static void main(String[] args)
  {
    new CpuMax();
  }
}
