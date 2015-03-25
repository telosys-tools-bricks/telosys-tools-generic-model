/**
 *  Copyright (C) 2008-2015  Telosys project org. ( http://www.telosys.org/ )
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


public interface JoinColumn {
	
	/**
	 * Returns the column name of the origin side
	 * @return
	 */
	public String getName() ;

	/**
	 * Returns the referenced column name (target side)
	 * @return
	 */
	public String getReferencedColumnName() ;

	/**
	 * Returns TRUE if 'insertable'
	 * @return
	 */
	public boolean isInsertable() ;
	
	/**
	 * Returns TRUE if 'nullable'
	 * @return
	 */
	public boolean isNullable() ;

	/**
	 * Returns TRUE if 'unique'
	 * @return
	 */
	public boolean isUnique() ;

	/**
	 * Returns TRUE if 'updatable'
	 * @return
	 */
	public boolean isUpdatable() ;

}
