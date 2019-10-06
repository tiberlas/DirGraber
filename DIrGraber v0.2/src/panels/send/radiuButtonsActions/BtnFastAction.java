package panels.send.radiuButtonsActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SpeedTransfer;

@SuppressWarnings("serial")
public class BtnFastAction extends AbstractAction{

	@SuppressWarnings("unused")
	private SpeedTransfer speed;
	
	public BtnFastAction(SpeedTransfer speed) {
		this.speed = speed;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		speed = SpeedTransfer.FAST;
	}
}
