/**
 *  Copyright (C) 2008-2017  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.generic.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Object containing a set of selected 'cascade options'
 * 
 * @author Laurent Guerin
 *
 */
public class CascadeOptions implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final static String CASCADE_ALL = "ALL";

	private final CascadeOption cascadeOptions[] = new CascadeOption[CascadeOption.values().length];
	
	/**
	 * Add a cascade option : MERGE, PERSIST, ALL, etc
	 * @param cascadeType
	 */
	public void add(CascadeOption cascadeType) {
		cascadeOptions[cascadeType.getValue()] = cascadeType ;
	}

	/**
	 * Returns TRUE if 'ALL' is in the selected options
	 * @return
	 */
	public boolean isCascadeAll() {
		return cascadeOptions[CascadeOption.ALL.getValue()] == CascadeOption.ALL ;
	}
	
	/**
	 * Returns TRUE if 'MERGE' is in the selected options
	 * @return
	 */
	public boolean isCascadeMerge() {
		return cascadeOptions[CascadeOption.MERGE.getValue()] == CascadeOption.MERGE ;
	}
	
	/**
	 * Returns TRUE if 'PERSIST' is in the selected options
	 * @return
	 */
	public boolean isCascadePersist() {
		return cascadeOptions[CascadeOption.PERSIST.getValue()] == CascadeOption.PERSIST ;
	}
	
	/**
	 * Returns TRUE if 'REFRESH' is in the selected options
	 * @return
	 */
	public boolean isCascadeRefresh() {
		return cascadeOptions[CascadeOption.REFRESH.getValue()] == CascadeOption.REFRESH ;
	}

	/**
	 * Returns TRUE if 'REMOVE' is in the selected options
	 * @return
	 */
	public boolean isCascadeRemove() {
		return cascadeOptions[CascadeOption.REMOVE.getValue()] == CascadeOption.REMOVE ;
	}
	
	public List<CascadeOption> getActiveOptions() {
		LinkedList<CascadeOption> list = new LinkedList<CascadeOption>() ;
		for ( CascadeOption cascadeOption : cascadeOptions ) {
			if ( cascadeOption != null ) {
				list.add(cascadeOption);
			}
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
