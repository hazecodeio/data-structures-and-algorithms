public class SubstringFrequency
{
	public int countOccurrence(String str, String sub, int start, int end, int count)
	{
		if (end>str.length())
		return count;
		
		else
		{
			if(sub.equals(str.substring(start,end)))
			{
				 count++;
			}
			return countOccurrence(str, sub, start+1, end+1, count);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new SubstringFrequency().countOccurrence("Hu am Husain sleh mHuioHu", "Hu", 0, 2, 0));
	}
}