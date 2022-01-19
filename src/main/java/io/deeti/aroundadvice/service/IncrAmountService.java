package io.deeti.aroundadvice.service;

import org.springframework.stereotype.Component;

@Component(value = "ser")
public class IncrAmountService {

	public float simpleInstrest(float p, float t, float r) {
		
		return (p * t * r) / 100.0f;
	}
	
	public float compundInstrest(float p, float t, float r) {
		
		return (float) (p * Math.pow(1 + r / 100.0f, t));
	}
}
