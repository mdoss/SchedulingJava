import java.util.ArrayList;
import java.util.List;

public class PriorityRR implements Algorithm {
	List<Task> queue;
	List<List<Task>> queues;
	int timeLeft[];
	int time = 0;
	boolean finished = false;
	int queueSize = 0;
	int quantum = 10;
	List<Task> copy;
	
	public PriorityRR(List<Task> queue)
	{
		this.queue = queue;
		copy = new ArrayList<Task>(queue);
		queues = new ArrayList<List<Task>>();
		createQueues();
		
	}
	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		for(int k = 0; k < queues.size(); k++)
		{
			while(!finished)
			{
				finished = true;
				for(int i = 0; i < queues.get(k).size(); i++)
				{
					if(queues.get(k).get(i).getTimeLeft() > 0)
					{
						finished = false;
						if(queues.get(k).get(i).getTimeLeft() > quantum)
						{
							time += quantum;
							CPU.run(queues.get(k).get(i), quantum);
							queues.get(k).get(i).setTimeLeft(queues.get(k).get(i).getTimeLeft() - quantum);
						}
						else
						{
							time += queues.get(k).get(i).getTimeLeft();
							CPU.run(queues.get(k).get(i), queues.get(k).get(i).getTimeLeft());
							queues.get(k).get(i).setTimeLeft(0);
						}
					}
				}
			}
			finished = false;
		}
	}

	@Override
	public Task pickNextTask() {
		// TODO Auto-generated method stub
		
		return null;
	}
	private void createQueues()
	{
		while(!queue.isEmpty())
		{
			int highPrio = queue.get(0).getPriority();
			for(int i = 1; i < queue.size(); i++)
			{
				if (queue.get(i).getPriority() > highPrio)
				{
					highPrio = queue.get(i).getPriority();
				}
			}
			List<Task> temp = new ArrayList<Task>();
			for(int i = 0; i < copy.size(); i++)
			{
				//System.out.println(copy.size());
				if(copy.get(i).getPriority() == highPrio)
				{
					temp.add(copy.get(i));
					
					queue.remove(copy.get(i));
				}
			}
			queues.add(temp);
		}
	}

}
