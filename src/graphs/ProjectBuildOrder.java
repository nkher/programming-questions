package CareerCup.Google.Latest;

import java.util.ArrayList;
import java.util.HashSet;


public class ProjectBuildOrder {
	
	HashSet<Project> inProcess, buildDone;
	
	public ProjectBuildOrder() {
		inProcess = new HashSet<Project>();
		buildDone = new HashSet<Project>();
	}
	
	public void build(ArrayList<Project> projects) {
		
		if (projects.size() == 0) { // no projects to build
			return;
		}
		
		for (Project p : projects) {
			
			if (buildDone.contains(p)) {
				return; // or continue
			}
			
			if (!inProcess.isEmpty() && inProcess.contains(p)) {
				/* Build the project t*/
				buildProject(p); 
				inProcess.remove(p); // remove from inprocess
				buildDone.add(p); // add to build done
				return; // or continue
			}
			
			/* Else add to inProcess */
			inProcess.add(p);
			/* build its dependencies by recursing */
			build(p.dependencies);
			/* Build the project */
			buildProject(p);
			inProcess.remove(p);
			buildDone.add(p);
		}
	}
	
	public void buildProject(Project p) {
		System.out.println("Building project : " + p.name);
	}
	
	public static void main(String[] args) {
		
		Project a = new Project('a');
		Project b = new Project('b');
		Project c = new Project('c');
		Project d = new Project('d');
		
		a.addDepen(b);
		b.addDepen(c);
		b.addDepen(d);
		c.addDepen(d);
		
		ArrayList<Project> projects = new ArrayList<Project>();
		projects.add(a);
		projects.add(b);
		projects.add(c);
		projects.add(d);
		
		ProjectBuildOrder pbo = new ProjectBuildOrder();
		pbo.build(projects);
	}

}

class Project {
	
	char name;
	ArrayList<Project> dependencies;
	
	public Project(char name) {
		this.name = name;
		dependencies = new ArrayList<Project>();
	}
	
	public Project() {
		dependencies = new ArrayList<Project>();
	}
	
	public void addDepen(Project p) {
		dependencies.add(p);
	}
}