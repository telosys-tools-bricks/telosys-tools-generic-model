/**
 *  Copyright (C) 2008-2014  Telosys project org. ( http://www.telosys.org/ )
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

import java.util.List;

public interface ForeignKey {

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the name of the Foreign Key
	 * @return
	 */
	public String getName() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the name of the table holding the foreign key
	 * @return
	 */
	public String getTableName() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the name of the referenced table (the table referenced by the foreign key)
	 * @return
	 */
	public String getReferencedTableName() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns all the columns composing the foreign key <br>
	 * (sorted in the original database order)
	 * @return
	 */
	public List<ForeignKeyColumn> getColumns() ;

	//-------------------------------------------------------------------------------------
	// Delete rule, Update rule and Deferrability constraint
	//-------------------------------------------------------------------------------------
	
	/**
	 * Returns the 'DEFERRABILITY' status ( 'NOT DEFERRABLE', 'INITIALLY IMMEDIATE', 'INITIALLY DEFERRED'  )
	 * @return
	 */
	public String getDeferrable() ;

	/**
	 * Returns the 'DEFERRABILITY' status code ( MetaData Code : 5,6,7 ) 
	 * @return
	 */
	public int getDeferrableCode() ;

	/**
	 * Returns the 'ON DELETE' rule ( 'NO ACTION', 'RESTRICT', 'SET NULL', 'SET DEFAULT', 'CASCADE'  )
	 * @return
	 */
	public String getDeleteRule() ;

	/**
	 * Returns the 'ON DELETE' rule code ( MetaData Code : 0,1,2,3,4 )
	 * @return
	 */
	public int getDeleteRuleCode() ;

	/**
	 * Returns the 'ON UPDATE' rule ( 'NO ACTION', 'RESTRICT', 'SET NULL', 'SET DEFAULT', 'CASCADE' ) 
	 * @return
	 */
	public String getUpdateRule() ;

	/**
	 * Returns the 'ON UPDATE' rule code ( MetaData Code : 0,1,2,3,4 )
	 * @return
	 */
	public int getUpdateRuleCode() ;
	

}
