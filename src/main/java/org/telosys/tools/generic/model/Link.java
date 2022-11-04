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

import java.util.List;

import org.telosys.tools.generic.model.enums.BooleanValue;
import org.telosys.tools.generic.model.enums.Cardinality;
import org.telosys.tools.generic.model.enums.FetchType;
import org.telosys.tools.generic.model.enums.Optional;

/**
 * @author Laurent Guerin
 *
 */
public interface Link {

	/**
	 * Returns the attributes used in the link 
	 * NB : can be null if the link doesn't have 'join attributes'
	 * @return
	 */
	public List<LinkAttribute> getAttributes() ; // v 3.4.0
	
	/**
	 * Returns the short class name of the target entity <br>
	 * ie "Book", "Customer", ... 
	 * @return
	 */
	public String getReferencedEntityName(); // v 3.4.0
	
	/**
	 * Returns the field name for the link (attribute field name in the entity class)
	 * e.g. : "book", "customer", "books", "customers", ...
	 * @return
	 */
	public String getFieldName() ;

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

	/**
	 * Returns TRUE if the link is selected (check-box checked in the GUI)
	 * @return
	 */
	public boolean isSelected() ; 
	
	/**
	 * Returns TRUE if the link is the 'Inverse Side' of the relationship between 2 entities
	 * @return
	 */
	public boolean isInverseSide() ;

	/**
	 * Returns Optional value for this link 
	 * @return
	 */
	public Optional getOptional() ;

	/**
	 * Returns the cardinality of the link : "OneToMany" or "ManyToOne" or "OneToOne" or "ManyToMany" 
	 * @return
	 */
	public Cardinality getCardinality() ;
	
	/**
	 * Returns the cascade options of the link : "ALL", "MERGE", "PERSIST", "REFRESH", "REMOVE" <br>
	 * Can be null if no 'cascade options'
	 * @return
	 */
	public CascadeOptions getCascadeOptions() ;
	
	/**
	 * Returns the 'fetch type' of the link : "DEFAULT" or "EAGER" or "LAZY"
	 * @return
	 */
	public FetchType getFetchType() ;
	
	//--------------------------------------------------------------------------
	// FOREIGN KEY management
	//--------------------------------------------------------------------------
	/**
	 * Returns true if the link is based on a 'foreign key'
	 * @return
	 */
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
	/**
	 * Returns true if the link is based on a 'join entity'
	 * @return
	 */
	public boolean isBasedOnJoinEntity() ; // v 3.4.0

	/**
	 * Returns the name of the Join Table used to generate the link <br>
	 * NB : can be null if the link doesn't have a 'join entity'
	 * @return
	 */
	public String getJoinEntityName() ; // v 3.4.0

	//--------------------------------------------------------------------------
	/**
	 * Returns TRUE if the entity referenced by the link is embedded (useful for NoSQL databases)<br>
	 * If not supported by the model implementation : 'false' 
	 * @return
	 */
	public boolean isEmbedded() ;
	
	/**
	 * Returns TRUE if the link field is 'transient' (useful for JPA)<br>
	 * If not supported by the model implementation : 'false' 
	 * @return
	 * @since v 3.3.0
	 */
	public boolean isTransient() ; // v 3.3.0
	
    /**
     * Returns the 'insertable' flag values
     * @return
	 * @since v 3.3.0
     */
    public BooleanValue getInsertable() ; // v 3.3.0
    
    /**
     * Returns the 'updatable' flag values
     * @return
	 * @since v 3.3.0
     */
    public BooleanValue getUpdatable() ; // v 3.3.0
    
    
	/**
	 * Returns all the tags defined in the link
	 * @return
	 * @since v 3.4.0
	 */
	public TagContainer getTagContainer(); // v 3.4.0
	
	/**
	 * Returns TRUE if the link is marked as 'OrphanRemoval' (useful for ORM like JPA or Doctrine)<br>
	 * @return
	 * @since v 4.1.0
	 */
	public boolean isOrphanRemoval() ; // v 4.1.0
}
