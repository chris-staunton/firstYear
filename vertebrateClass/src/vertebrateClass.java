import javax.swing.JOptionPane;

public class vertebrateClass {
	public static void main(String[] args) {
		
		int answer1 = JOptionPane.showConfirmDialog(null, "Is the vertebrate cold blooded?");
		
		boolean coldBlooded = (answer1 == JOptionPane.YES_OPTION);
		
		if (coldBlooded == true)
		{
			int answer2 = JOptionPane.showConfirmDialog(null, "Is the vertebrate covered in scales?");
			
			boolean outerCovering = (answer2 == JOptionPane.YES_OPTION);
			
			if (outerCovering == true)
			{
				int answer3 = JOptionPane.showConfirmDialog(null, "Does the vertebrate have fins?");
				boolean fins = (answer3 == JOptionPane.YES_OPTION);
				if (fins == true)
				{
					JOptionPane.showMessageDialog(null, "The vertebrate is a fish");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The vertebrate is a reptile");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The vertebrate is an amphibian");
			}
		}
		else
		{
			int answer4 = JOptionPane.showConfirmDialog(null, "Does the vertebrate have feathers?");
			
			boolean outerCovering = (answer4 == JOptionPane.YES_OPTION);
			if (outerCovering == true)
			{
				JOptionPane.showMessageDialog(null, "The vertebrate is a bird");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The vertebrate is a mammal");
			}
		}
	} 

}
