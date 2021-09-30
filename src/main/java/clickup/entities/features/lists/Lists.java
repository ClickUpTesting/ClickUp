package clickup.entities.features.lists;

import clickup.entities.features.lists.Lisst;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Lists {
	private List<Lisst> lists;

	public void setLists(List<Lisst> lists){
		this.lists = lists;
	}

	public List<Lisst> getLists(){
		return lists;
	}
}