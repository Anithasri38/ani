package webapp.Assignments;

public class SimpleInterest {
	private int Amount;
	private int Rate;
	private int Time;
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	public int getTime() {
		return Time;
	}
	public void setTime(int time) {
		this.Time = Time;
	}
	public double calSimpleInterest()
	{
		return (getAmount()*getRate()*getTime())/100;
	}
}
