# CPU-max
The only thing this program does is that it determines how many CPU cores you have and then starts one thread for each core. The threads are set to be of low priority and the only thing they do is performing a busy-wait (a while(true) loop).

The program has a window that appears when you start it. If you close it all the threads will terminate automatically.
