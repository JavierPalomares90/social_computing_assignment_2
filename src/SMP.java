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
		SMP(weights,direction);
	}

	public static int[] SMP(int[][][] weights, String direction)
	{

		return null;
	}
}
