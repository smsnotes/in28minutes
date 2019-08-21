package com.in28minutes.rest.webservices.restfullwebservices.work;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WorkerDaoService {

	private static List<Worker> workers = new ArrayList<>();
	private static int workersCount;

	static {
		workers.add(new Worker(1010,10,"AdamV2",new Date()));
		workers.add(new Worker(1020,20,"EveV2",new Date()));
		workers.add(new Worker(1030,30,"JackV2",new Date()));
		workersCount = workers.size();
	}
	
	public Worker findOne(int id) {
		for (Worker worker : workers) {
			if( worker.getId()==id)
				return worker;
		}
		return null;
	}
	
	public Worker deleteById(int id) {
		Iterator<Worker> iterator = workers.iterator();
		Worker retWorker = null;
		while ( iterator.hasNext()) {
			Worker t = iterator.next();
			if( t.getId()==id) {
				iterator.remove();
				retWorker = t;
			}
		}
		return retWorker ;
	}
	
	public List<Worker> findAll() {
		return workers;
	}
	
	public Worker Save(Worker worker) {
		if(worker.getId()==null)
			worker.setId(++workersCount);
		
		workers.add(worker);
		return worker;
	}	
	
}
