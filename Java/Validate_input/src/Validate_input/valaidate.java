package Validate_input;

public class valaidate {
	public static boolean Isbn(String i)
	{
		return i.matches("[0-9]\\d{2}-[0-9]-[0-9]\\d{1}-[0-9]\\d{5}-[0-9]");
	}
	
	public static boolean table(String t)
	{
		return t.matches("[A-Z][a-z]?");
	}
	public static boolean measurement(String m)
	{
		return m.matches("\\d+ [a-z]+");
	}
	
	public static boolean state(String s)
	{
		return s.matches("MI|FL|NY|CA|PA|NJ|MA|TX");
	}
}

