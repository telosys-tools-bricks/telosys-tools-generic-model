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

import org.telosys.tools.generic.model.types.LiteralValuesProvider;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForCSharp;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForGo;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForJava;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForJavaScript;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForPython;
import org.telosys.tools.generic.model.types.LiteralValuesProviderForTypeScript;
import org.telosys.tools.generic.model.types.TypeConverter;
import org.telosys.tools.generic.model.types.TypeConverterForCSharp;
import org.telosys.tools.generic.model.types.TypeConverterForGo;
import org.telosys.tools.generic.model.types.TypeConverterForJava;
import org.telosys.tools.generic.model.types.TypeConverterForJavaScript;
import org.telosys.tools.generic.model.types.TypeConverterForPython;
import org.telosys.tools.generic.model.types.TypeConverterForTypeScript;

public class DocTool {

	public static void main(String[] args) {
		printDoc("html/lang-types-java.html", new TypeConverterForJava(), new LiteralValuesProviderForJava() ) ;
		printDoc("html/lang-types-go.html", new TypeConverterForGo(), new LiteralValuesProviderForGo()  ) ;
		printDoc("html/lang-types-csharp.html", new TypeConverterForCSharp(), new LiteralValuesProviderForCSharp()  ) ;
		printDoc("html/lang-types-typescript.html", new TypeConverterForTypeScript(), new LiteralValuesProviderForTypeScript() ) ;
		
		printDoc("html/lang-types-python.html", new TypeConverterForPython(), new LiteralValuesProviderForPython()) ;
		printDoc("html/lang-types-javascript.html", new TypeConverterForJavaScript(), new LiteralValuesProviderForJavaScript()) ;
	}
	
	public static void printDoc(String fileName, TypeConverter typeConverter, LiteralValuesProvider literalValuesProvider ) {
		
		System.out.println("Print doc : " + fileName );
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			
			TypeConvertersDoc tcd = new TypeConvertersDoc( typeConverter, literalValuesProvider, writer);		
			tcd.printDoc();
			
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
