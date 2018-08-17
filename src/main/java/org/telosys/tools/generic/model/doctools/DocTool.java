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
package org.telosys.tools.generic.model.doctools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.telosys.tools.generic.model.types.TypeConverter;
import org.telosys.tools.generic.model.types.TypeConverterForCSharp;
import org.telosys.tools.generic.model.types.TypeConverterForGo;
import org.telosys.tools.generic.model.types.TypeConverterForJava;

public class DocTool {

	public static void main(String[] args) {
		printDoc("html/lang-types-java.html", new TypeConverterForJava() ) ;
		printDoc("html/lang-types-go.html", new TypeConverterForGo() ) ;
		printDoc("html/lang-types-csharp.html", new TypeConverterForCSharp() ) ;
	}
	
	public static void printDoc(String fileName, TypeConverter typeConverter ) {
		
		System.out.println("Print doc : " + fileName );
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			
			TypeConvertersDoc tcd = new TypeConvertersDoc( typeConverter, writer);		
			tcd.printDoc();
			
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
