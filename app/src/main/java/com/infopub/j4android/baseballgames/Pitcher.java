package com.infopub.j4android.baseballgames;

import java.util.Arrays;

public class Pitcher {

	private int[] ball;
	private int m;//���� ���� �� 3
	public Pitcher() {
		this(3);
	}
	public Pitcher(int m) {
		this.m = m;
		ball=new int[m];
	}
	public int[] getBall() {
		return ball;
	}
	private void init(){
		Arrays.fill(ball, -1);//-1�� ä���
	}
	private int makeOne(){//0~9������ ����
		return (int)(Math.random()*10);
	}
	private boolean hasSame(int num){
		boolean isS=false;
		for (int i = 0; i < ball.length; i++) {
			if(ball[i]==num){
				isS=true;
				break;
			}
		}
		return isS;
	}
	public void make(){
		init();
		int count=0;
		while(count!=ball.length){
			int ran=makeOne();
			if(! hasSame(ran)){
				ball[count++]=ran;
			}
		}
	}
}
