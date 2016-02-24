import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GridLayoutFrame extends JFrame implements ActionListener
{
	private final JButton[] buttons;
	private static final String[] names = {"###", ".", "###", ".", ".", "###", "###", ".", "."};
	//private boolean toggle = true;
	private final Container container;
	private final GridLayout gridLayout;
	private boolean[] on = { true, false, true, false, false, true, true, false, false };
	private boolean won;
	// default constructor
	public GridLayoutFrame()
	{
		super("Lights out!");
		gridLayout = new GridLayout(3, 3, 5, 5);
		container = getContentPane();
		setLayout(gridLayout);
		buttons = new JButton[names.length];
		won = false;
		
		for (int i = 0; i < names.length; i++)
		{
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);// register listener
			add(buttons[i]);// add button to the JFrame
		}
		// for button text, use the text data member!
	}
	
	// handle button events by toggling between layouts
	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object src = event.getSource();
		if (src == buttons[0])// if the top left button was clicked
		{
			on[0] = !on[0];// switching each boolean value to the opposite
			on[1] = !on[1];
			on[3] = !on[3];
		}
		else if (src == buttons[1])// if the top middle button was clicked
		{
			on[1] = !on[1];// switching each boolean value to the opposite
			on[0] = !on[0];
			on[2] = !on[2];
			on[4] = !on[4];
		}
		else if (src == buttons[2])// if the top right button was clicked
		{
			on[2] = !on[2];// switching each boolean value to the opposite
			on[1] = !on[1];
			on[5] = !on[5];
		}
		else if (src == buttons[3])// if the left button was clicked
		{
			on[3] = !on[3];// switching each boolean value to the opposite
			on[0] = !on[0];
			on[4] = !on[4];
			on[6] = !on[6];
		}
		else if (src == buttons[4])// if the middle button was clicked
		{
			on[4] = !on[4];// switching each boolean value to the opposite
			on[1] = !on[1];
			on[3] = !on[3];
			on[5] = !on[5];
			on[7] = !on[7];
		}
		else if (src == buttons[5])// if the right button was clicked
		{
			on[5] = !on[5];// switching each boolean value to the opposite
			on[2] = !on[2];
			on[4] = !on[4];
			on[8] = !on[8];
		}
		else if (src == buttons[6])// if the bottom left button was clicked
		{
			on[6] = !on[6];// switching each boolean value to the opposite
			on[3] = !on[3];
			on[7] = !on[7];
		}
		else if (src == buttons[7])// if the bottom button was clicked
		{
			on[7] = !on[7];// switching each boolean value to the opposite
			on[4] = !on[4];
			on[6] = !on[6];
			on[8] = !on[8];
		}
		else// if the bottom right button was clicked
		{
			on[8] = !on[8];// switching each boolean value to the opposite
			on[5] = !on[5];
			on[7] = !on[7];
		}
		// now, time to set each button's text to match its on/off value
		won = true;
		for (int i = 0; i < 9; i++)
		{
			if (on[i] == true)
				buttons[i].setText("###");
			else
			{
				buttons[i].setText(".");
				won = false;
			}
		}
		if (won == true)
		{
			JOptionPane.showMessageDialog(
					null,
					"You won!",
					"Good job!",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		container.validate();// re-lay out the container
	}

}// end class GridLayoutFrame