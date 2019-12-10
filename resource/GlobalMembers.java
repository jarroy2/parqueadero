/**
 * 
 */

/**
 * @author Jonathan Arroyo
 *
 */
public class GlobalMembers {
	public static int Main()
	{
	  int casos;
	  //fstream cin("parking.in");
	  casos = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
	  //cout << "Lei casos: " << casos << endl;
	  boolean primerCaso = true;

	  while (casos-- != 0)
	  {
		ArrayList<carro> carros = new ArrayList<carro>();
		if (!primerCaso)
		{
			System.out.print("\n");
		}
		primerCaso = false;
		int id;
		while ((id != 0 && id != 99 = Boolean.parseBoolean(ConsoleInput.readToWhiteSpace(true))).length() > 0)
		{
		  //cout << "Lei id: " << id << endl;
		  carros.add(new carro(id, id, false));
		}

		/*cout << "Voy a imprimir carros:" << endl;
		for (int i=0; i<carros.size(); ++i){
		    cout << carros[i].id << "-"<<carros[i].donde<<endl;
		}*/

		String line;
		line = new Scanner(System.in).nextLine();
		while (line = new Scanner(System.in).nextLine() && !line.equals(""))
		{
		  stringstream ss = new stringstream(line);
		  int salio;
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
		  ss >> salio;
		  //cout << "Lei salio: " << salio << endl;

		  int posClosest = 9999;
		  int minDistance = 9999;
		  for (int i = 0; i < carros.size(); ++i)
		  {
			  int d;
			  if (!carros.get(i).parked)
			  {

				if (carros.get(i).donde <= salio)
				{
					d = salio - carros.get(i).donde;
				}
				else
				{
					d = (salio + 20) - carros.get(i).donde;
				}
				if (d < minDistance)
				{
					  minDistance = d;
					  posClosest = i;
				}
			  }
		  }
		  //cout << "minDistance es " << minDistance << endl;
		  //cout << "PosClosest es " << posClosest << endl;
		  if (posClosest == 9999)
			  continue;
		  carros.get(posClosest).parked = true;
		   carros.get(posClosest).donde = salio;

		  for (int i = 0; i < carros.size(); ++i)
		  {
			if (!carros.get(i).parked)
			{
			  int d = carros.get(i).donde + minDistance;
			  while (d > 20)
			  {
				  d -= 20;
			  }
			  carros.get(i).donde = d;
			}
		  }

		  /*cout << "Voy a imprimir carros:" << endl;
		  for (int i=0; i<carros.size(); ++i){
		    cout << carros[i].id << "-"<<carros[i].donde<<endl;
		  }*/
		}
		for (int i = 0; i < carros.size(); ++i)
		{
		  System.out.print("Original position ");
		  System.out.print(carros.get(i).id);
		  System.out.print(" ");
		  if (carros.get(i).parked)
		  {
			System.out.print("parked in ");
			System.out.print(carros.get(i).donde);
			System.out.print("\n");
		  }
		  else
		  {
			System.out.print("did not park");
			System.out.print("\n");
		  }
		}
	  }
	  return 0;
	}
}

public class carro
{
	   public int id;
	   public int donde;
	   public boolean parked;
	   public carro(int ID, int Donde, boolean Parked)
	   {
		 id = ID;
		 donde = Donde;
		 parked = Parked;
	   }
}

package tangible;

//----------------------------------------------------------------------------------------
//	Copyright © 2006 - 2015 Tangible Software Solutions Inc.
//	This class can be used by anyone provided that the copyright notice remains intact.
//
//	This class provides the ability to convert basic C++ 'cin' behavior.
//----------------------------------------------------------------------------------------
public final class ConsoleInput
{
	private static boolean goodLastRead = false;
	public static boolean lastReadWasGood()
	{
		return goodLastRead;
	}

	public static String readToWhiteSpace(boolean skipLeadingWhiteSpace)
	{
		String input = "";
		char nextChar;
		while (Character.isWhitespace(nextChar = (char)System.in.read()))
		{
			//accumulate leading white space if skipLeadingWhiteSpace is false:
			if (!skipLeadingWhiteSpace)
			{
				input += nextChar;
			}
		}
		//the first non white space character:
		input += nextChar;

		//accumulate characters until white space is reached:
		while (!Character.isWhitespace(nextChar = (char)System.in.read()))
		{
			input += nextChar;
		}

		goodLastRead = input.length() > 0;
		return input;
	}

	public static String scanfRead()
	{
		return scanfRead(null, -1);
	}

	public static String scanfRead(String unwantedSequence)
	{
		return scanfRead(unwantedSequence, -1);
	}

	public static String scanfRead(String unwantedSequence, int maxFieldLength)
	{
		String input = "";

		char nextChar;
		if (unwantedSequence != null)
		{
			nextChar = '\0';
			for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
			{
				if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
				{
					//ignore all subsequent white space:
					while (Character.isWhitespace(nextChar = (char)System.in.read()))
					{
					}
				}
				else
				{
					//ensure each character matches the expected character in the sequence:
					nextChar = (char)System.in.read();
					if (nextChar != unwantedSequence.charAt(charIndex))
						return null;
				}
			}

			input = (new Character(nextChar)).toString();
			if (maxFieldLength == 1)
				return input;
		}

		while (!Character.isWhitespace(nextChar = (char)System.in.read()))
		{
			input += nextChar;
			if (maxFieldLength == input.length())
				return input;
		}

		return input;
	}

}
