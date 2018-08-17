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
package org.telosys.tools.generic.model.types;

import java.util.LinkedList;
import java.util.List;

/**
 * All neutral types used in the generic model <br>
 * 
 * @author Laurent Guerin
 *
 */
public final class NeutralType {

    private NeutralType(){}

    // Neutral type list of predefined names
    public static final String STRING    = "string";
    
    public static final String BYTE      = "byte"; 
    public static final String SHORT     = "short"; 
    public static final String INTEGER   = "int"; 
    public static final String LONG      = "long"; 
    
    public static final String DECIMAL   = "decimal";
    public static final String FLOAT     = "float";
    public static final String DOUBLE    = "double";
    
    public static final String BOOLEAN   = "boolean";
    
    public static final String DATE      = "date";
    public static final String TIME      = "time";
    public static final String TIMESTAMP = "timestamp";
    
    public static final String BINARY   = "binary";   // BLOB
    // public static final String LONGTEXT = "longtext"; // CLOB
    
    /**
     * Returns all the neutral types
     * @return
     */
    public static final List<String> getAllNeutralTypes() {
    	List<String> list = new LinkedList<>();
    	
    	list.add(STRING);
    	
    	list.add(BYTE);
    	list.add(SHORT);
    	list.add(INTEGER);
    	list.add(LONG);
    	
    	list.add(DECIMAL);
    	list.add(FLOAT);
    	list.add(DOUBLE);
    	
    	list.add(BOOLEAN);
    	
    	list.add(DATE);
    	list.add(TIME);
    	list.add(TIMESTAMP);
    	
    	list.add(BINARY);
    	
    	return list ;
    }

}
