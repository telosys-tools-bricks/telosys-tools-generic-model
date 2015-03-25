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

import java.util.List;

/**
 * @author Laurent Guerin
 *
 */
public interface Link {

	/**
	 * Returns the unique id of the link in the repository (id used by the tool)
	 * @return
	 */
	public String getId() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the 'join columns' for the link 
	 * NB : can be null if the link doesn't have 'join columns'
	 * @return
	 */
	public List<JoinColumn> getJoinColumns() ;
	
	//-------------------------------------------------------------------------------------
	/**
	 * Returns the name of the target table (table referenced by the link) 
	 * Can be null (if no database schema)
	 * @return
	 */
	public String getTargetTableName() ;
	
	//--------------------------------------------------------------------------
	/**
	 * Returns the short class name of the target entity <br>
	 * ie "Book", "Customer", ... 
	 * @return
	 */
	public String getTargetEntityClassName() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the field name for the link (attribute field name in the entity class)
	 * e.g. : "book", "customer", "books", "customers", ...
	 * @return
	 */
	public String getFieldName() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the type of the link <br>
	 * If the type is a collection the full type is returned ( e.g. 'java.util.List', 'java.util.Set',...) <br>
	 * If the type is an entity the simple type is returned ( 'Person', 'Customer', 'Book', ... ) <br>
	 * For OneToMany/ManyToMany : the collection type ( 'java.util.List', ...) <br>
	 * For ManyToOne/OneToOne   : the targeted entity short type ( 'Person', 'Customer', ... ) <br>
	 * @return
	 */
	public String getFieldType() ;
	
	//-------------------------------------------------------------------------------------
	/**
	 * Returns TRUE if the link is the 'Owning Side' of the relationship between 2 entities
	 * @return
	 */
	public boolean isOwningSide() ;

	/**
	 * Returns the name of the link in the 'owning side' <br>
	 * Typically for JPA 'mappedBy' <br>
	 * Can be null 
	 * @return
	 */
	public String getMappedBy() ;

	//--------------------------------------------------------------------------
	/**
	 * Returns TRUE if the link is selected (check-box checked in the GUI)
	 * @return
	 */
	public boolean isSelected() ; 
	
	//--------------------------------------------------------------------------
	/**
	 * Returns the name of the table name <br>
	 * Can be null (if no database schema)
	 * @return
	 */
	public String getSourceTableName() ;

	//--------------------------------------------------------------------------
	/**
	 * Returns TRUE if the link is the 'Inverse Side' of the relationship between 2 entities
	 * @return
	 */
	public boolean isInverseSide() ;

	/**
	 * Returns the link id of the inverse side <br>
	 * Can be null if no inverse side 
	 * @return
	 */
	public String getInverseSideLinkId() ;
	
	//--------------------------------------------------------------------------
//	/**
//	 * Returns optional value : "TRUE"/"FALSE"/"UNDEFINED"
//	 * @return
//	 */
//	public String getOptional() ;
//
//	public boolean isOptionalTrue() ;
//
//	public boolean isOptionalFalse() ;
//
//	public boolean isOptionalUndefined() ;

	public Optional getOptional() ;
	//--------------------------------------------------------------------------
//	/**
//	 * Returns the cardinality of the link : "OneToMany", "ManyToOne", "OneToOne", "ManyToMany" 
//	 * @return
//	 */
//	public String getCardinality() ;
//
//	public boolean isTypeOneToOne() ;
//
//	public boolean isTypeOneToMany() ;
//
//	public boolean isTypeManyToOne() ;
//
//	public boolean isTypeManyToMany() ;

	/**
	 * Returns the cardinality of the link : "OneToMany" or "ManyToOne" or "OneToOne" or "ManyToMany" 
	 * @return
	 */
	public Cardinality getCardinality() ;
	
	//--------------------------------------------------------------------------
//	/**
//	 * Returns the 'cascade type' of the link : "ALL", "MERGE", "PERSIST", "REFRESH", "REMOVE" <br>
//	 * The cascade type is cumulative, e.g. "MERGE PERSIST"
//	 * @return
//	 */
//	public String getCascade() ;
//
//	public boolean isCascadeALL() ;
//
//	public boolean isCascadeMERGE() ;
//
//	public boolean isCascadePERSIST() ;
//
//	public boolean isCascadeREFRESH() ;
//
//	public boolean isCascadeREMOVE() ;

	/**
	 * Returns the cascade options of the link : "ALL", "MERGE", "PERSIST", "REFRESH", "REMOVE" <br>
	 * Can be null if no 'cascade options'
	 * @return
	 */
	public CascadeOptions getCascadeOptions() ;
	
	//--------------------------------------------------------------------------
//	/**
//	 * Returns 'fetch property' of the link : "DEFAULT" or "EAGER" or "LAZY"
//	 * @return
//	 */
//	public String getFetch() ;
//
//	public boolean isFetchDEFAULT() ;
//	
//	public boolean isFetchEAGER() ;
//
//	public boolean isFetchLAZY() ;
	
	/**
	 * Returns the 'fetch type' of the link : "DEFAULT" or "EAGER" or "LAZY"
	 * @return
	 */
	public FetchType getFetchType() ;
	
	//--------------------------------------------------------------------------
	// FOREIGN KEY management
	//--------------------------------------------------------------------------
	public boolean isBasedOnForeignKey() ;
	
	/**
	 * Returns the name of the Foreign Key used to generate the link <br>
	 * There's no guarantee that this Foreign Key still exist
	 * @return
	 */
	public String getForeignKeyName() ;
	

	//--------------------------------------------------------------------------
	// JOIN TABLE management
	//--------------------------------------------------------------------------
	public boolean isBasedOnJoinTable() ;

	/**
	 * Returns the 'join table' object for the link <br>
	 * NB : can be null if the link doesn't have a 'join table'
	 * @return
	 */
	public JoinTable getJoinTable() ;

	/**
	 * Returns the name of the Join Table used to generate the link <br>
	 * NB : can be null if the link doesn't have a 'join table'
	 * @return
	 */
	public String getJoinTableName() ;

	//--------------------------------------------------------------------------
	/**
	 * Returns a string that can be used to compare 2 fields, and to know if they are different or identical<br>
	 * NB : all the significant fields must be in this string !
	 * @return
	 */
	public String getComparableString() ; 
	
}
