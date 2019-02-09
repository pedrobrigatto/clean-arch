package br.com.pb.business.core;

public enum Metric {
	
	Idle(100),
	Queue(10);
	
	private int value;
	
	Metric (int value) {
		this.value = value;
	}
	
	public int standardValue () {
		return this.value;
	}

	public static boolean isValid(String name) {
		return Idle.name().contentEquals(name) || Queue.name().contentEquals(name);
	}

	public static Metric from(String key) {
		Metric metric = Queue;
		if (Queue.name().contentEquals(key)) {
			metric = Queue;
		}
		return metric;
	}
}
