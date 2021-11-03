package calculator;

class StringCalculator {
	private String delimiter;
	private String numbers;
	private int num1;
	public StringCalculator() {
		this.delimiter=",|\n";
	}
	public StringCalculator(String delemeter,String numbers) {
		this.delimiter=delemeter;
		this.numbers=numbers;
	}
    public int add(String input) {
    	StringCalculator calculator;
    	String delimeter=",|\n";
    	
    	if(input.isEmpty())
    		return 0;
    	
    	if(input.length()==1)
        return Integer.parseInt(input);
    	else 
    		if(input.startsWith("//")) {
    		String parts[]=input.split("\n",2);
    		delimiter=parts[0].substring(2);
    		input=parts[1];
    		calculator=new StringCalculator(input, delimeter);
    	}
    		else{
    			calculator=new StringCalculator(input, delimeter);
    		};
    		
    		String numbers[]=input.split(delimiter);
    		return getSum(numbers);
    }

    private int getSum(String[] numbers)
    {
    	checkValidInput(numbers);
    	findDanderInput(numbers);
    	int sum=0;
    	for(String num:numbers)
    	{
    		if(getInt(num)>1000)
    			continue;
    		sum+=getInt(num);
    	}
    	return sum;
    }
    private void checkValidInput(String[] numbers)
    {
    		if(numbers[numbers.length]=="\n")
    			throw new IllegalArgumentException("invalid number found");
    	
    }
    private void findDanderInput(String[] numbers)
    {
    	for(String num:numbers)
    	{
    		if(getInt(num)<0)
    			throw new IllegalArgumentException("negative number found");
    	}
    }
    private int getInt(String str)
    {
    	return Integer.parseInt(str);
    }
}