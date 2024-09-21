package gen3check.preset;

public class ScoreWeights {
	 private int time_weight;
	 private int HP_weight;
	 private int Attack_weight;
	 private int Defense_weight;
	 private int SpAtk_weight;
	 private int SpDef_weight;
	 private int Speed_weight;
	 
	 public ScoreWeights(int runType)
	 {
		 //initialize as fire red round 2
		 if(runType ==1)
		 {
			 time_weight = 7;
			 HP_weight = 11;
			 Attack_weight = 5;
			 Defense_weight = 9;
			 SpAtk_weight = 0;
			 SpDef_weight = 1;
			 Speed_weight = 5;
		 }
		 else
		 {
			 time_weight = 7;
			 HP_weight = 10;
			 Attack_weight = 4;
			 Defense_weight = 10;
			 SpAtk_weight = 0;
			 SpDef_weight = 1;
			 Speed_weight = 12;

		 }
		 
//		 frameScoreWeight = 7; //negative
//			hpScoreWeight = 11;
//			defScoreWeight = 9;
//			atkScoreWeight = 5;
//			speScoreWeight = 5; //negative
//			spdScoreWeight = 1;
	 }
	 
	public ScoreWeights(int time_weight,
			int hp_weight,
			int attack_weight,
			int defense_weight,
			int spAtk_weight,
			int spDef_weight,
			int speed_weight) {
		this.time_weight = time_weight;
		this.HP_weight = hp_weight;
		this.Attack_weight = attack_weight;
		this.Defense_weight = defense_weight;
		this.SpAtk_weight = spAtk_weight;
		this.SpDef_weight = spDef_weight;
		this.Speed_weight = speed_weight;
	}
	public int getTime_weight() {
		return time_weight;
	}
	public void setTime_weight(int time_weight) {
		this.time_weight = time_weight;
	}
	public int getHP_weight() {
		return HP_weight;
	}
	public void setHP_weight(int hP_weight) {
		HP_weight = hP_weight;
	}
	public int getAttack_weight() {
		return Attack_weight;
	}
	public void setAttack_weight(int attack_weight) {
		Attack_weight = attack_weight;
	}
	public int getDefense_weight() {
		return Defense_weight;
	}
	public void setDefense_weight(int defense_weight) {
		Defense_weight = defense_weight;
	}
	public int getSpAtk_weight() {
		return SpAtk_weight;
	}
	public void setSpAtk_weight(int spAtk_weight) {
		SpAtk_weight = spAtk_weight;
	}
	public int getSpDef_weight() {
		return SpDef_weight;
	}
	public void setSpDef_weight(int spDef_weight) {
		SpDef_weight = spDef_weight;
	}
	public int getSpeed_weight() {
		return Speed_weight;
	}
	public void setSpeed_weight(int speed_weight) {
		Speed_weight = speed_weight;
	}
	
	
	public double getTankyScore(int hp, int def)
	{
		return (Math.min(31,22)*Math.min(31,22))/4;
	}
	
	public int getTotalScore(int runType)
	{
		int dblSpeedScore = runType == 1 ? 0 : 15;
		
		return
				
		 (int)this.getTankyScore(31, 31)+
		 HP_weight * 31+
		 Attack_weight * 31+
		 Defense_weight * 31+
		 SpAtk_weight * 31+
		 SpDef_weight * 31+
		 Speed_weight * 31+
		 dblSpeedScore * 4 +
		 this.getNatureScore("Rash");
	}
	
	
	
	
	private int getNatureScore(String nature) {
		return nature.equals("Rash") ? 150 : 0;
	}

	@Override
	public String toString() {
		return "ScoreWeights [time_weight=" + time_weight + ", HP_weight=" + HP_weight + ", Attack_weight="
				+ Attack_weight + ", Defense_weight=" + Defense_weight + ", SpAtk_weight=" + SpAtk_weight
				+ ", SpDef_weight=" + SpDef_weight + ", Speed_weight=" + Speed_weight + "]";
	}
	 
	 
}
