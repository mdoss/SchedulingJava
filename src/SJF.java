import java.util.List;

public class SJF implements Algorithm {
	List<Task> queue;
	public SJF(List<Task> queue)
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
		int sj = 100;
		Task nextTask = null;
		for(int i = 0; i < queue.size(); i++)
		{
			if (queue.get(i).getBurst() < sj)
			{
				nextTask = queue.get(i);
				sj = nextTask.getBurst();
			}
		}
		queue.remove(nextTask);
		return nextTask;
	}

}
