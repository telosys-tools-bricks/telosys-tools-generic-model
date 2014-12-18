package org.telosys.tools.generic.model;

public class CascadeOptions {
	
	private final static String CASCADE_ALL = "ALL";

//	private boolean cascadeALL = false ;
	private final CascadeOption cascadeOptions[] = new CascadeOption[CascadeOption.values().length];
	
	/**
	 * Add a cascade option : MERGE, PERSIST, ALL, etc
	 * @param cascadeType
	 */
	public void add(CascadeOption cascadeType) {
		cascadeOptions[cascadeType.getValue()] = cascadeType ;
	}

//	public void setALL() {
//		this.cascadeALL = true ;
//	}
	
	public boolean isCascadeAll() {
		return cascadeOptions[CascadeOption.ALL.getValue()] == CascadeOption.ALL ;
	}
	public boolean isCascadeMerge() {
		return cascadeOptions[CascadeOption.MERGE.getValue()] == CascadeOption.MERGE ;
	}
	public boolean isCascadePersist() {
		return cascadeOptions[CascadeOption.PERSIST.getValue()] == CascadeOption.PERSIST ;
	}
	public boolean isCascadeRefresh() {
		return cascadeOptions[CascadeOption.REFRESH.getValue()] == CascadeOption.REFRESH ;
	}
	public boolean isCascadeRemove() {
		return cascadeOptions[CascadeOption.REMOVE.getValue()] == CascadeOption.REMOVE ;
	}
	
	public String toString() {
		if ( this.isCascadeAll() ) {
			return CASCADE_ALL ;
		}
		else {		
			int count = 0 ;
			StringBuffer sb = new StringBuffer();
			for ( CascadeOption c : cascadeOptions ) {
				if ( c != null ) {
					if ( count > 0 ) {
						sb.append(" ");
					}
					sb.append(c.getText());
					count++;
				}
			}
			return sb.toString();
		}
	}
}
