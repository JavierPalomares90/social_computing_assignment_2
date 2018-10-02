import java.util.*;

public class SMP {
	private static String MEN = "m";
	private static String WOMEN = "w";

	public static void main(String[] args)
	{
		if(args.length < 2)
		{
			System.out.println("Usage: SMP [input.txt] [m/w]");
			return;
		}
		String inputFile = args[0];
		String direction = args[1];
		int[][][] weights = Utils.readInputFile(inputFile);
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		Map<Integer,Integer> engagements = SMP(weights,direction);
		printEngagements(engagements);
	}

	private static void printEngagements(Map<Integer,Integer> map)
	{
		Set<Integer> women = map.keySet();
		for(Integer woman : women)
		{
		    Integer man = map.get(woman);
		    System.out.println("(" + man+1 + "," + woman+1 + ")");
		}
	}

	public static Map<Integer,Integer> SMP(int[][][] weights, String direction)
	{
		int[][] men = null;
		int[][] women = null;
		if(MEN.equals(direction))
		{
			men = weights[0];
			women = weights[1];
		}
		else if(WOMEN.equals(direction))
		{
			men = weights[1];
			women = weights[0];
		}
		else
		{
			System.err.println("Please pick m or w for optimal direction");
			System.exit(1);
		}
		return SMP(men,women);
	}

	private static Map<Integer,Integer> SMP(int[][] men, int[][] women)
	{
		Queue<Integer> freeMen = new LinkedList<>();
		// Add all men to the freeList
		int n = men.length;
		for(int i = 0; i < n; i ++)
		{
			freeMen.add(i);
		}
		// matrix of proposals that have been made
		boolean[][] proposals = new boolean[n][n];
		// Map of engagements. The key is the woman.
		Map<Integer,Integer> engagements = new HashMap<>();
		while (freeMen.isEmpty() == false)
		{
			int man = freeMen.remove();
			int woman = getPreferredWoman(men,man,proposals);
			Integer fiance = engagements.get(woman);
			proposals[man][woman] = true;
			if(fiance == null)
			{
				// The woman is free. So now the man and woman are engaged
				engagements.put(woman,man);
			}else
			{
				boolean keepFiance = keepFiance(women,woman,fiance,man);
				if(keepFiance == false)
				{
					// switch the engagements
					engagements.put(woman,man);
					// add old fiance to queue
					freeMen.add(fiance);
				}else
				{
					// add the man back to the queue
					freeMen.add(man);
				}
			}
		}
		return engagements;

	}

	private static boolean keepFiance(int[][] women, int woman, int fiance, int man)
	{
        int[] preferences = women[woman];
        int n = preferences.length;
        for (int i = 0; i < n; i++)
		{
			int j = preferences[i];
			// return true if we see the fiance first
			if(j == fiance)
			{
				return true;
			}
			// return false if we see the man first
			else if (j == man)
			{
				return false;
			}
		}
		return false;
	}

	private static int getPreferredWoman(int[][] men, int man, boolean[][] proposals)
	{
		int[] preferences = men[man];
		int n = preferences.length;
		for (int i = 0; i < n; i++)
		{
			int woman = preferences[i];
			// return the first woman the man has not proposed to
			if(proposals[man][woman] == false)
			{
				return woman;
			}
		}
		return -1;
	}
}
