package calculator;

class StringCalculator {
	private final String delimiter=",|\n";
    public int add(String input) {
    	
    	String numbers[]=input.split(delimiter);
    	if(input.isEmpty())
    		return 0;
    	if(input.length()==1)
        return Integer.parseInt(input);
    	else
        return getSum(numbers);
    }

    private int getSum(String[] numbers)
    {
    	int sum=0;
    	for(String num:numbers)
    	{
    		if(getInt(num)<0)
    			throw new IllegalArgumentException("negative number found");
    		sum+=getInt(num);
    	}
    	return sum;
    }
    
    private int getInt(String str)
    {
    	return Integer.parseInt(str);
    }
}