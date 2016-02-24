//Joshua Hale Java Final


import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Driver
{

	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(
				null,
				"Welcome to Lights Out!\nThe goal is to get all 9 buttons to say '###'\n" +
				"Clicking a button changes that button, along with the buttons \n" +
				"above, below, left, and right of it.",
				"Lights Out!",
				JOptionPane.PLAIN_MESSAGE);
			GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
			gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gridLayoutFrame.setSize(300, 200);
			gridLayoutFrame.setVisible(true);
	}

}