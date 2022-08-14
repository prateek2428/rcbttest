package rcbtest.team;



import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TeamRCBTest{
	int countForaignPlayers=0;
	int countWicketKeeper=0;
	
	
	@BeforeTest
	public  void RCBTeamData() throws IOException, ParseException {
		
		JSONParser jSONParser = new JSONParser ();
		FileReader reader = new FileReader(".\\Rcbteamtest\\TeamRCB.json");
		Object object=jSONParser.parse(reader);
		JSONObject rcbobject=(JSONObject)object;
		JSONArray teamrcb=(JSONArray)rcbobject.get("player");
		System.out.print("Rcb has" +" "+teamrcb.size()+" "+"Players.");
		
		for (int i =0;i<teamrcb.size();i++) 
			
		{
			JSONObject player=(JSONObject)teamrcb.get(i);
			String countryname=(String)player.get("country");
			if (!countryname.equals("India")) 
			{
				countForaignPlayers++;
			}
			
			String role=(String)player.get("role");
			
			if (role.equals("Wicket-keeper")) 
			{		
				countWicketKeeper++;
			}
			}
			
		}

		
	 @Test(priority= 1)
		public  void ValidateOnly4ForeignPlayers() {
			Assert.assertEquals(4, countForaignPlayers);
			System.out.print("It has" +" "+ countForaignPlayers+" "+"Foreign Players");
		}
           @Test(priority= 2)
		public void validateAtleast1WicketKeeper() {
			Assert.assertEquals(1, countWicketKeeper);
			System.out.println(" and"+" " + countWicketKeeper +" "+"Wicket-Keeper.");

			
		}}
