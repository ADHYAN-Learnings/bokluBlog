package org.framework.select;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FormSelect {
	
	public Map<String,String> statusSelectTag() {
		Map<String,String> status = new HashMap<String,String>();
		status.put("Active", "Active");
		status.put("Inactive", "Inactive");
		
		return status;
	}
	
	public Map<Integer,String> sequenceSelectTag() {
		Map<Integer,String> sequence = new HashMap<Integer,String>();
		sequence.put(0, "--SELECT--");
		for(int i=1;i<=50;i++) {
			sequence.put(i, Integer.toString(i));
		}
		return sequence;
	}

}
