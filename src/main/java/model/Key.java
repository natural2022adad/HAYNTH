package model;

public class Key {
	private String key;
	private int numKey;
	
	public Key (String key, int numKey){
		this.key = key;
		this.numKey = numKey;
	}
	
	public Key (String key){
		this.key = key;
		this.numKey = 0;
	}
	
	public Key (int numKey){
		this.key = null;
		this.numKey = numKey;
	}
	
	public Key (){
		this.key = null;
		this.numKey = 0;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getNumKey() {
		return numKey;
	}
	public void setNumKey(int numKey) {
		this.numKey = numKey;
	}
}
