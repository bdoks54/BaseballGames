package com.infopub.j4android.baseballgames;
import java.util.Arrays;
public class Hitter {
	private int[] ball;
	public Hitter() {
		this(3);
	}
	public Hitter(int m) {
		ball=new int[m];
	}
	public int[] getBall() {
		return ball;
	}
	private void init(){
		Arrays.fill(ball, -1);
	}

	private void makeNum(int []num){
		System.arraycopy(num, 0, ball, 0, num.length);
	}
	public void make(int []num){
		init();
		makeNum(num);
	}
}//class hitter
