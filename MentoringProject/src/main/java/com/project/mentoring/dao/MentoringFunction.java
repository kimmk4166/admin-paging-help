package com.project.mentoring.dao;

import java.util.Random;

public class MentoringFunction {
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(89999);
	}
}
