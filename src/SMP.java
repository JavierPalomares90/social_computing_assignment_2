import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SMP {
	private static String MEN = "M";
	private static String WOMEN = "W";

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
		//TODO: Complete implementation

	}

	public static Map<Integer,Integer> SMP(int[][][] weights, String direction)
	{
		int[][] men;
		int[][] women;
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
			return null;
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
			int woman = getPreferredWoman(man,proposals);
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
		// TODO: Complete implementation
		return false;
	}

	private static int getPreferredWoman(int man, boolean[][] proposals)
	{
		// TODO: Complete implementation
		return -1;

	}
}
