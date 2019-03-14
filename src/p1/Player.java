package p1;

public class Player {
private String name;
private int score=0;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getScore() {
	return score;
}
public Player(String name) {
	super();
	this.name = name;
}
public void setScore(int score) {
	this.score = score;
}
public Player()
{
	this.name=null;
}
}
