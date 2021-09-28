package clickup.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DueDates{
	@JsonProperty("remap_due_dates")
	private boolean remapDueDates;
	@JsonProperty("remap_closed_due_date")
	private boolean remapClosedDueDate;
	private boolean enabled;
	@JsonProperty("start_date")
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
