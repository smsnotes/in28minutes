package com.in28minutes.rest.webservices.restfullwebservices.work;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class WorkerV2DaoService {


	private static List<WorkerV2> workers = new ArrayList<>();
	private static int workersCount ;

	static {
		workers.add(new WorkerV2( Level.ARCHITECT ,1010,10,"AdamV2",new Date()));
		workers.add(new WorkerV2(Level.DEVELOPER, 1020,20,"EveV2",new Date()));
		workers.add(new WorkerV2(Level.MANAGER,  1030,30,"JackV2",new Date()));
		workersCount = workers.size();
	}
	
	public WorkerV2 findOne(int id) {
		for (WorkerV2 worker : workers) {
			if( worker.getId()==id)
				return worker;
		}
		return null;
	}
	
	public WorkerV2 deleteById(int id) {
		Iterator<WorkerV2> iterator = workers.iterator();
		WorkerV2 retWorkerV2 = null;
		while ( iterator.hasNext()) {
			WorkerV2 t = iterator.next();
			if( t.getId()==id) {
				iterator.remove();
				retWorkerV2 = t;
			}
		}
		return retWorkerV2 ;
	}
	
	public List<WorkerV2> findAll() {
		return workers;
	}
	
	public WorkerV2 Save(WorkerV2 worker) {
		if(worker.getId()==null)
			worker.setId(++workersCount);
		
		workers.add(worker);
		return worker;
	}	
	
}
