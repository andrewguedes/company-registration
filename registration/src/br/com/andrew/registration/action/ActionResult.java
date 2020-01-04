package br.com.andrew.registration.action;

import br.com.andrew.registration.util.ConstantsUtil;

public abstract class ActionResult implements IActionResult {

	private boolean forward = false;
	private boolean redirect = false;
	private String action;
	
	public ActionResult () {}
	
	public boolean isForward() {
		return forward;
	}
	
	private void setForward(boolean forward) {
		this.forward = forward;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	
	private void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public String getAction() {
		return action;
	}
	
	private void setAction(String action) {
		this.action = action;
	}
	
	public ActionResult view() {
		
		return this;
	}
	
	public ActionResult view(String action, String aux) {
		
		if(aux.equals(ConstantsUtil.REDIRECT)) {
			setRedirect(true);
		}else {
			setForward(true);
		}
		
		setAction(action);
		
		return this;
	}

}
