import java.util.List;

public class FCFS implements Algorithm {

	List<Task> queue;
	int index = 0;
	public FCFS(List<Task> queue)
	{
		this.queue = queue;
	}
	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		while(index < queue.size())
		{
			Task task = pickNextTask();
			CPU.run(task, task.getBurst());
		}
	}

	@Override
	public Task pickNextTask() {
		// TODO Auto-generated method stub
		
		return queue.get(index++);

	}

}
