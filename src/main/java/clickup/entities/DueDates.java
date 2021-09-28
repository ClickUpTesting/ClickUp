package clickup.entities;

public class DueDates{
	private boolean remapDueDates;
	private boolean remapClosedDueDate;
	private boolean enabled;
	private boolean startDate;

	public void setRemapDueDates(boolean remapDueDates){
		this.remapDueDates = remapDueDates;
	}

	public boolean isRemapDueDates(){
		return remapDueDates;
	}

	public void setRemapClosedDueDate(boolean remapClosedDueDate){
		this.remapClosedDueDate = remapClosedDueDate;
	}

	public boolean isRemapClosedDueDate(){
		return remapClosedDueDate;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setStartDate(boolean startDate){
		this.startDate = startDate;
	}

	public boolean isStartDate(){
		return startDate;
	}
}
