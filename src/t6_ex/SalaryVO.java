package t6_ex;

public class SalaryVO {
	private String jikkub;
	private int bonbong;
	public String getJikkub() {
		return jikkub;
	}
	@Override
	public String toString() {
		return "SalaryVO [bonbong=" + bonbong + ", jikkub=" + jikkub + ", getBonbong()=" + getBonbong()
				+ ", getJikkub()=" + getJikkub() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public void setJikkub(String jikkub) {
		this.jikkub = jikkub;
	}
	public int getBonbong() {
		return bonbong;
	}
	public void setBonbong(int bonbong) {
		this.bonbong = bonbong;
	}
}
