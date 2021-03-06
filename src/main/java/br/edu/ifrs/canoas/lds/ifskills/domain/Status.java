/**
 * @author: Fernando Bandeira Sturzbecher
 * @date: 23/03/16
 * @description: Status for trainer application's waiting approval(or not)
 * 
 * @modified: Aline Gandolfi
 * @date: 14/04/2016
 * @description: Rename to "Status" for general using
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

public enum Status {
	Approved, Waiting, Rejected;
	
	public static Status get(String str){
		if (str.equalsIgnoreCase(Status.Approved.toString()))
			return Status.Approved;
		else if (str.equalsIgnoreCase(Status.Rejected.toString()))
			return Status.Rejected;
		else if (str.equalsIgnoreCase(Status.Waiting.toString()))
			return Status.Waiting;
		return null;
	}

}


