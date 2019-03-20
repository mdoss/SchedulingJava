import java.util.List;

public class RR implements Algorithm {
	List<Task> queue;
	int timeLeft[];
	int time = 0;
	boolean finished = false;
	int queueSize = 0;
	int quantum = 10;
	
	
	public RR(List<Task> queue)
	{
		this.queue = queue;
		timeLeft = new int[queue.size()];
		for(int i = 0; i < queue.size(); i++)
		{
			timeLeft[i] = queue.get(i).getBurst();
		}
	}
	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		while(!finished)
		{
			finished = true;
			for(int i = 0; i < queue.size(); i++)
			{
				if(timeLeft[i] > 0)
				{
					finished = false;
					if(timeLeft[i] > quantum)
					{
						time += quantum;
						CPU.run(queue.get(i), quantum);
						timeLeft[i] -= quantum;
					}
					else
					{
						time += timeLeft[i];
						CPU.run(queue.get(i), timeLeft[i]);
						timeLeft[i] = 0;
					}
				}
			}
		}
	}

	@Override
	public Task pickNextTask() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
