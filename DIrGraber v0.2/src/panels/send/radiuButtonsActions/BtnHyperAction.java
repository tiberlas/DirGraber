package panels.send.radiuButtonsActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SpeedTransfer;


@SuppressWarnings("serial")
public class BtnHyperAction extends AbstractAction{

	@SuppressWarnings("unused")
	private SpeedTransfer speed;
	
	public BtnHyperAction(SpeedTransfer speed) {
		this.speed = speed;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		speed = SpeedTransfer.SLOW;
	}
}
