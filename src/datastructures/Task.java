package datastructures;

import java.util.Set;

public interface Task {
	public void run();
	Set<Task> getDependencies();
}
