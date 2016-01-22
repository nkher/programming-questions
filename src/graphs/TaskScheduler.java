package graphs;

import java.util.HashSet;
import java.util.Set;

import datastructures.Task;

public class TaskScheduler {
	
	Set<Task> tasks, executed, inProcess;
	
	public TaskScheduler(Set<Task> tasks) {
		this.tasks = tasks;
		executed = new HashSet<Task>();
		inProcess = new HashSet<Task>();
	}
	
	public Set<Task> getTasks() {
		return this.tasks;
	}
	
	/*  if we hit a cycle, i.e., the inProcess set has already had that element, just execute that element first. */
	public void schedule(Set<Task> tasks) {
		
		if (tasks.size() == 0) return;
		
		for (Task t : tasks) {
			if (executed.contains(t)) { // means already executed
				continue;
			}
			if (!inProcess.isEmpty() && inProcess.contains(t) ) {
				t.run();
				inProcess.remove(t);
				executed.add(t);
				continue;
			}
			inProcess.add(t);
			schedule(t.getDependencies());
			t.run(); // the task with zero dependencies runs first
			inProcess.remove(t);
			executed.add(t);
		}
	}

	public static void main(String args[]) {
				
		Job A = new Job("A");
		Job B = new Job("B");
		Job C = new Job("C");
		Job D = new Job("D");
		
		A.addDependency(B);
		A.addDependency(C);
		B.addDependency(C);
		D.addDependency(A);
		
		Set<Task> tasks = new HashSet<Task>();
		tasks.add(A);
		tasks.add(B);
		tasks.add(C);
		tasks.add(D);
		
		TaskScheduler taskScheduler = new TaskScheduler(tasks);
		taskScheduler.schedule(taskScheduler.getTasks());
				
	}
}

class Job implements Task {
	
	String name;
	Set<Job> dependencies;
	
	public Job(String name) {
		this.name = name;
		dependencies = new HashSet<Job>();
	}
	
	public boolean addDependency(Job job) {
		return dependencies.add(job);
	}
	
	public void run() {
		System.out.println("Running Job : " + name);
	}

	public Set<Task> getDependencies() {
		Set<Task> set = new HashSet<Task>();
		for (Job job : dependencies) {
			set.add(job);
		}
		return set;
	}	
}
