import java.util.List;

public class tester {
	private static List<world> worldlist;
	static {
		for (int i=301; i<=538; i++) {
			world currentworld = new world(i);
			worldlist.add(currentworld);
			// Set Regions
			if (List.of(387,388,389,390,391,392,412,424,425,426,427,526,527,528,529,530,535,536).contains(i)) { // Australian Worlds
				currentworld.setRegion("AUS");
			}
			if (List.of(303,304,311,312,327,328,335,336,343,344,351,352,359,360,367,368,375,376,383,384,395,396,397,398,399,405,406,413,414,447,448,449,450,451,452,453,454,455,456,457,458,459,462,463,464,465,466).contains(i)) { // German Worlds
				currentworld.setRegion("DE");
			}
			if (List.of(302,308,309,310,316,317,318,325,326,333,334,341,342,349,350,358,364,365,366,371,372,373,379,380,381,382,407,408,497,498,499,500,501,502,503,504,512,513,514,515,516,517,518,519,520,521,522,523,524,525,538).contains(i)) { // UK Worlds
				currentworld.setRegion("UK");
			}
			if (List.of(301,305,314,321,322,329,330,337,345,346,353,354,361,362,369,370,377,385,386,393,394,400,401,402,403,404,415,416,417,467,468,469,470,471,472,473,474,475,476,477,491,492,493,494,495,496).contains(i)) { // US East Worlds
				currentworld.setRegion("US_E");
			}
			if (List.of(306,307,313,315,319,320,323,324,331,332,338,339,340,347,348,355,356,357,374,378,409,410,411,418,419,420,421,422,428,429,430,431,432,433,434,435,436,437,438,439,440,443,444,445,446).contains(i)) { // US West Worlds
				currentworld.setRegion("US_W");
			}
			// Set Membership
			if (!List.of(301,308,316,326,335,372,379,380,381,382,383,384,385,393,394,397,398,399,413,414,417,418,419,425,426,427,430,431,432,433,434,435,436,437,438,439,440,451,452,453,454,455,456,457,458,459,468,469,470,471,472,473,474,475,476,477,497,498,499,500,501,502,503,504,530).contains(i)) { // Easier with non-members worlds since they're less
				currentworld.setMembers(true);
			}
			// Set Types
			if (List.of(324,325,337,371,392).contains(i)) { // PvP
				currentworld.setWorldType(1);
			}
			if (i==365) { // High Risk
				currentworld.setWorldType(2);
			}
			if (List.of(381,413,419,427,468).contains(i)) { // 500
				currentworld.setWorldType(3);
			}
			if (List.of(372,385,414,432,530).contains(i)) { // 750
				currentworld.setWorldType(4);
			}
			if (List.of(353,364,429,447,529).contains(i)) { // 1250
				currentworld.setWorldType(5);
			}
			if (List.of(366,416,420,448,528).contains(i)) { // 1500
				currentworld.setWorldType(6);
			}
			if (List.of(373,391,449,467).contains(i)) { // 1750
				currentworld.setWorldType(7);
			}
			if (List.of(349,361,396,428,527).contains(i)) { // 2000
				currentworld.setWorldType(8);
			}
			if (List.of(415,450,526).contains(i)) { // 2200
				currentworld.setWorldType(9);
			}
			if (i==345) { // Deadman
				currentworld.setWorldType(10);
			}
			if (List.of(400,401,402,403,404,405,406,407,408,409,410,411,412,443,462,463,512,535,536).contains(i)) { // Twisted League
				currentworld.setWorldType(1);
			}
			if (i==538) { // Beta
				currentworld.setWorldType(12);
			}
		}
		
	}
	
}
