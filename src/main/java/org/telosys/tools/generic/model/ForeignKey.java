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

/**
 * Definition of a database foreign key
 * 
 * @author Laurent Guerin
 * @since 2.0.0  (changes in v 3.4.0)
 * 
 */
public interface ForeignKey {

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the name of the Foreign Key
	 * @return
	 */
	public String getName() ;

    public String getOriginEntityName() ;
    
    public String getReferencedEntityName() ;

    public List<ForeignKeyAttribute> getAttributes();
    
    public boolean isComposite();

}
