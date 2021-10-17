package calculator;

class StringCalculator {

    public int add(String input) {
    	String numbers[]=input.split(",|\n");
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
    		sum+=getInt(num);
    	}
    	return sum;
    }
    
    private int getInt(String str)
    {
    	return Integer.parseInt(str);
    }
}