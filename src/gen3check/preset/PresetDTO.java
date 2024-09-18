package gen3check.preset;

import java.util.List;

public class PresetDTO {
	private Integer pokemonId;
	private Integer HP;
	 private Integer Attack_minus;
	 private Integer Attack_neutral;
	 private Integer Attack_plus;
	 private Integer Defense_minus;
	 private Integer Defense_neutral;
	 private Integer Defense_plus;
	 private Integer SpAtk_minus;
	 private Integer SpAtk_neutral;
	 private Integer SpAtk_plus;
	 private Integer SpDef_minus;
	 private Integer SpDef_neutral;
	 private Integer SpDef_plus;
	 private Integer Speed_minus;
	 private Integer Speed_neutral;
	 private Integer Speed_plus;
	 private Integer min_frame;
	 private Integer max_frame;
	private List<Boolean> natures;
	
	public PresetDTO() {
	
	};
	
	public PresetDTO(Integer pokemonId,
			 Integer HP,
			 Integer Attack_minus,
			 Integer Attack_neutral,
			 Integer Attack_plus,
			 Integer Defense_minus,
			 Integer Defense_neutral,
			 Integer Defense_plus,
			 Integer SpAtk_minus,
			 Integer SpAtk_neutral,
			 Integer SpAtk_plus,
			 Integer SpDef_minus,
			 Integer SpDef_neutral,
			 Integer SpDef_plus,
			 Integer Speed_minus,
			 Integer Speed_neutral,
			 Integer Speed_plus,
			 Integer min_frame,
			 Integer max_frame,
			 List<Boolean> natures) {
		// TODO Auto-generated constructor stub
		this.pokemonId = pokemonId;
		this.HP = HP;
		this.Attack_minus = Attack_minus;
		this.Attack_neutral = Attack_neutral;
		this.Attack_plus = Attack_plus;
		this.Defense_minus = Defense_minus;
		this.Defense_neutral = Defense_neutral;
		this.Defense_plus = Defense_plus;
		this.SpAtk_minus = SpAtk_minus;
		this.SpAtk_neutral = SpAtk_neutral;
		this.SpAtk_plus = SpAtk_plus;
		this.SpDef_minus = SpDef_minus;
		this.SpDef_neutral = SpDef_neutral;
		this.SpDef_plus = SpDef_plus;
		this.Speed_minus = Speed_minus;
		this.Speed_neutral = Speed_neutral;
		this.Speed_plus = Speed_plus;
		this.min_frame = min_frame;
		this.max_frame = max_frame;
		this.setNatures(natures);
	}
	
	public Integer getHP() {
		return HP;
	}
	public void setHP(Integer hP) {
		HP = hP;
	}
	public Integer getAttack_minus() {
		return Attack_minus;
	}
	public void setAttack_minus(Integer attack_minus) {
		Attack_minus = attack_minus;
	}
	public Integer getAttack_neutral() {
		return Attack_neutral;
	}
	public void setAttack_neutral(Integer attack_neutral) {
		Attack_neutral = attack_neutral;
	}
	public Integer getAttack_plus() {
		return Attack_plus;
	}
	public void setAttack_plus(Integer attack_plus) {
		Attack_plus = attack_plus;
	}
	public Integer getDefense_minus() {
		return Defense_minus;
	}
	public void setDefense_minus(Integer defense_minus) {
		Defense_minus = defense_minus;
	}
	public Integer getDefense_neutral() {
		return Defense_neutral;
	}
	public void setDefense_neutral(Integer defense_neutral) {
		Defense_neutral = defense_neutral;
	}
	public Integer getDefense_plus() {
		return Defense_plus;
	}
	public void setDefense_plus(Integer defense_plus) {
		Defense_plus = defense_plus;
	}
	public Integer getSpAtk_minus() {
		return SpAtk_minus;
	}
	public void setSpAtk_minus(Integer spAtk_minus) {
		SpAtk_minus = spAtk_minus;
	}
	public Integer getSpAtk_neutral() {
		return SpAtk_neutral;
	}
	public void setSpAtk_neutral(Integer spAtk_neutral) {
		SpAtk_neutral = spAtk_neutral;
	}
	public Integer getSpAtk_plus() {
		return SpAtk_plus;
	}
	public void setSpAtk_plus(Integer spAtk_plus) {
		SpAtk_plus = spAtk_plus;
	}
	public Integer getSpDef_minus() {
		return SpDef_minus;
	}
	public void setSpDef_minus(Integer spDef_minus) {
		SpDef_minus = spDef_minus;
	}
	public Integer getSpDef_neutral() {
		return SpDef_neutral;
	}
	public void setSpDef_neutral(Integer spDef_neutral) {
		SpDef_neutral = spDef_neutral;
	}
	public Integer getSpDef_plus() {
		return SpDef_plus;
	}
	public void setSpDef_plus(Integer spDef_plus) {
		SpDef_plus = spDef_plus;
	}
	public Integer getSpeed_minus() {
		return Speed_minus;
	}
	public void setSpeed_minus(Integer speed_minus) {
		Speed_minus = speed_minus;
	}
	public Integer getSpeed_neutral() {
		return Speed_neutral;
	}
	public void setSpeed_neutral(Integer speed_neutral) {
		Speed_neutral = speed_neutral;
	}
	public Integer getSpeed_plus() {
		return Speed_plus;
	}
	public void setSpeed_plus(Integer speed_plus) {
		Speed_plus = speed_plus;
	}
	public Integer getMin_frame() {
		return min_frame;
	}
	public void setMin_frame(Integer min_frame) {
		this.min_frame = min_frame;
	}
	public Integer getMax_frame() {
		return max_frame;
	}
	public void setMax_frame(Integer max_frame) {
		this.max_frame = max_frame;
	}
	public List<Boolean> getNatures() {
		return natures;
	}
	public void setNatures(List<Boolean> natures) {
		this.natures = natures;
	}

	@Override
	public String toString() {
		return "PresetDTO [pokemonId=" + getPokemonId() + ", HP=" + HP + ", Attack_minus=" + Attack_minus
				+ ", Attack_neutral=" + Attack_neutral + ", Attack_plus=" + Attack_plus + ", Defense_minus="
				+ Defense_minus + ", Defense_neutral=" + Defense_neutral + ", Defense_plus=" + Defense_plus
				+ ", SpAtk_minus=" + SpAtk_minus + ", SpAtk_neutral=" + SpAtk_neutral + ", SpAtk_plus=" + SpAtk_plus
				+ ", SpDef_minus=" + SpDef_minus + ", SpDef_neutral=" + SpDef_neutral + ", SpDef_plus=" + SpDef_plus
				+ ", Speed_minus=" + Speed_minus + ", Speed_neutral=" + Speed_neutral + ", Speed_plus=" + Speed_plus
				+ ", min_frame=" + min_frame + ", max_frame=" + max_frame + ", natures=" + natures + "]";
	}

	public Integer getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}
	
}
