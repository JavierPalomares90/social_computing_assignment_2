package test;

import org.junit.Test;
import main.java.SMP.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class SMPTest {
	private static String REGEX = "\\d+";

	@Test
	public void test0m()
	{
		String inputFile = "src/test/resources/input.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "m";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// Women are the keys when the direction is "m"
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);
		assertTrue(engagements.get(0) == 3);
		assertTrue(engagements.get(1) == 0);
		assertTrue(engagements.get(2) == 1);
		assertTrue(engagements.get(3) == 2);



	}

	@Test
	public void test0w()
	{
		String inputFile = "src/test/resources/input.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "w";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// men are the keys when the direction is w
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);
		assertTrue(engagements.get(0) == 1);
		assertTrue(engagements.get(1) == 3);
		assertTrue(engagements.get(2) == 2);
		assertTrue(engagements.get(3) == 0);
	}


	@Test
	public void test1m()
	{
		String inputFile = "src/test/resources/test1.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "m";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		// women are the keys when the direction is m
		SMP.printEngagements(engagements);
		assertTrue(engagements.get(0) == 0);
		assertTrue(engagements.get(6) == 1);
		assertTrue(engagements.get(8) == 2);
		assertTrue(engagements.get(4) == 3);
		assertTrue(engagements.get(2) == 4);
		assertTrue(engagements.get(7) == 5);
		assertTrue(engagements.get(9) == 6);
		assertTrue(engagements.get(3) == 7);
		assertTrue(engagements.get(1) == 8);
		assertTrue(engagements.get(5) == 9);

	}

	@Test
	public void test1w()
	{
		String inputFile = "src/test/resources/test1.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "w";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// men are the keys when the direction is w
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);

		assertTrue(engagements.get(0) == 0);
		assertTrue(engagements.get(1) == 1);
		assertTrue(engagements.get(4) == 2);
		assertTrue(engagements.get(7) == 3);
		assertTrue(engagements.get(6) == 4);
		assertTrue(engagements.get(8) == 5);
		assertTrue(engagements.get(3) == 6);
		assertTrue(engagements.get(5) == 7);
		assertTrue(engagements.get(2) == 8);
		assertTrue(engagements.get(9) == 9);


	}

	@Test
	public void test2m()
	{
		String inputFile = "src/test/resources/test2.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "m";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		// women are the keys when the direction is m
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test2m_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}

	private boolean checkSolutions(Map<Integer,Integer> engagements, String file) {
		Pattern pattern = Pattern.compile(REGEX);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				boolean match = matcher.matches();
				Integer i = null;
				Integer j = null;
				while (matcher.find())
				{
					String s = matcher.group();
					if(i == null){
						i = Integer.parseInt(s);
					}else {
						j = Integer.parseInt(s);
					}
				}
				if(engagements.get(j) != i)
				{
					return false;
				}
			}
		}catch (Exception e)
		{
			return false;
		}
		return true;
	}

	@Test
	public void test2w()
	{
		String inputFile = "src/test/resources/test2.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "w";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// men are the keys when the direction is w
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test2w_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}
	@Test
	public void test3m()
	{
		String inputFile = "src/test/resources/test3.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "m";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		// women are the keys when the direction is m
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test3m_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}

	@Test
	public void test3w()
	{
		String inputFile = "src/test/resources/test3.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "w";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// men are the keys when the direction is w
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test3w_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}

	@Test
	public void test4m()
	{
		String inputFile = "src/test/resources/test4.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "m";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		// women are the keys when the direction is m
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test4m_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}

	@Test
	public void test4w()
	{
		String inputFile = "src/test/resources/test4.txt";
		int[][][] weights = Utils.readInputFile(inputFile);
		String direction = "w";
		if(weights == null)
		{
			System.err.println("Input file is malformed");
		}
		// men are the keys when the direction is w
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);
		SMP.printEngagements(engagements);
		String solutionsFile = "src/test/resources/test4w_sol.txt";
		assertTrue(checkSolutions(engagements,solutionsFile));

	}

}
