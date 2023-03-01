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
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import org.telosys.tools.generic.model.enums.CascadeOption;

/**
 * Object containing a set of selected 'cascade options'
 * 
 * @author Laurent Guerin
 *
 */
public class CascadeOptions implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final String CASCADE_ALL = "ALL";

	/**
	 * Array indexed by enum value (0 to N), option undefined if null
	 */
	private final EnumSet<CascadeOption> options ;
	
	/**
	 * Constructor : creates an empty set of CascadeOption
	 */
	public CascadeOptions() {
		super();
		this.options = EnumSet.noneOf(CascadeOption.class);
	}

	/**
	 * Add a cascade option (MERGE, PERSIST, ALL, etc) in the set if not already exists
	 * @param cascadeOption
	 */
	public void add(CascadeOption cascadeOption) {
		options.add(cascadeOption);
	}

	/**
	 * Returns TRUE if 'ALL' is in the selected options
	 * @return
	 */
	public boolean isCascadeAll() {
		return options.contains(CascadeOption.ALL);
	}
	
	/**
	 * Returns TRUE if 'MERGE' is in the selected options
	 * @return
	 */
	public boolean isCascadeMerge() {
		return options.contains(CascadeOption.MERGE);
	}
	
	/**
	 * Returns TRUE if 'PERSIST' is in the selected options
	 * @return
	 */
	public boolean isCascadePersist() {
		return options.contains(CascadeOption.PERSIST);
	}
	
	/**
	 * Returns TRUE if 'REFRESH' is in the selected options
	 * @return
	 */
	public boolean isCascadeRefresh() {
		return options.contains(CascadeOption.REFRESH);
	}

	/**
	 * Returns TRUE if 'REMOVE' is in the selected options
	 * @return
	 */
	public boolean isCascadeRemove() {
		return options.contains(CascadeOption.REMOVE);
	}
	
	public List<CascadeOption> getActiveOptions() {
		LinkedList<CascadeOption> list = new LinkedList<>() ;
		for ( CascadeOption o : options ) {
			list.add(o);
		}
		return list;
	}
	
	public int size() {
		return options.size();
	}
	
	public boolean isEmpty() {
		return options.isEmpty();
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
			StringBuilder sb = new StringBuilder();
			for ( CascadeOption c : options ) {
				if ( c != null ) {
					if ( count > 0 ) {
						sb.append(" ");
					}
					sb.append(c.getLongText());
					count++;
				}
			}
			return sb.toString();
		}
	}
}
