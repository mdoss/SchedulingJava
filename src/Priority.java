import java.util.List;

public class Priority implements Algorithm {
	List<Task> queue;
	public Priority(List<Task> queue)
	{
		this.queue = queue;
		
	}
	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		while(!queue.isEmpty())
		{
			Task task = pickNextTask();
			CPU.run(task, task.getBurst());
		}
	}

	@Override
	public Task pickNextTask() {
		// TODO Auto-generated method stub
		int highPrio = 0;
		Task nextTask = null;
		for(int i = 0; i < queue.size(); i++)
		{
			if (queue.get(i).getPriority() > highPrio)
			{
				nextTask = queue.get(i);
				highPrio = nextTask.getPriority();
			}
		}
		queue.remove(nextTask);
		return nextTask;
	}

}
