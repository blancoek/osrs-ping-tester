import java.util.HashMap;
import java.util.List;

public class world {
	
	public int number;
	private Boolean members;
	private int worldtype;
	private String region;
	private Boolean manualset;
	private static HashMap<Integer,String> worldtypes = new HashMap<Integer,String>();
	private static List<String> regions;
	
	static {
		worldtypes.put(0,"Standard");
		worldtypes.put(1,"PvP");
		worldtypes.put(2,"High Risk");
		worldtypes.put(3,"500 Skill Total");
		worldtypes.put(4,"750 Skill Total");
		worldtypes.put(5,"1250 Skill Total");
		worldtypes.put(6,"1500 Skill Total");
		worldtypes.put(7,"1750 Skill Total");
		worldtypes.put(8,"2000 Skill Total");
		worldtypes.put(9,"2200 Skill Total");
		worldtypes.put(10,"Deadman");
		worldtypes.put(11,"Twisted League");
		worldtypes.put(12,"Beta");
		regions.add("AUS");
		regions.add("DE");
		regions.add("UK");
		regions.add("US_E");
		regions.add("US_W");
	}
	
	public world(int number) {
		this.number = number;
		this.members = false;
		this.worldtype = 0;
		this.region = "US_E";
		this.manualset = false;
	}
	
	public void setMembers(Boolean members) {
		this.members = members;
	}
	
	public Boolean getMembers() {
		return this.members;
	}
	
	public void setWorldType(int worldtype) {
		if (worldtypes.containsKey(worldtype)) {
			this.worldtype = worldtype;
			this.manualset = true;
		}
		else {
			System.out.print("Invalid world type "+worldtype+" for world "+this.number);
		}
	}
	
	public String getWorldType() {
		return worldtypes.get(this.worldtype);
	}
	
	public void setRegion(String region) {
		if (regions.contains(region)) {
			this.region = region;
			this.manualset = true;
		}
		else {
			System.out.print("Invalid region "+region+" for world "+this.number);
		}
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public Boolean isManuallySet() {
		return this.manualset;
	}
}
