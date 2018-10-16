package test;

import org.junit.Test;
import main.java.SMP.*;

import java.util.Map;

public class SMPTest {

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
		Map<Integer,Integer> engagements = SMP.SMP(weights,direction);

	}

	@Test
	public void test1()
	{
		String inputFile = "src/test/resources/Test_cases/test1.txt";

	}

	@Test
	public void test2()
	{
		String inputFile = "src/test/resources/Test_cases/test2.txt";

	}

	@Test
	public void test3()
	{
		String inputFile = "src/test/resources/Test_cases/test3.txt";

	}

	@Test
	public void test4()
	{
		String inputFile = "src/test/resources/Test_cases/test4.txt";

	}

}
