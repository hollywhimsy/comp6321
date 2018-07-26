package centerServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import common.Logger;

public class HealthChecker extends Thread
{
	private List<HashMap<String, Integer>> ports = new ArrayList<>();
	private List<HashMap<String, Integer>> alives = new ArrayList<>(); // 0 -> dead, 1 -> alive
	private Logger logger;
	private int myGroupIndex;
	private String myCity;
	
	public HealthChecker(List<HashMap<String, Integer>> ports, List<HashMap<String, Integer>> alives, Logger logger, String myCity, int myGroupIndex)
	{
		super();
		this.ports = ports;
		this.alives = alives;
		this.logger = logger;
		this.myGroupIndex = myGroupIndex;
		this.myCity = myCity.trim().toUpperCase();
	}
	
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(3000);
			} catch (InterruptedException e1)
			{
				//e1.printStackTrace();
			}
			
			updateAlivesList();	
		}
	}
	
	private void updateAlivesList()
	{
		for (int i = 0; i < 3; i++)
		{
			for (String srv : alives.get(i).keySet())
			{
				if ((srv.toUpperCase().equals(myCity)) && (i == myGroupIndex))
				{
					continue;
				}
				
				if(alives.get(i).get(srv) == 1)
				{
					RudpClient client = new RudpClient(ports.get(i).get(srv), myCity, logger);
					String result = client.requestRemote("HeartBit").trim();
	
					if (result.equals("DWN"))
					{
						alives.get(i).put(srv, 0); // this server is down	
						logger.logToFile(myCity + "[HealthCheker.updateAlivesList()]: Heartbit cheked for " + srv + " listening on " 
								+ ports.get(i).get(srv) + ". Result: Dead");
					}
					else
					{
						logger.logToFile(myCity + "[HealthCheker.updateAlivesList()]: Heartbit cheked for " + srv + " listening on " 
								+ ports.get(i).get(srv) + ". Result: Live");
					}
				}				
			}
		}		
	}
}
