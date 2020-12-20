package com.infopub.j4android.baseballgames;

public class Empire {
	private int [] pit;
	private int [] hit;
	
	public Empire(int m) {
		pit=new int[m];
		hit=new int[m];
	}
	public Empire() {
		this(3);
	}
	public int[] getPit() {
		return pit;
	}
	public void setPit(int[] pit) {
		this.pit = pit;
	}
	public int[] getHit() {
		return hit;
	}
	public void setHit(int[] hit) {
		this.hit = hit;
	}
	public int strike(){
		int count=0;
		for (int i = 0; i < hit.length; i++) {
			if(hit[i]==pit[i]){count++;}
		}
		return count;
	}
	//ball의 수
	public int ball(){
		int count=0;
		for (int i = 0; i < hit.length; i++) {
			for (int j = 0; j < hit.length; j++) {
				if( i!=j  && hit[i]==pit[j]){count++;}
			}
		}
		return count;
	}
}
